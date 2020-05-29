package com.kgc.hz.entity;

import java.util.List;

/**
 * 分页查询区域信息结果集
 */
public class AreaPage extends Page {

    private List<Area> areaList;

    public List<Area> getAreaList() {
        return areaList;
    }

    public void setAreaList(List<Area> areaList) {
        this.areaList = areaList;
    }
}
