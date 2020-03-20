package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@TableName("admin_promise")
public class Promise {
    @TableId(value ="promise_id" ,type = IdType.INPUT)
    private Long   promiseId;
    private String  promisePath;
    private Long promisePid;
    private String promiseName;

    private Integer promiseLevel;
    private String createman;
    private String modifyman;
    private Date createtime =new Date();
    private Date modifytime=new Date();

    @TableField(exist = false)
    private List<Promise>  promises;

    public List<Promise> getPromises() {
        return promises;
    }

    public void setPromises(List<Promise> promises) {
        this.promises = promises;
    }

    public Long getPromisePid() {
        return promisePid;
    }

    public void setPromisePid(Long promisePid) {
        this.promisePid = promisePid;
    }

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
