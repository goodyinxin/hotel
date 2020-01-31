package com.example.hotel.entity;



import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;



@TableName("admin_user")
public  class User implements Serializable {

    private static final long serialVersionUID = 4126252740366265639L;
    @TableId(value ="admin_id" ,type = IdType.INPUT)
    private Long adminId;
    private String adminUsername;
    private String adminPassword;
    private String adminNickname;
    private String adminGende;
    private Integer adminAge;
    private String adminMoblie;
    private Long  adminRole;
    private String createman;
    private String modifyman;
    private Date createtime =new Date();
    private Date modifytime=new Date();



    public Long getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(Long adminRole) {
        this.adminRole = adminRole;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminNickname() {
        return adminNickname;
    }

    public void setAdminNickname(String adminNickname) {
        this.adminNickname = adminNickname;
    }

    public String getAdminGende() {
        return adminGende;
    }

    public void setAdminGende(String adminGende) {
        this.adminGende = adminGende;
    }

    public Integer getAdminAge() {
        return adminAge;
    }

    public void setAdminAge(Integer adminAge) {
        this.adminAge = adminAge;
    }

    public String getAdminMoblie() {
        return adminMoblie;
    }

    public void setAdminMoblie(String adminMoblie) {
        this.adminMoblie = adminMoblie;
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


