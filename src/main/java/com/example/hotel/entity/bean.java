package com.example.hotel.entity;

import java.util.Date;

public abstract  class bean {

    private Integer id;
    private String createman;
    private String modifyman;
    private Date createtime =new Date();
    private Date modifytime=new Date();

    public bean(Integer id, String createman, String modifyman, Date createtime, Date modifytime) {
        this.id = id;
        this.createman = createman;
        this.modifyman = modifyman;
        this.createtime = createtime;
        this.modifytime = modifytime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
