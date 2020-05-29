package com.kgc.hz.dao;

import com.kgc.hz.entity.Putin;
import com.kgc.hz.entity.Withdraw;
import com.kgc.hz.entity.WithdrawParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("withdrawDao")
public interface WithdrawDao {
    /**
     * 查询投放记录
     * @return
     */
    List<Putin> getPutin();

    /**
     * 添加提现记录
     * @param withdraw
     * @return
     */
    int addWithdrawd(Withdraw withdraw);
    //修改投放记录
    int updatePutin(Putin putin);
    //查询单个积分库存够不够
    int selectPutin(@Param("id") int id);

    /**
     * 分页查询
     * @param parameter
     * @return
     */
    List<Withdraw> getwithdrawPage(WithdrawParameter parameter);

    /**
     * 分页查询总记录
     * @param parameter
     * @return
     */
    int  getwithdrawCount(WithdrawParameter parameter);

    /**
     * 删除
     * @param id
     * @return
     */
    int deletewit(@Param("id") int id);

    /**
     * 修改
     * @param withdraw
     * @return
     */
    int updeteWit(Withdraw withdraw);

    /**
     * 根据ID查询单个销售记录信息
     * @param id
     * @return
     */
    Withdraw getWits(@Param("id") int id);
}
