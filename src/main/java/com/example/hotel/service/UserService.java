package com.example.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.User;
import com.example.hotel.mapper.UserMapper;
import com.example.hotel.utils.PageInfo;
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
  private   UserMapper userMapper;

    public Result list(PageInfo info) {
        Page<User> page = new Page<>(info.getPagenum(),info.getPagesize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(info.getQuery()!=null){
            wrapper.like("user_name",info.getQuery());
        }
        IPage<User> userIPage = userMapper.selectPage(page,wrapper);
        Result result = new Result();
        result.getData().add(userIPage);
        return  result;

    }



}
