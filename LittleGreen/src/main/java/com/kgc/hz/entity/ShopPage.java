package com.kgc.hz.entity;

import java.util.List;

public class ShopPage extends Page {
    private List<Shop> ShopList;

    public List<Shop> getShopList() {
        return ShopList;
    }

    public void setShopList(List<Shop> shopList) {
        ShopList = shopList;
    }
}
