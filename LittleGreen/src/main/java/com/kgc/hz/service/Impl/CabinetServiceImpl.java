package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.CabinetDao;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("cabinetService")
public class CabinetServiceImpl implements CabinetService {

    @Autowired
    private CabinetDao cabinetDao;

    @Override
    public List<Cabinet> getCabinet(Cabinet cabinet) {
        return cabinetDao.getCabinet(cabinet);
    }

    @Override
    public CabinetPage getCabList(CabinetParameter parameter) {
        //判断用户是否登录
        if (StringUtils.isEmpty(parameter)) {
            parameter = new CabinetParameter();
        }
        //计算当前页下标
        parameter.setPageIndex((parameter.getCurPage()-1)*parameter.getPageSize());
        //记录总数
        int count = cabinetDao.CabCount(parameter);
        //查询当前集合
        List<Cabinet> list = cabinetDao.getCabPage(parameter);
        //封装数据
        CabinetPage pages = new CabinetPage();
        //封装总数
        pages.setTotalCount(count);
        //封装回收柜的集合
        pages.setCabinetList(list);
        //封装当前页码
        pages.setCurPage(parameter.getCurPage());
        //封装当前页尺寸
        pages.setPageSize(parameter.getPageSize());
        //获取页面查询条件值
        pages.setState1(parameter.getState());
        /*pages.setCabinetAddress1(parameter.getCabinetAddress());
        pages.setCreateTime1(parameter.getCreateTime());*/

        //总页数
        pages.setTotalPageCount((count/pages.getPageSize())+((count%pages.getPageSize())==0?0:1));
        return pages;
    }

    /**
     * 添加回收柜
     * @param cabinet
     * @return
     */
    @Transactional
    @Override
    public ResponseResult addCabinet(Cabinet cabinet) {
        ResponseResult rs = new ResponseResult();
        if (StringUtils.isEmpty(cabinet)) {
            rs.setFlag(0);
            rs.setData("传参为空");
        }
        if (StringUtils.isEmpty(cabinet.getId())) {
            rs.setFlag(1);
            rs.setData("ID为空");
        }
        if (StringUtils.isEmpty(cabinet.getCabinetAddress())){
            rs.setFlag(2);
            rs.setData("地址为空");
        }
        if (StringUtils.isEmpty(cabinet.getCreateTime())) {
            rs.setFlag(3);
            rs.setData("修改时间为空");
        }
        if (StringUtils.isEmpty(cabinet.getState())) {
            rs.setFlag(4);
            rs.setData("回收柜状态为空");
        }
        if (cabinetDao.addCabinet(cabinet)>0){
            rs.setFlag(5);
            rs.setData(cabinet);
            rs.setResult(true);
        }
        return rs;
    }

    @Override
    public ResponseResult updateCabinet(Cabinet cabinet) {
        ResponseResult rs = new ResponseResult();
        if (StringUtils.isEmpty(cabinet)) {
            rs.setFlag(0);
            rs.setData("传参为空");
        }
        if (StringUtils.isEmpty(cabinet.getId())) {
            rs.setFlag(1);
            rs.setData("ID为空");
        }
        if (StringUtils.isEmpty(cabinet.getCabinetAddress())){
            rs.setFlag(2);
            rs.setData("地址为空");
        }
        if (StringUtils.isEmpty(cabinet.getState())) {
            rs.setFlag(4);
            rs.setData("回收柜状态为空");
        }
        int flag = cabinetDao.updateCabinet(cabinet);
        if (flag>0){
            rs.setFlag(5);
            rs.setData(cabinet);
            rs.setResult(true);
        }
        return rs;
    }

    @Override
    public Cabinet getCab(int id) {
        return cabinetDao.getCab(id);
    }

    @Override
    public ResponseResult deleteCabinet(int id) {
        ResponseResult rs = new ResponseResult();
        if (cabinetDao.deleteCabinet(id)>0) {
            rs.setFlag(0);
            rs.setData("删除成功");
            rs.setResult(true);
        }else {
            rs.setFlag(1);
            rs.setData("删除失败");
        }
        return rs;
    }
}
