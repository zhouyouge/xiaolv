package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class ShopController {
    @Autowired
    private ShopService shopService;

    //分页查询商城信息
    @RequestMapping(value = "shop",method = RequestMethod.GET)
    public Object Shop(ShopParameter parameter, HttpSession session, Model model){
        //查询用户是否登录
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(user)) {
            parameter.setUserName(user.getUserName());
            //分页查询
            ShopPage page = shopService.getShopList(parameter);
            rs.setFlag(1);
            rs.setResult(true);
            rs.setData(page);
            rs.setShopList(page.getShopList());
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录");
        }
        model.addAttribute("Response",rs);
        return "shop";
    }

    /**
     * 添加商城信息
     * @return
     */
    @RequestMapping(value = "addS",method = RequestMethod.GET)
    public String addS(){
        return "addShop";
    }
    @ResponseBody
    @RequestMapping(value = "/addShop",method = RequestMethod.POST)
    public Object addShop(Shop shop,HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = null;
        if (!StringUtils.isEmpty(user)) {
            rs = shopService.addShop(shop);
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录");
        }
        return JSON.toJSONString(rs);
    }

    /**
     * 根据id值修改商城信息
     * @return
     */
    @RequestMapping(value = "updateShops/{id}",method = RequestMethod.POST)
    public String updateShops(@PathVariable("id") int id,HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        if (!StringUtils.isEmpty(user)) {
            Shop shop = shopService.getShop(id);
            session.setAttribute("shop",shop);
        }
        return "updateShop";
    }
    @ResponseBody
    @RequestMapping(value = "/updateShoping",method = RequestMethod.POST)
    public Object updateShops(Shop shop,HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(user)) {
            rs = shopService.updateShop(shop);
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录！");
        }
        return JSON.toJSON(rs);
    }

    /**
     * 删除商城信息
     * @param id
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delShop",method = RequestMethod.GET)
    public Object delShop(@RequestParam("id") int id, HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(user)) {
            rs = shopService.deleteShop(id);
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录!");
        }
        return JSON.toJSON(rs);
    }
}
