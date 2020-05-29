package com.kgc.hz.entity;

import java.util.List;

public class CabinetPage extends Page {
    private List<Cabinet> CabinetList;
    private String state1;
    /*private String cabinetAddress1;
    private Date createTime1;*/

    public String getState1() {
        return state1;
    }

    public void setState1(String state1) {
        this.state1 = state1;
    }

    /*public String getCabinetAddress1() {
        return cabinetAddress1;
    }

    public void setCabinetAddress1(String cabinetAddress1) {
        this.cabinetAddress1 = cabinetAddress1;
    }

    public Date getCreateTime1() {
        return createTime1;
    }

    public void setCreateTime1(Date createTime1) {
        this.createTime1 = createTime1;
    }*/

    public List<Cabinet> getCabinetList() {
        return CabinetList;
    }

    public void setCabinetList(List<Cabinet> CabinetList) {
        this.CabinetList = CabinetList;
    }
}
