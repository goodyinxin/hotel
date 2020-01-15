package com.example.hotel.service;

import com.example.hotel.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserService {


    public List<User> list() {
        List<User> list = Arrays.asList(
               new User(1,"管理员", "管理员", new Date(),new Date(), "张三","1",23,"18103890804"),
                new User(2,"管理员", "管理员", new Date(),new Date(), "李四","1",23,"18103890804"),
                new User(3,"管理员", "管理员", new Date(),new Date(), "王五","1",23,"18103890804"),
                new User(4,"管理员", "管理员", new Date(),new Date(), "赵六","1",23,"18103890804"),
                new User(5,"管理员", "管理员", new Date(),new Date(), "尹欣","1",23,"18103890804")
                );

        return  list;

    }

}
