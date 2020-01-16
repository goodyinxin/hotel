package com.example.hotel.entity;



import javax.persistence.Column;
import java.util.Date;

public abstract  class bean {
    @Column(name="c_createman")
    private String createman;
    @Column(name="c_modifyman")
    private String modifyman;
    @Column(name="c_createtime")
    private Date createtime =new Date();
    @Column(name="c_modifytime")
    private Date modifytime=new Date();

    public bean( String createman, String modifyman, Date createtime, Date modifytime) {
        this.createman = createman;
        this.modifyman = modifyman;
        this.createtime = createtime;
        this.modifytime = modifytime;
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
