package com.example.hotel.controller;

import com.example.hotel.entity.HotelOrder;
import com.example.hotel.service.HotelOrderService;
import com.example.hotel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class HotelOrderController {

    @Autowired
    private HotelOrderService service;

    @PostMapping("/save")
    public Result save(@RequestBody HotelOrder bean){
        Result result = service.save(bean);
        return result;
    }

}
