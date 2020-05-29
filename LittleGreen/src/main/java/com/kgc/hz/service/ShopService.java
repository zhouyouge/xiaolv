package com.kgc.hz.service;

import com.kgc.hz.entity.ResponseResult;
import com.kgc.hz.entity.Shop;
import com.kgc.hz.entity.ShopPage;
import com.kgc.hz.entity.ShopParameter;

import java.util.List;

public interface ShopService {
    /**
     * 全查商城信息
     * @return
     */
    List<Shop> getShopList();

    /**
     * 分页查询商城信息
     * @param parameter
     * @return
     */
    ShopPage getShopList(ShopParameter parameter);

    /**
     * 添加商城信息
     * @param shop
     * @return
     */
    ResponseResult addShop(Shop shop);

    /**
     * 根据 id 值修改商城信息
     * @param shop
     * @return
     */
    ResponseResult updateShop(Shop shop);
    Shop getShop(int id);

    /**
     * 根据id删除商城信息
     * @param id
     * @return
     */
    ResponseResult deleteShop(int id);
}
