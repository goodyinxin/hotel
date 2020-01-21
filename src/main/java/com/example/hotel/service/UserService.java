package com.example.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.User;
import com.example.hotel.mapper.UserMapper;
import com.example.hotel.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class UserService{

  @Autowired
  private   UserMapper userMapper;
  @Autowired
  private SnowflakeIdWorker sequence;


    public Result list(PageInfo info) {
        Page<User> page = new Page<>(info.getPagenum(),info.getPagesize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(info.getQuery())){
            wrapper.like("admin_nickname",info.getQuery());
        }
        IPage<User> userIPage = userMapper.selectPage(page,wrapper);
        Result result = new Result();
        result.getData().add(userIPage);
        return  result;

    }


    public User login(Main main) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(User::getAdminUsername,main.getUsername());
        return userMapper.selectOne(wrapper);
    }


    public Result save(User bean) {
        Result result = new Result();
        long id = sequence.nextId();
       // bean.setAdminId(id);
        int i = userMapper.insert(bean);
        if(i>0){
            result.setCode(State.OK.INFO());
            result.setMsg("添加成功");
        }else {
            result.setCode(State.FAIL.INFO());
            result.setMsg("添加失败");
        }
        result.setData(Arrays.asList(bean));
        return result;
    }
}
