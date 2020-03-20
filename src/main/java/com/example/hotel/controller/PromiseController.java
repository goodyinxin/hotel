package com.example.hotel.controller;


import com.example.hotel.entity.Promise;
import com.example.hotel.service.PromiseService;
import com.example.hotel.utils.PageInfo;
import com.example.hotel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/promise")
@RestController
public class PromiseController {
    @Autowired
    PromiseService service;
    
    
    @PostMapping("/list")
    public Result list(@RequestBody PageInfo info){
        Result result = service.list(info);
        result.setCode("ok");
        result.setMsg("查询成功");
        return result;
    }


    @PostMapping("/save")
    public Result save(@RequestBody Promise bean){
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


    @GetMapping("/role")
    public Result role(){
        Result result = service.role();
        return result;
    }

}
