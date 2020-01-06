package com.example.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {


    @PostMapping("/user/login")
    public String login(@RequestParam String username, @RequestParam String password){
        if(!StringUtils.isEmpty(username) &&   "123456".equals(password)){
            return "dashboard";
        }else {
            Map map = new HashMap();
            map.put("msg","请输入密码");
            return "index";
        }


    }

}


