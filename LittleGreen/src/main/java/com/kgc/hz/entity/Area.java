package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable {

    private Integer id;
    /**
     * 区域名称
     */
    private String areaName;
    /**
     * 回收柜id
     */
    private Integer cabinetId;
    /**
     * 创建日期
     */
    private Date createTime;


    /**
     * 关联表cabinet的属性cabinetAddress,state
     */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(Integer cabinetId) {
        this.cabinetId = cabinetId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
