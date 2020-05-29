package com.kgc.hz.service;

import com.kgc.hz.entity.*;

import java.util.List;

public interface AreaService {
    /**
     * 分页查询区域
     * @param parameter
     * @return
     */
    AreaPage getAreaPage(AreaParameter parameter);
    /**
     * 添加区域信息
     * @param area
     * @return
     */
    ResponseResult addArea(Area area);

    /**
     * 修改
     * @param id
     * @return
     */
    Area getArea(int id);
    ResponseResult updateArea(Area area);

    /**
     * 删除
     * @param area
     * @return
     */
    ResponseResult deleteArea(Area area);

    List<AreaCabinet> getACList();
    AreaList Arealist();
}
