package com.example.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.User;
import com.example.hotel.mapper.UserMapper;
import com.example.hotel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserService{


    @Autowired
    UserMapper userMapper;

    public Result list() {

        Page<User> page = new Page<>(1,1);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("user_name","李");
        IPage<User> userIPage = userMapper.selectPage(page,wrapper);
        Result result = new Result();
        result.setData(userIPage.getRecords());
        return  result;

    }



}
