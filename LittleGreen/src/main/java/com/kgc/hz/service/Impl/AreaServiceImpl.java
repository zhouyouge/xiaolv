package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.AreaDao;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.AreaService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("areaService")
public class AreaServiceImpl implements AreaService {
    @Resource(name = "areaDao")
    private AreaDao areaDao;
    @Override
    public AreaPage getAreaPage(AreaParameter parameter) {
        if(StringUtils.isEmpty(parameter)){
            parameter = new AreaParameter();
        }
        parameter.setPageIndex((parameter.getCurPage()-1)*parameter.getPageSize());
        int count = areaDao.getAreaCount(parameter);
        List<Area> list = areaDao.getAreaList(parameter);
        AreaPage page = new AreaPage();
        page.setTotalCount(count);
        page.setAreaList(list);
        page.setCurPage(parameter.getCurPage());
        page.setPageSize(parameter.getPageSize());
        page.setTotalPageCount((count/page.getPageSize())
                +((count%page.getPageSize())==0?0:1));
        return page;
    }

    @Override
    public ResponseResult addArea(Area area) {
        ResponseResult rs = new ResponseResult();
        int flag = areaDao.addArea(area);
        rs.setFlag(1);
        rs.setResult(true);
        rs.setData(flag);
        return rs;
    }

    @Override
    public Area getArea(int id) {
        Area area = areaDao.getArea(id);
        return area;
    }

    @Override
    public ResponseResult updateArea(Area area) {
        ResponseResult rs = new ResponseResult();
        int flag = areaDao.updateArea(area);
        rs.setFlag(1);
        rs.setResult(true);
        rs.setData(flag);
        return rs;
    }

    @Override
    public ResponseResult deleteArea(Area area) {
        ResponseResult rs = new ResponseResult();
        int flag = areaDao.deleteArea(area);
        rs.setFlag(1);
        rs.setResult(true);
        rs.setData(flag);
        return rs;
    }

    @Override
    public List<AreaCabinet> getACList() {
        //获取区域数据
        List<Area> areas = areaDao.getAreaCList();
        //封装关联表areacabinet
        List<AreaCabinet> areaCabinets = new ArrayList<AreaCabinet>();
        //遍历循环获取区域数据
        for (Area ac:areas){
            //封装关联表
            AreaCabinet areaCabinet = new AreaCabinet();
            //塞区域名字
            areaCabinet.setAreaName(ac.getAreaName());
            //通过区域名字查询区域内的回收柜数量
            areaCabinet.setCount(areaDao.getACList(ac.getAreaName()));
            //将数据放入关联表中
            areaCabinets.add(areaCabinet);
        }
        return areaCabinets;
    }

    @Override
    public AreaList Arealist() {
        AreaList areaList = new AreaList();
        //获取区域数据
        List<Area> areas = areaDao.getAreaCList();
        List<String> AreaList = new ArrayList<String>();
        List<Integer> AreaInt1 = new ArrayList<Integer>();
        List<Integer> AreaInt2 = new ArrayList<Integer>();
        List<Integer> AreaInt3 = new ArrayList<Integer>();
        for (Area ac:areas){
            AreaList.add(ac.getAreaName());
            AreaInt1.add(areaDao.getACList1(ac.getAreaName()));
            AreaInt2.add(areaDao.getACList2(ac.getAreaName()));
            AreaInt3.add(areaDao.getACList3(ac.getAreaName()));
        }
        areaList.setAreaList(AreaList);
        areaList.setAreaInt1(AreaInt1);
        areaList.setAreaInt2(AreaInt2);
        areaList.setAreaInt3(AreaInt3);
        return areaList;
    }

}
