package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.WithdrawDao;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("withdrawService")
public class WithdrawServiceImpl implements WithdrawService {

    @Autowired
    private WithdrawDao withdrawDao;

    /**
     * 查询投放记录
     * @return
     */
    @Override
    public List<Putin> getPutin() {
        return withdrawDao.getPutin();
    }

    /**
     * 添加提现记录
     * @param withdraw
     * @return
     */
    @Transactional //事务,失败回滚
    @Override
    public ResponseResult addWithdrawd(Withdraw withdraw) {
        ResponseResult rs=new ResponseResult();
        if (StringUtils.isEmpty(withdraw)){
            rs.setFlag(0);
            rs.setData("参数为空");
        }
        if (StringUtils.isEmpty(withdraw.getWithdrawIntegral())){
            rs.setFlag(1);
            rs.setData("积分为空");
        }
        if (StringUtils.isEmpty(withdraw.getMoney())){
            rs.setFlag(2);
            rs.setData("金额为空");
        }
        if (StringUtils.isEmpty(withdraw.getPutinId())){
            rs.setFlag(3);
            rs.setData("投放id为空");
        }

        int count= withdrawDao.selectPutin(withdraw.getPutinId());
        if (count<withdraw.getWithdrawIntegral()){
            rs.setFlag(4);
            rs.setData("积分库存量不够");
        }else {
            //先减去投放积分量
            Putin p=new Putin();
            p.setId(withdraw.getPutinId());
            p.setGetIntegral(withdraw.getWithdrawIntegral());
            withdraw.setTotalPrice(withdraw.getWithdrawIntegral()*withdraw.getMoney());
            if (withdrawDao.updatePutin(p)>0
                    && withdrawDao.addWithdrawd(withdraw)>0){
                rs.setFlag(5);
                rs.setData("添加提现记录成功");
                rs.setResult(true);
            }
        }
        return rs;
    }

    /**
     * 分页查询
     * @param parameter
     * @return
     */
    @Override
    public WithdrawPage getWithdraws(WithdrawParameter parameter) {
            if (StringUtils.isEmpty(parameter)){
                parameter= new WithdrawParameter();
            }
             //计算当前页下标
            parameter.setPageIndex((parameter.getCurPage()-1)* parameter.getPageSize());
            int count= withdrawDao.getwithdrawCount(parameter);
            List<Withdraw> list=withdrawDao.getwithdrawPage(parameter);
            WithdrawPage page=new WithdrawPage();
            page.setTotalCount(count);
            page.setWithdrawLists(list);
            page.setCurPage(parameter.getCurPage());
            page.setPageSize(parameter.getPageSize());
            page.setTotalPageCount((count/page.getPageSize())+((count%page.getPageSize())==0?0:1));
            return page;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public ResponseResult deletewit(int id) {
      int flag=  withdrawDao.deletewit(id);
        ResponseResult rs=new ResponseResult();
      if (flag>0){

          rs.setResult(true);
          rs.setFlag(1);
          rs.setData("删除成功");
      }else {
          rs.setFlag(2);
          rs.setData("删除失败");
      }
        return rs;
    }

    @Override
    public ResponseResult updeteWits(Withdraw withdraw) {
        ResponseResult rs=new ResponseResult();
        int flag=withdrawDao.updeteWit(withdraw);
          if (flag>0){
              rs.setResult(true);
              rs.setFlag(1);
              rs.setData("提现记录修改成功");
          }else {
              rs.setFlag(2);
              rs.setData("提现记录修改失败");
          }
        return rs;
    }

    /**
     * 根据ID查询单个提现记录信息
     * @param id
     * @return
     */
    @Override
    public Withdraw getWits(int id) {
        return withdrawDao.getWits(id);
    }
}
