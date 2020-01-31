package com.example.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Role;
import com.example.hotel.mapper.RoleMapper;
import com.example.hotel.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private SnowflakeIdWorker sequence;


    public Result list(PageInfo info) {
        Page<Role> page = new Page<>(info.getPagenum(),info.getPagesize());
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(info.getQuery())){
            wrapper.like("admin_nickname",info.getQuery());
        }
        IPage<Role> userIPage = roleMapper.selectPage(page,wrapper);
        Result result = new Result();
        result.getData().add(userIPage);
        return  result;

    }





    public Result save(Role bean) {
        Result result = new Result();

        Long id = bean.getRoleId();
        if(id ==null) {
            //添加
            id = sequence.nextId();
            bean.setRoleId(id);
            int i = roleMapper.insert(bean);
            if (i > 0) {
                result.setCode(State.OK.INFO());
                result.setMsg("添加成功");
            } else {
                result.setCode(State.FAIL.INFO());
                result.setMsg("添加失败");
            }
        }else {
            //修改
            int i = roleMapper.updateById(bean);
            if (i > 0) {
                result.setCode(State.OK.INFO());
                result.setMsg("修改成功");
            } else {
                result.setCode(State.FAIL.INFO());
                result.setMsg("修改失败");
            }
        }
        result.setData(Arrays.asList(bean));

        return result;
    }

    public Result remove(Long id) {
        Result result = new Result();
        int i = roleMapper.deleteById(id);
        QueryWrapper<Role> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Role::getRoleId,id);
        int no = roleMapper.delete(wrapper);
        if (no>0){
            result.setCode(State.OK.INFO());
            result.setMsg("删除成功");
        }else {
            result.setCode(State.FAIL.INFO());
            result.setMsg("删除失败");
        }
        return result;

    }

    public Result load(Long id) {
        Result result = new Result();
        Role Role = roleMapper.selectById(id);
        if(Role == null){
            result.setCode(State.FAIL.INFO());
            result.setMsg("查询失败");
        }
        result.setCode(State.OK.INFO());
        result.setMsg("查询成功");
        result.setData(Arrays.asList(Role));
        return result;
    }

    public Result select() {
        Result result = new Result();
        List<Role> roles = roleMapper.selectList(null);
        result.setCode(State.OK.INFO());
        result.setMsg("查询成功");
        result.setData(roles);
        return result;
    }
}
