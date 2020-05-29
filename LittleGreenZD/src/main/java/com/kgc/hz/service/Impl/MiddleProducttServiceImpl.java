package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.MiddleProducttDao;
import com.kgc.hz.entity.Area;
import com.kgc.hz.entity.AreaPage;
import com.kgc.hz.entity.AreaParameter;
import com.kgc.hz.entity.ResponseResult;
import com.kgc.hz.service.MiddleProducttService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service("middleProducttService")
public class MiddleProducttServiceImpl implements MiddleProducttService {
    @Resource(name = "middleProducttDao")
    private MiddleProducttDao middleProducttDao;
    @Override
    public AreaPage getAreas(AreaParameter parameter) {
        if(StringUtils.isEmpty(parameter)){
            parameter = new AreaParameter();
        }
        parameter.setPageIndex((parameter.getCurPage()-1)*parameter.getPageSize());
        int count = middleProducttDao.getAreaCount(parameter);
        List<Area> list = middleProducttDao.getAreaList(parameter);
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
        int flag = middleProducttDao.addArea(area);
        rs.setFlag(1);
        rs.setResult(true);
        rs.setData(flag);
        return rs;
    }

    @Override
    public Area getArea(int id) {
        Area area = middleProducttDao.getArea(id);
        return area;
    }

    @Override
    public ResponseResult updateArea(Area area) {
        ResponseResult rs = new ResponseResult();
        int flag = middleProducttDao.updateArea(area);
        rs.setFlag(1);
        rs.setResult(true);
        rs.setData(flag);
        return rs;
    }

    @Override
    public ResponseResult deleteArea(Area area) {
        ResponseResult rs = new ResponseResult();
        int flag = middleProducttDao.deleteArea(area);
        rs.setFlag(1);
        rs.setResult(true);
        rs.setData(flag);
        return rs;
    }
}
