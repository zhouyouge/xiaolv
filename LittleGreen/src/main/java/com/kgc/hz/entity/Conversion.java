package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.Date;

public class Conversion implements Serializable {
    private Integer id;
    private Integer conversionUser;
    private Integer conversionId;
    private Integer conversionIntegral;
    private Date conversionTime;
    private String userName;
    private String shopName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getConversionUser() {
        return conversionUser;
    }

    public void setConversionUser(Integer conversionUser) {
        this.conversionUser = conversionUser;
    }

    public Integer getConversionId() {
        return conversionId;
    }

    public void setConversionId(Integer conversionId) {
        this.conversionId = conversionId;
    }

    public Integer getConversionIntegral() {
        return conversionIntegral;
    }

    public void setConversionIntegral(Integer conversionIntegral) {
        this.conversionIntegral = conversionIntegral;
    }

    public Date getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }
}
