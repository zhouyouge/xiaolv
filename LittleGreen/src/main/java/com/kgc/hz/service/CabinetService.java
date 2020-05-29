package com.kgc.hz.service;

import com.kgc.hz.entity.*;

import java.util.List;

public interface CabinetService {
    /**
     * 全查回收柜信息
     * @return
     */
    List<Cabinet> getCabinet(Cabinet cabinet);

    /**
     * 分页查询回收柜信息
     * @return
     */
    CabinetPage getCabList(CabinetParameter parameter);
    /**
     * 添加回收柜信息
     * @param cabinet
     * @return
     */
    ResponseResult addCabinet(Cabinet cabinet);
    /**
     * 修改回收柜信息
     * @param cabinet
     * @return
     */
    ResponseResult updateCabinet(Cabinet cabinet);
    Cabinet getCab(int id);

    /**
     * 删除回收柜信息
     * @param id
     * @return
     */
    ResponseResult deleteCabinet(int id);
}
