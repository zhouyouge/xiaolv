package com.kgc.hz.service;

import com.kgc.hz.entity.*;

import java.util.List;

public interface WithdrawService {

    List<Putin> getPutin();
    /**
     * 添加提现记录
     * @param withdraw
     * @return
     */
    ResponseResult addWithdrawd(Withdraw withdraw);

    /**
     * 分页查询
     * @param parameter
     * @return
     */
    WithdrawPage getWithdraws(WithdrawParameter parameter);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deletewit(int id);

    /**
     * 修改
     * @param withdraw
     * @return
     */
    ResponseResult updeteWits(Withdraw withdraw);

    /**
     * 根据ID查询单个销售记录信息
     * @param id
     * @return
     */
    Withdraw getWits(int id);
}
