package com.kgc.hz.service;

import com.kgc.hz.entity.*;

import java.util.List;

public interface ConversionService {
    List<Shop> getShopList();
    /**
     * 分页查询积分兑换记录
     */
    ConversionPage getConversions(ConversionParameter parameter);

    /**
     * 修改
     */
    Conversion getConversion(int id);

    ResponseResult updateConversion(Conversion conversion);

    /**
     * 删除
     */

    ResponseResult delConversion(int id);
}
