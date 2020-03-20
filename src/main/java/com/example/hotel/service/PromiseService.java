package com.example.hotel.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hotel.entity.Label;
import com.example.hotel.entity.Promise;
import com.example.hotel.mapper.PromiseMapper;
import com.example.hotel.utils.PageInfo;
import com.example.hotel.utils.Result;
import com.example.hotel.utils.SnowflakeIdWorker;
import com.example.hotel.utils.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PromiseService {
    @Autowired
    PromiseMapper mapper;
   
    @Autowired
    private SnowflakeIdWorker sequence;


    public Result list(PageInfo info) {
        Page<Promise> page = new Page<>(info.getPagenum(),info.getPagesize());
        QueryWrapper<Promise> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(info.getQuery())){
            wrapper.like("promise_path",info.getQuery());
        }
        IPage<Promise> userIPage = mapper.selectPage(page,wrapper);
        Result result = new Result();
        result.getData().add(userIPage);
        return  result;

    }





    public Result save(Promise bean) {
        Result result = new Result();

        Long id = bean.getPromiseId();
        if(id ==null) {
            //添加
            id = sequence.nextId();
            bean.setPromiseId(id);
            int i = mapper.insert(bean);
            if (i > 0) {
                result.setCode(State.OK.INFO());
                result.setMsg("添加成功");
            } else {
                result.setCode(State.FAIL.INFO());
                result.setMsg("添加失败");
            }
        }else {
            //修改
            int i = mapper.updateById(bean);
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
        int i = mapper.deleteById(id);
        QueryWrapper<Promise> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Promise::getPromiseId,id);
        int no = mapper.delete(wrapper);
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
        Promise Promise = mapper.selectById(id);
        if(Promise == null){
            result.setCode(State.FAIL.INFO());
            result.setMsg("查询失败");
        }
        result.setCode(State.OK.INFO());
        result.setMsg("查询成功");
        result.setData(Arrays.asList(Promise));
        return result;
    }

    public Result role() {
        Result result = new Result();
        QueryWrapper<Promise> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Promise::getPromisePid,0l);
        List<Promise> promises = mapper.selectList(wrapper);

        List<Promise> collect = promises.stream().map(x -> {
            Long promiseId = x.getPromiseId();
          /*  Label label = new Label();
            label.setId(promiseId+"");
            label.setLabel(x.getPromiseName());*/

            QueryWrapper<Promise> wrapper2 = new QueryWrapper<>();
            wrapper2.lambda().eq(Promise::getPromisePid, promiseId);
            List<Promise> list = mapper.selectList(wrapper2);
           /* List<Label> labelList = new ArrayList<>();
            for (Promise promise : list) {
                Label label2 = new Label();
                label2.setId(promise.getPromiseId()+"");
                label2.setLabel(promise.getPromiseName());
                labelList.add(label2);
            }
             label.setChildren(labelList);
            */
            x.setPromises(list);

            return x;
        }).collect(Collectors.toList());
        result.setCode(State.OK.INFO());
        result.setMsg("查询成功");
        result.setData(Arrays.asList(collect));
        return result;
    }
}
