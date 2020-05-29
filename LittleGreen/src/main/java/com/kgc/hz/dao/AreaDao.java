package com.kgc.hz.dao;

import com.kgc.hz.entity.Area;
import com.kgc.hz.entity.AreaParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("areaDao")
public interface AreaDao {
    /**
     * 全查
     * @return
     */
    List<Area> getAreaCList();
    /**
     * 分页查询区域信息
     * @param parameter
     * @return
     */
    List<Area> getAreaList(AreaParameter parameter);

    /**
     * 获取分页页数
     * @param parameter
     * @return
     */
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

    /**
     * 根据区域名字查询
     * @param areaName
     * @return
     */
    int getACList(String areaName);
    //未满
    int getACList1(String areaName);
    //已满
    int getACList2(String areaName);
    //维修中
    int getACList3(String areaName);
}
