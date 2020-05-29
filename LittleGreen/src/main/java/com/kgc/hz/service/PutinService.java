package com.kgc.hz.service;

import com.kgc.hz.entity.*;

import java.util.List;

public interface PutinService {
    List<Area> getAreaList();

    ResponseResult addPutin(Putin putin);

    /**
     * 分页查询投放记录
     */
    PutinPage getPutins(PutinParameter parameter);

    /**
     * 修改
     */
    Putin getPutin(int id);

    ResponseResult updatePutin(Putin putin);

    /**
     * 删除
     */

    ResponseResult delPutin(int id);
}
