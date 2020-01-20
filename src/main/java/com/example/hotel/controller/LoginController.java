package com.example.hotel.controller;

import com.example.hotel.entity.User;
import com.example.hotel.service.UserService;
import com.example.hotel.utils.JwtUtils;
import com.example.hotel.utils.Main;
import com.example.hotel.utils.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/user/login")
    public Result login(@RequestBody Main main, HttpSession session ){
        Result result = new Result();
        User user =userService.login(main);
        if(user!=null && user.getAdminPassword().equals(main.getPassword())){
            String token = JwtUtils.createJWT(user);
            result.setToken(token);
            result.setMsg("登录成功");
            result.setCode("ok");

        }else {
            result.setMsg("登录失败");
            result.setCode("fail");
        }
        return result;

    }

}


