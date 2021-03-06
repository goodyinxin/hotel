package com.example.hotel.controller;

import com.example.hotel.entity.HotelOrder;
import com.example.hotel.service.HotelOrderService;
import com.example.hotel.utils.PageInfo;
import com.example.hotel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class HotelOrderController {

    @Autowired
    private HotelOrderService service;

    @PostMapping("/save")
    public Result save(@RequestBody HotelOrder bean){
        Result result = service.save(bean);
        return result;
    }

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
