package com.example.hotel.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
@TableName( "hotel_day" )
public class HotelDay {
    @TableId(value = "day_id" ,type = IdType.INPUT)
    private Long dayId;
    private Integer dayRoomid;
    private Date dayDate;
    private String createman;
    private String  dayState;
    private  String  modifyman;
    private Date createtime;
    private  Date   modifytime;


    public String getDayState() {
        return dayState;
    }

    public void setDayState(String dayState) {
        this.dayState = dayState;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Integer getDayRoomid() {
        return dayRoomid;
    }

    public void setDayRoomid(Integer dayRoomid) {
        this.dayRoomid = dayRoomid;
    }

    public Date getDayDate() {
        return dayDate;
    }

    public void setDayDate(Date dayDate) {
        this.dayDate = dayDate;
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
