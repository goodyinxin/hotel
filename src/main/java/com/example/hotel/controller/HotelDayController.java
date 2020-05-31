package com.example.hotel.controller;

import com.example.hotel.service.HotelDayService;
import com.example.hotel.service.HotelRoomService;
import com.example.hotel.utils.PageInfo;
import com.example.hotel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/day")
public class HotelDayController {

    @Autowired
    private HotelDayService service;


    @PostMapping("/list")
    public Result list(@RequestBody PageInfo info){
        Result result = service.list(info);
        result.setCode("ok");
        result.setMsg("查询成功");
        return result;
    }

    @GetMapping("/load/{id}")
    public Result load(@PathVariable Long id){
        Result result = service.load(id);
        return result;
    }

}
