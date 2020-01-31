package com.example.hotel.controller;

import com.example.hotel.entity.Role;
import com.example.hotel.service.RoleService;
import com.example.hotel.utils.PageInfo;
import com.example.hotel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private   RoleService service;

    @PostMapping("/list")
    public Result list(@RequestBody PageInfo info){
        Result result = service.list(info);
        result.setCode("ok");
        result.setMsg("查询成功");
        return result;
    }


    @PostMapping("/save")
    public Result save(@RequestBody Role bean){
        Result result = service.save(bean);
        return result;
    }


    @DeleteMapping("/remove/{id}")
    public Result remove(@PathVariable Long id){
        Result result = service.remove(id);
        return result;
    }

    @GetMapping("/load/{id}")
    public Result load(@PathVariable Long id){
        Result result = service.load(id);
        return result;
    }


    @GetMapping("/select")
    public Result select(){
        Result result = service.select();
        return result;
    }

}
