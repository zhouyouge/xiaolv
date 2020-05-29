package com.kgc.hz.entity;

/**
 * 区域信息分页查询sql语句的条件
 */
public class AreaParameter extends Page {

    private String cabinetAddress;
    private String areaName;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getCabinetAddress() {
        return cabinetAddress;
    }

    public void setCabinetAddress(String cabinetAddress) {
        this.cabinetAddress = cabinetAddress;
    }
}
