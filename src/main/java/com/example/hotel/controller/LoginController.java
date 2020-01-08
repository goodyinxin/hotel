package com.example.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {


    @PostMapping("/user/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session,Map map ){
        if(!StringUtils.isEmpty(username) &&   "123456".equals(password)){
            session.setAttribute("loginUser",username);
            return "dashboard";
        }else {
            map.put("msg","用户名密码错误");
            return "index";
        }


    }

}


