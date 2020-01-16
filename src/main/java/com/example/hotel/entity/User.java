package com.example.hotel.entity;


import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name="manage_user")
public  class User extends bean{

    @Id
    @GeneratedValue
    @Column(name="u_id",length = 20)
    private Integer id;
    @Column(name="u_name",length = 10)
    private String name;
    @Column(name="u_gende",length = 1)
    private String gende;
    @Column(name="u_age", length = 10)
    private Integer age;
    @Column(name="u_moblie" ,length=10)
    private String moblie;


    public User(String createman, String modifyman, Date createtime, Date modifytime, String name, String gende, Integer age, String moblie) {
        super(createman, modifyman, createtime, modifytime);
        this.name = name;
        this.gende = gende;
        this.age = age;
        this.moblie = moblie;
    }

    public User(String createman, String modifyman, Date createtime, Date modifytime) {
        super(createman, modifyman, createtime, modifytime);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGende() {
        return gende;
    }

    public void setGende(String gende) {
        this.gende = gende;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }
}
