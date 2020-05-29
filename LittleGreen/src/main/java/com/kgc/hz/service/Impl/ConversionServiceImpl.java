package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.ConversionDao;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("conversionService")
public class ConversionServiceImpl implements ConversionService {
    @Autowired
    ConversionDao conversionDao;


    @Override
    public List<Shop> getShopList() {
        return conversionDao.getShopList();
    }

    @Override
    public ConversionPage getConversions(ConversionParameter parameter) {
        if(StringUtils.isEmpty(parameter)){
            parameter = new ConversionParameter();
        }
        parameter.setPageIndex((parameter.getCurPage()-1)*parameter.getPageSize());
        int count = conversionDao.getConversionCount(parameter);
        List<Conversion> list = conversionDao.getConversionPage(parameter);
        ConversionPage page = new ConversionPage();
        page.setTotalCount(count);
        page.setConversionList(list);
        page.setCurPage(parameter.getCurPage());
        page.setPageSize(parameter.getPageSize());
        page.setTotalPageCount((count/page.getPageSize())+((count%page.getPageSize())==0?0:1));
        return page;
    }

    @Override
    public Conversion getConversion(int id) {
        return conversionDao.getConversion(id);
    }

    @Override
    public ResponseResult updateConversion(Conversion conversion) {
        int flag = conversionDao.updateConversion(conversion);
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
    public ResponseResult delConversion(int id) {
        int flag = conversionDao.delConversion(id);
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
