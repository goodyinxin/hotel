package com.example.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.HotelOrder;
import com.example.hotel.entity.HotelRoom;
import com.example.hotel.mapper.HoterRoomMapper;
import com.example.hotel.utils.PageInfo;
import com.example.hotel.utils.Result;
import com.example.hotel.utils.SnowflakeIdWorker;
import com.example.hotel.utils.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HotelRoomService {

    @Autowired
    private HoterRoomMapper hoterRoomMapper;
    @Autowired
    private SnowflakeIdWorker sequence;


    public Result list(PageInfo info) {
        Page<HotelRoom> page = new Page<>(info.getPagenum(),info.getPagesize());
        QueryWrapper<HotelRoom> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(info.getQuery())){
            wrapper.like("room_name",info.getQuery());
        }
        IPage<HotelRoom> userIPage = hoterRoomMapper.selectPage(page,wrapper);
        Result result = new Result();
        result.getData().add(userIPage);
        return  result;

    }


    public Result load(Long id) {
        Result result = new Result();
        HotelRoom hotelRoom = hoterRoomMapper.selectById(id);
        if(hotelRoom == null){
            result.setCode(State.FAIL.INFO());
            result.setMsg("查询失败");
        }
        result.setCode(State.OK.INFO());
        result.setMsg("查询成功");
        result.setData(Arrays.asList(hotelRoom));
        return result;
    }

}
