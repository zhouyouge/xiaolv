package com.kgc.hz.dao;

import com.kgc.hz.entity.Area;
import com.kgc.hz.entity.Putin;
import com.kgc.hz.entity.PutinParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("PutinDao")
public interface PutinDao {
    /*List<User> getUserList();*/

    List<Area> getAreaList();

    /**
     * 添加投放记录
     */
    int addPutin(Putin putin);

    /**
     * 分页查询投放记录
     */
    List<Putin> getPutinPage(PutinParameter parameter);

    int getPutinCount(PutinParameter parameter);

    /**
     * 修改投放记录
     */
    Putin getPutin(@Param("id") int id);

    int updatePutin(Putin putin);

    /**
     * 删除投放记录
     */
    int delPutin(@Param("id") int id);


}
