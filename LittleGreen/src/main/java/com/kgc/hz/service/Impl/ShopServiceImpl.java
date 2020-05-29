package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.ShopDao;
import com.kgc.hz.entity.ResponseResult;
import com.kgc.hz.entity.Shop;
import com.kgc.hz.entity.ShopPage;
import com.kgc.hz.entity.ShopParameter;
import com.kgc.hz.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    /**
     * 全查商城信息
     * @return
     */
    @Override
    public List<Shop> getShopList() {
        return shopDao.getShopList();
    }

    /**
     * 分页查询商城信息
     * @param parameter
     * @return
     */
    @Override
    public ShopPage getShopList(ShopParameter parameter) {
        if (StringUtils.isEmpty(parameter)) {
            parameter = new ShopParameter();
        }
        //计算当前页下标
        parameter.setPageIndex((parameter.getCurPage()-1)*(parameter.getPageSize()));
        //记录总数据量
        int count = shopDao.ShopCount(parameter);
        //封装当前集合数据
        List<Shop> list = shopDao.getShopPage(parameter);
        //创建商城分页对象
        ShopPage page = new ShopPage();
        //封装总记录数
        page.setTotalCount(count);
        //封装商城的集合数据
        page.setShopList(list);
        //封装当前页码
        page.setCurPage(parameter.getCurPage());
        //封装当前页尺寸
        page.setPageSize(parameter.getPageSize());
        //封装总页数
        page.setTotalPageCount((count/page.getPageSize())+((count%page.getPageSize())==0?0:1));
        return page;
    }

    /**
     * 添加商城信息
     * @param shop
     * @return
     */
    @Override
    public ResponseResult addShop(Shop shop) {
        ResponseResult rs = new ResponseResult();
        //判断传入参数
        if (StringUtils.isEmpty(shop)) {
            rs.setFlag(0);
            rs.setData("传参为空！");
        }
        if (StringUtils.isEmpty(shop.getId())) {
            rs.setFlag(1);
            rs.setData("商品id为空！");
        }
        if (StringUtils.isEmpty(shop.getShopName())) {
            rs.setFlag(2);
            rs.setData("商品名称为空！");
        }
        if (StringUtils.isEmpty(shop.getShopPrice())) {
            rs.setFlag(3);
            rs.setData("商品价格为空！");
        }
        if (StringUtils.isEmpty(shop.getCreateTime())) {
            rs.setFlag(4);
            rs.setData("添加时间为空！");
        }
        if (StringUtils.isEmpty(shop.getMiTime())) {
            rs.setFlag(5);
            rs.setData("修改时间为空！");
        }
        if (shopDao.addShop(shop)>0) {
            rs.setFlag(6);
            rs.setResult(true);
            rs.setData(shop);
        }
        return rs;
    }

    /**
     * 修改商城信息
     * @param shop
     * @return
     */
    @Override
    public ResponseResult updateShop(Shop shop) {
        ResponseResult rs = new ResponseResult();
        if (StringUtils.isEmpty(shop)) {
            rs.setFlag(0);
            rs.setData("传参为空！");
        }
        if (StringUtils.isEmpty(shop.getId())) {
            rs.setFlag(1);
            rs.setData("商品id为空！");
        }
        if (StringUtils.isEmpty(shop.getShopName())) {
            rs.setFlag(2);
            rs.setData("商品名称为空！");
        }
        if (StringUtils.isEmpty(shop.getShopPrice())) {
            rs.setFlag(3);
            rs.setData("商品价格为空！");
        }
        int flag = shopDao.updateShop(shop);
        if (flag>0) {
            rs.setFlag(6);
            rs.setResult(true);
            rs.setData(shop);
        }
        return rs;
    }
    @Override
    public Shop getShop(int id) {
        return shopDao.getShop(id);
    }

    /**
     * 删除商城信息
     * @param id
     * @return
     */
    @Override
    public ResponseResult deleteShop(int id) {
        ResponseResult rs = new ResponseResult();
        int a=shopDao.deleteShop(id);
        if (a>0) {
            rs.setFlag(1);
            rs.setData("删除成功");
            rs.setResult(true);
        }else {
            rs.setFlag(2);
            rs.setData("删除失败");
        }
        return rs;
    }
}
