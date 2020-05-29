package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class CabinetController {
    @Autowired
    private CabinetService cabinetService;

    /**
     * 按条件查询回收柜信息
     * @param parameter
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "cabinetBBB",method = RequestMethod.GET)
    public Object cabinets(CabinetParameter parameter,HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(user)) {
           CabinetPage page = cabinetService.getCabList(parameter);
           rs.setFlag(1);
           rs.setData(page);
           rs.setResult(true);
           rs.setCabinetList(page.getCabinetList());
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录");
        }
        return JSON.toJSON(rs);
    }

    //分页查询回收柜信息页面
    @RequestMapping(value = "cabinet",method = RequestMethod.GET)
    public String cabinet(CabinetParameter parameter, HttpSession session,Model model){
        //查询用户是否登录
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if (!StringUtils.isEmpty(user)) {
            parameter.setUserName(user.getUserName());
            //分页查询
            CabinetPage page = cabinetService.getCabList(parameter);
            rs.setResult(true);
            rs.setFlag(1);
            rs.setData(page);
            rs.setCabinetList(page.getCabinetList());
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录");
        }
        model.addAttribute("responseResult",rs);
        return "cabinet";
    }

    /**
     * 跳转到添加回收柜页面
     * @param
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "addCab",method = RequestMethod.GET)
    public String addCab(){
        return "addCab";
    }
    /**
     * 添加回收柜信息
     * @param cabinet
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "addCabinet",method = RequestMethod.POST)
    public Object addCabinet(Cabinet cabinet,HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = null;
        if (!StringUtils.isEmpty(user)){
            rs = cabinetService.addCabinet(cabinet);
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录");
        }
        return JSON.toJSONString(rs);
    }

    /**
     * 根据 id 值修改页面
     * @return
     */
    @RequestMapping(value = "updateCab/{id}",method = RequestMethod.POST)
    public String updateCabine(@PathVariable("id") int id, HttpSession session){
        User user = (User)session.getAttribute("user");
        if (!StringUtils.isEmpty(user)) {
            Cabinet cabinet = cabinetService.getCab(id);
            session.setAttribute("cabinet",cabinet);
        }
        return "updateCab";
    }

    @ResponseBody
    @RequestMapping(value = "/updateCabinet",method = RequestMethod.POST)
    public Object updateCa(Cabinet cabinet,HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = null;
        if (!StringUtils.isEmpty(user)) {
            rs = cabinetService.updateCabinet(cabinet);
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录");
        }
        System.out.println(rs.getResult()+"----"+rs.getData()+"-----"+rs.getFlag());
        return JSON.toJSONString(rs);
    }

   /* *//**
     * 修改页面
     * @return
     *//*
    @RequestMapping(value = "updateCab/{id}",method = RequestMethod.POST)
    public String updateCabinet(@PathVariable("id") int id,HttpSession session){
        User user = (User)session.getAttribute("user");
        if (!StringUtils.isEmpty(user)) {
            Cabinet cabinet = cabinetService.getCab(id);
            session.setAttribute("cabinet",cabinet);
        }
        return "updateCab";
    }

    @ResponseBody
    @RequestMapping(value = "/updateCabinet",method = RequestMethod.POST)
    public Object updateCab(Cabinet cabinet,HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = null;
        if (!StringUtils.isEmpty(user)) {
            rs = cabinetService.updateCabinet(cabinet);
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录");
        }
        System.out.println("++++++++"+JSON.toJSONString(rs));
        return JSON.toJSONString(rs);
    }*/

    /**
     * 删除回收柜信息
     * @param id
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delCab",method = RequestMethod.GET)
    public Object delCabinet(@RequestParam("id") int id, HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = null;
        if (!StringUtils.isEmpty(user)) {
            rs = cabinetService.deleteCabinet(id);
        }else {
            rs.setFlag(7);
            rs.setData("用户未登录！");
        }
        return JSON.toJSON(rs);
    }
}
