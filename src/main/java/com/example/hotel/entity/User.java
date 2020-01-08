package com.example.hotel.entity;


public  class User extends bean{

    private String name;
    private String gende;
    private Integer age;
    private String moblie;


    public User(String name, String gende, Integer age, String moblie) {
        super();
        this.name = name;
        this.gende = gende;
        this.age = age;
        this.moblie = moblie;
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
