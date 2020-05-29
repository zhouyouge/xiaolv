package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.PutinDao;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.PutinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("putinService")
public class PutinServiceImpl implements PutinService {

    @Autowired
    private PutinDao putinDao;

    @Override
    public List<Area> getAreaList() {
        return putinDao.getAreaList();
    }

    @Override
    public ResponseResult addPutin(Putin putin) {
        ResponseResult rs = new ResponseResult();
        if(StringUtils.isEmpty(putin)){
            rs.setFlag(0);
            rs.setData("传参为空");
        }
        if(StringUtils.isEmpty(putin.getPutUser())){
            rs.setFlag(1);
            rs.setData("投放人为空");
        }
        if(StringUtils.isEmpty(putin.getPutKG())){
            rs.setFlag(2);
            rs.setData("投放重量为空");
        }
        if(StringUtils.isEmpty(putin.getGetIntegral())){
            rs.setFlag(3);
            rs.setData("获取积分为空");
        }
        if(StringUtils.isEmpty(putin.getPutAddress())){
            rs.setFlag(4);
            rs.setData("投放地址为空");
        }
        if(putinDao.addPutin(putin)>0){
            rs.setFlag(5);
            rs.setData("添加投放记录成功");
            rs.setResult(true);
        }
        return rs;
    }

    @Override
    public PutinPage getPutins(PutinParameter parameter) {
        if(StringUtils.isEmpty(parameter)){
            parameter = new PutinParameter();
        }
        parameter.setPageIndex((parameter.getCurPage()-1)*parameter.getPageSize());
        int count = putinDao.getPutinCount(parameter);
        List<Putin> list = putinDao.getPutinPage(parameter);
        PutinPage page = new PutinPage();
        page.setTotalCount(count);
        page.setPutinList(list);
        page.setCurPage(parameter.getCurPage());
        page.setPageSize(parameter.getPageSize());
        page.setTotalPageCount((count/page.getPageSize())+((count%page.getPageSize())==0?0:1));
        return page;
    }

    @Override
    public Putin getPutin(int id) {
        return putinDao.getPutin(id);
    }

    @Override
    public ResponseResult updatePutin(Putin putin) {
        int flag = putinDao.updatePutin(putin);
        ResponseResult rs = new ResponseResult();
        if(flag>0){
            rs.setResult(true);
            rs.setFlag(1);
        }else {
            rs.setFlag(2);
        }
        return rs;
    }

    @Override
    public ResponseResult delPutin(int id) {
        int flag = putinDao.delPutin(id);
        ResponseResult rs = new ResponseResult();
        if(flag>0){
            rs.setResult(true);
            rs.setFlag(1);
        }else {
            rs.setFlag(2);
        }
        return rs;
    }
}
