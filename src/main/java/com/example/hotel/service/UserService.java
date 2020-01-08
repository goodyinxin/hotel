package com.example.hotel.service;

import com.example.hotel.entity.User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


    public List<User> list() {
        List<User> list = Arrays.asList(
               new User("张三", "1", 20, "18103890804"),
               new User("李四", "1", 20, "18103248574"),
               new User("王五", "1", 20, "18103568574"),
               new User("赵柳", "0", 20, "18167676748")
                );

        return  list;

    }

}
