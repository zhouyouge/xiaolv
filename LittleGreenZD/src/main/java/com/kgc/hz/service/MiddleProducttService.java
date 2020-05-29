package com.kgc.hz.service;

import com.kgc.hz.entity.Area;
import com.kgc.hz.entity.AreaPage;
import com.kgc.hz.entity.AreaParameter;
import com.kgc.hz.entity.ResponseResult;

public interface MiddleProducttService {
    /**
     * 分页查询
     * @param parameter
     * @return
     */
    AreaPage getAreas(AreaParameter parameter);
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
}
