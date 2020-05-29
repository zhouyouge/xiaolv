package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 提现记录表
 */
public class Withdraw implements Serializable {

    private Integer id;//提现id
    private String withdrawUser;//提现人（关联用户表id）
    private Double money;//提现金额
    private Integer withdrawIntegral;//花费积分
    private Double totalPrice; //总价
    private Date withdrawTime;//兑换时间
    private Integer userId;//谁提现了这条记录id
    private Integer putinId;//投放记录id


    private String userName;//用户姓名
    private String putUser;//投放人姓名

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPutUser() {
        return putUser;
    }

    public void setPutUser(String putUser) {
        this.putUser = putUser;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPutinId() {
        return putinId;
    }

    public void setPutinId(Integer putinId) {
        this.putinId = putinId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWithdrawUser() {
        return withdrawUser;
    }

    public void setWithdrawUser(String withdrawUser) {
        this.withdrawUser = withdrawUser;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getWithdrawIntegral() {
        return withdrawIntegral;
    }

    public void setWithdrawIntegral(Integer withdrawIntegral) {
        this.withdrawIntegral = withdrawIntegral;
    }

    public Date getWithdrawTime() {
        return withdrawTime;
    }

    public void setWithdrawTime(Date withdrawTime) {
        this.withdrawTime = withdrawTime;
    }
}
