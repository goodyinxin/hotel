package com.example.hotel.controller;

import com.example.hotel.entity.User;
import com.example.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;


    @GetMapping("/list")
    public String list(Model model){
        List<User> list = service.list();
        model.addAttribute("list",list);
        return "user/list";
    }



    @GetMapping("/getlist")
    @ResponseBody
    public List<User> getlist(Model model){
        List<User> list = service.list();
        model.addAttribute("list",list);
        return list;
    }

}
