package com.kgc.hz.entity;

import java.util.Date;

/**
 * 区域信息分页查询sql语句的条件
 */
public class AreaParameter extends Page {

    private String cabinetAddress;
    private String state;
    private Date miTime;


    public Date getMiTime() {
        return miTime;
    }

    public void setMiTime(Date miTime) {
        this.miTime = miTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCabinetAddress() {
        return cabinetAddress;
    }

    public void setCabinetAddress(String cabinetAddress) {
        this.cabinetAddress = cabinetAddress;
    }
}
