package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;
@TableName( "hotel_order" )
public class HotelOrder {
    @TableId(value = "order_id" ,type = IdType.INPUT)
    private   Long   orderId;
    private   String   orderCode;
    private   String  orderState;
    private   String  createman;
    private   String   modifyman;
    private   Date   createtime;
    private   Date     modifytime;
    private   String    orderName;
    private   String   orderMoblie;
    private   String   orderIdcard;
    private   String     orderGender;
    private   Integer orderAge;
    private   Date orderCheckdate;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
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

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderMoblie() {
        return orderMoblie;
    }

    public void setOrderMoblie(String orderMoblie) {
        this.orderMoblie = orderMoblie;
    }

    public String getOrderIdcard() {
        return orderIdcard;
    }

    public void setOrderIdcard(String orderIdcard) {
        this.orderIdcard = orderIdcard;
    }

    public String getOrderGender() {
        return orderGender;
    }

    public void setOrderGender(String orderGender) {
        this.orderGender = orderGender;
    }

    public Integer getOrderAge() {
        return orderAge;
    }

    public void setOrderAge(Integer orderAge) {
        this.orderAge = orderAge;
    }

    public Date getOrderCheckdate() {
        return orderCheckdate;
    }

    public void setOrderCheckdate(Date orderCheckdate) {
        this.orderCheckdate = orderCheckdate;
    }
}
