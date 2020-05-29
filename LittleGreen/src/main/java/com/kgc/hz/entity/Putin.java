package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.Date;

public class Putin implements Serializable {
    private Integer id;
    private String putUser;
    private Double putKG;
    private Integer getIntegral;
    private Date putTime;
    private Integer putAddress;
    private Integer userId;
    private String userName;
    private String areaName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPutUser() {
        return putUser;
    }

    public void setPutUser(String putUser) {
        this.putUser = putUser;
    }

    public Double getPutKG() {
        return putKG;
    }

    public void setPutKG(Double putKG) {
        this.putKG = putKG;
    }

    public Integer getGetIntegral() {
        return getIntegral;
    }

    public void setGetIntegral(Integer getIntegral) {
        this.getIntegral = getIntegral;
    }

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public Integer getPutAddress() {
        return putAddress;
    }

    public void setPutAddress(Integer putAddress) {
        this.putAddress = putAddress;
    }
}
