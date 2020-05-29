package com.kgc.hz.dao;

import com.kgc.hz.entity.Area;
import com.kgc.hz.entity.AreaParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("middleProducttDao")
public interface MiddleProducttDao {
    /**
     * 分页查询
     * @param parameter
     * @return
     */
    List<Area> getAreaList(AreaParameter parameter);
    int getAreaCount(AreaParameter parameter);
    /**
     * 添加区域信息
     * @param area
     * @return
     */
    int addArea(Area area);

    /**
     * 修改
     * @param id
     * @return
     */
    Area getArea(@Param("id") int id);
    int updateArea(Area area);

    /**
     * 删除
     * @param area
     * @return
     */
    int deleteArea(Area area);
}
