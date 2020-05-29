package com.kgc.hz.dao;

import com.kgc.hz.entity.Conversion;
import com.kgc.hz.entity.ConversionParameter;
import com.kgc.hz.entity.Shop;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ConversionDao")
public interface ConversionDao {
    List<Shop> getShopList();
    /**
     * 分页查询积分兑换记录
     */
    List<Conversion> getConversionPage(ConversionParameter parameter);

    int getConversionCount(ConversionParameter parameter);

    /**
     * 修改投放记录
     */
    Conversion getConversion(@Param("id") int id);

    int updateConversion(Conversion conversion);

    /**
     * 删除投放记录
     */
    int delConversion(@Param("id") int id);

}
