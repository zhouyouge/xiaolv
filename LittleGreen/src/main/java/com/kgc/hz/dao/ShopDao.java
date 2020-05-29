package com.kgc.hz.dao;

import com.kgc.hz.entity.Shop;
import com.kgc.hz.entity.ShopParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("shopDao")
public interface ShopDao {
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
    List<Shop> getShopPage(ShopParameter parameter);

    /**
     * 分页信息总记录数
     * @param parameter
     * @return
     */
    int ShopCount(ShopParameter parameter);

    /**
     * 添加商城信息
     * @param shop
     * @return
     */
    int addShop(Shop shop);

    /**
     * 根据 id 值修改商城信息
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
    Shop getShop(@Param("id") int id);

    /**
     * 根据id删除商城信息
     * @param id
     * @return
     */
    int deleteShop(@Param("id") int id);

}
