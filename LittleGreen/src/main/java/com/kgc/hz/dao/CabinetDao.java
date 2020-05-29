package com.kgc.hz.dao;

import com.kgc.hz.entity.Cabinet;
import com.kgc.hz.entity.CabinetParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cabinetDao")
public interface CabinetDao {
    /**
     * 全查回收柜信息
     * @return
     */
    List<Cabinet> getCabinet(Cabinet cabinet);
    /**
     * 分页查询回收柜信息
     * @return
     */
    List<Cabinet> getCabPage(CabinetParameter parameter);
    /**
     * 分页记录总数
     * @param parameter
     * @return
     */
    int CabCount(CabinetParameter parameter);
    /**
     * 添加回收柜信息
     * @param cabinet
     * @return
     */
    int addCabinet(Cabinet cabinet);

    /**
     * 修改回收柜信息
     * @param cabinet
     * @return
     */
    int updateCabinet(Cabinet cabinet);
    Cabinet getCab(@Param("id") int id);
    /**
     * 删除回收柜信息
     * @param id
     * @return
     */
    int deleteCabinet(@Param("id") int id);
}
