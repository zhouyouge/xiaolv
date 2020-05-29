package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.PutinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PutinController {

    @Autowired
    private PutinService putinService;

    @RequestMapping(value = "addPutin",method = RequestMethod.GET)
    public String getAddPutin(){

        return "addPutin";
    }

    @ResponseBody
    @RequestMapping(value = "/addPut",method = RequestMethod.POST)
    public Object addPutin(Putin putin, HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs =null;
        if(!StringUtils.isEmpty(user)){
            rs = putinService.addPutin(putin);
        }else {
            rs.setFlag(7);
            rs.setData("用户没有登录");
        }
        return JSON.toJSONString(rs);
    }

/**
 * 分页查询
 */
@RequestMapping(value = "PutinList",method = RequestMethod.GET)
    public String getPutins(PutinParameter parameter, HttpSession session, Model model){
    User user = (User) session.getAttribute("user");
    ResponseResult rs = new ResponseResult();
    if(!StringUtils.isEmpty(user)){
        parameter.setUserName(user.getUserName());
        PutinPage page = putinService.getPutins(parameter);
        rs.setResult(true);
        rs.setFlag(1);
        rs.setData(page);
        rs.setPutinList(page.getPutinList());
    }else {
        rs.setFlag(7);
        rs.setData("用户没有登录");
    }
    model.addAttribute("putList",rs);
    return "PutinList";
}

/**
 * 修改投放记录
 */
    @RequestMapping(value = "/updatePutin",method = RequestMethod.GET)
    public String updatePutin(@RequestParam("id") Integer id,HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(user)){
            Putin putin = putinService.getPutin(id);
            List<Area> areaList = putinService.getAreaList();
            model.addAttribute("putin",putin);
            model.addAttribute("areaList",areaList);
        }else {
            rs.setFlag(7);
            rs.setData("用户没有登录");
        }
        return "updatePutin";
    }
    @ResponseBody
    @RequestMapping(value = "/updatePutins",method = RequestMethod.POST)
    public Object updatePutins(Putin putin,HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(user)){
           rs= putinService.updatePutin(putin);
        }else {
            rs.setFlag(7);
            rs.setData("用户没有登录");
        }
        return JSON.toJSONString(rs);
    }


    /**
     * 删除投放记录
     */
    @ResponseBody
    @RequestMapping(value = "delPutin",method = RequestMethod.GET)
    public Object delPutin(@RequestParam("id") Integer id,HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(user)){
            rs= putinService.delPutin(id);
        }else {
            rs.setFlag(7);
            rs.setData("用户没有登录");
        }
        return JSON.toJSONString(rs);
    }
}
