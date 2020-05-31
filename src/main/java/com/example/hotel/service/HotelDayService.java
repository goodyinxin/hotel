package com.example.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.HotelDay;
import com.example.hotel.entity.User;
import com.example.hotel.mapper.HotelDayMapper;
import com.example.hotel.mapper.HoterRoomMapper;
import com.example.hotel.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HotelDayService {


    @Autowired
    private HotelDayMapper hotelDayMapper;
    @Autowired
    private SnowflakeIdWorker sequence;



    public Result list(PageInfo info) {
        Page<HotelDay> page = new Page<>(info.getPagenum(),info.getPagesize());
        QueryWrapper<HotelDay> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(info.getQuery())){
            wrapper.like("day_date",info.getQuery());
        }
        IPage<HotelDay> userIPage = hotelDayMapper.selectPage(page,wrapper);
        Result result = new Result();
        result.getData().add(userIPage);
        return  result;

    }


    public Result load(Long id) {
        Result result = new Result();
        HotelDay hotelDay = hotelDayMapper.selectById(id);
        if(hotelDay == null){
            result.setCode(State.FAIL.INFO());
            result.setMsg("查询失败");
        }
        result.setCode(State.OK.INFO());
        result.setMsg("查询成功");
        result.setData(Arrays.asList(hotelDay));
        return result;
    }

}
