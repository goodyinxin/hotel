package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
@TableName("admin_promise")
public class Promise {
    @TableId(value ="promise_id" ,type = IdType.INPUT)
    private Long   promiseId;
    private String  promisePath;

    private String promiseName;

    private Integer promiseLevel;
    private String createman;
    private String modifyman;
    private Date createtime =new Date();
    private Date modifytime=new Date();

    public String getPromiseName() {
        return promiseName;
    }

    public void setPromiseName(String promiseName) {
        this.promiseName = promiseName;
    }

    public Integer getPromiseLevel() {
        return promiseLevel;
    }

    public void setPromiseLevel(Integer promiseLevel) {
        this.promiseLevel = promiseLevel;
    }

    public Long getPromiseId() {
        return promiseId;
    }

    public void setPromiseId(Long promiseId) {
        this.promiseId = promiseId;
    }

    public String getPromisePath() {
        return promisePath;
    }

    public void setPromisePath(String promisePath) {
        this.promisePath = promisePath;
    }

    public String getCreateman() {
        return createman;
    }

    public void setCreateman(String createman) {
        this.createman = createman;
    }

    public String getModifyman() {
        return modifyman;
    }

    public void setModifyman(String modifyman) {
        this.modifyman = modifyman;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}
