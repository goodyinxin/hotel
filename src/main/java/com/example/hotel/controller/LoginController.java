package com.example.hotel.controller;

import com.example.hotel.utils.Main;
import com.example.hotel.utils.Result;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {


    @PostMapping("/user/login")
    public Result login(@RequestBody Main main, HttpSession session ){
        Result result = new Result();
        if(!StringUtils.isEmpty(main.getUsername()) &&   "123456".equals(main.getPassword())){
            session.setAttribute("loginUser",main.getUsername());
            result.setMsg("登录成功");
            result.setCode("ok");

        }else {
            result.setMsg("登录失败");
            result.setCode("fail");
        }
        return result;

    }

}


