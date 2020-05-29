package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 封装响应结果实体类
 */
public class ResponseResult implements Serializable {

    private boolean result;
    private Integer flag;
    private Object data;
    private List<Cabinet> CabinetList;
    private List<Shop> shopList;
    private List<Putin> PutinList;
    private List<Card> CardList;
    private List<Conversion> ConversionList;
    private List<Withdraw> WithdrawLists;
    private List<Forum> ForumList;
    private List<Rubbish> RubbishList;

    public List<Rubbish> getRubbishList() {
        return RubbishList;
    }

    public void setRubbishList(List<Rubbish> rubbishList) {
        RubbishList = rubbishList;
    }

    public List<Withdraw> getWithdrawLists() {
        return WithdrawLists;
    }

    public void setWithdrawLists(List<Withdraw> withdrawLists) {
        WithdrawLists = withdrawLists;
    }

    public List<Forum> getForumList() {
        return ForumList;
    }

    public void setForumList(List<Forum> forumList) {
        ForumList = forumList;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Conversion> getConversionList() {
        return ConversionList;
    }

    public void setConversionList(List<Conversion> conversionList) {
        ConversionList = conversionList;
    }

    public List<Card> getCardList() {
        return CardList;
    }

    public void setCardList(List<Card> cardList) {
        CardList = cardList;
    }

    public List<Putin> getPutinList() {
        return PutinList;
    }

    public void setPutinList(List<Putin> putinList) {
        PutinList = putinList;
    }

    public List<Cabinet> getCabinetList() {
        return CabinetList;
    }

    public void setCabinetList(List<Cabinet> cabinetList) {
        CabinetList = cabinetList;
    }

    public List<Shop> getShopList() {
        return shopList;
    }

    public void setShopList(List<Shop> shopList) {
        this.shopList = shopList;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
