package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.Date;

public class Card implements Serializable {
    private Integer id;
    private String ICUserName;
    private Integer ICIntegral;
    private String phone;
    private String userAddress;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getICUserName() {
        return ICUserName;
    }

    public void setICUserName(String ICUserName) {
        this.ICUserName = ICUserName;
    }

    public Integer getICIntegral() {
        return ICIntegral;
    }

    public void setICIntegral(Integer ICIntegral) {
        this.ICIntegral = ICIntegral;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
