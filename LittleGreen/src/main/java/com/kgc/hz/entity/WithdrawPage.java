package com.kgc.hz.entity;

import java.util.List;

/**
 * 分页查询的结构
 */
public class WithdrawPage extends Page {

    private List<Withdraw> withdrawLists;

    public List<Withdraw> getWithdrawLists() {
        return withdrawLists;
    }

    public void setWithdrawLists(List<Withdraw> withdrawLists) {
        this.withdrawLists = withdrawLists;
    }
}
