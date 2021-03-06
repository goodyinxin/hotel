package com.example.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.HotelDay;
import com.example.hotel.entity.HotelOrder;
import com.example.hotel.mapper.HotelOrderMapper;
import com.example.hotel.mapper.HoterRoomMapper;
import com.example.hotel.utils.PageInfo;
import com.example.hotel.utils.Result;
import com.example.hotel.utils.SnowflakeIdWorker;
import com.example.hotel.utils.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HotelOrderService {

    @Autowired
    private HotelOrderMapper hotelOrderMapper;
    @Autowired
    private SnowflakeIdWorker sequence;



    public Result save(HotelOrder bean) {
        Result result = new Result();
        return result;
    }


    public Result list(PageInfo info) {
        Page<HotelOrder> page = new Page<>(info.getPagenum(),info.getPagesize());
        QueryWrapper<HotelOrder> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(info.getQuery())){
            wrapper.like("order_code",info.getQuery());
        }
        IPage<HotelOrder> userIPage = hotelOrderMapper.selectPage(page,wrapper);
        Result result = new Result();
        result.getData().add(userIPage);
        return  result;

    }


    public Result load(Long id) {
        Result result = new Result();
        HotelOrder hotelOrder = hotelOrderMapper.selectById(id);
        if(hotelOrder == null){
            result.setCode(State.FAIL.INFO());
            result.setMsg("查询失败");
        }
        result.setCode(State.OK.INFO());
        result.setMsg("查询成功");
        result.setData(Arrays.asList(hotelOrder));
        return result;
    }
}
