package com.example.hotel.controller;

import com.example.hotel.entity.User;
import com.example.hotel.service.UserService;
import com.example.hotel.utils.PageInfo;
import com.example.hotel.utils.Result;
import com.example.hotel.utils.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;


    @PostMapping("/list")
    public Result list(@RequestBody PageInfo info){
        Result result = service.list(info);
        result.setCode("ok");
        result.setMsg("查询成功");
        return result;
    }

    @PostMapping("/save")
    public Result list(@RequestBody User bean){
        Result result = service.save(bean);
        return result;
    }

}
