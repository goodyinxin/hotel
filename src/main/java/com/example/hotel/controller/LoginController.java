package com.example.hotel.controller;

import com.example.hotel.utils.Main;
import com.example.hotel.utils.Result;
import com.example.hotel.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {


    @PostMapping("/user/login")
    public Result login(@RequestBody Main main, HttpSession session ){
        Result result = new Result();
        if(!StringUtils.isEmpty(main.getUsername()) &&   "123456".equals(main.getPassword())){
            String token = UUIDUtils.getUUid();
            session.setAttribute("loginUser",main.getUsername());
            session.setAttribute("token",token);
            result.setData(Arrays.asList(token));
            result.setMsg("登录成功");
            result.setCode("ok");

        }else {
            result.setMsg("登录失败");
            result.setCode("fail");
        }
        return result;

    }

}


