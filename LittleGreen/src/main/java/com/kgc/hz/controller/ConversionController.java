package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class ConversionController {

    @Autowired
    private ConversionService conversionService;

    /**
     * 分页查询
     */
    @RequestMapping(value = "ConversionList",method = RequestMethod.GET)
    public String getConversions(ConversionParameter parameter, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(user)) {
            parameter.setUserName(user.getUserName());
            ConversionPage page = conversionService.getConversions(parameter);
            rs.setResult(true);
            rs.setFlag(1);
            rs.setData(page);
            rs.setConversionList(page.getConversionList());
        }else {
            rs.setFlag(7);
            rs.setData("用户没有登录");
        }
        model.addAttribute("conList",rs);
        return "ConversionList";
    }

    /**
     * 修改投放记录
     */
    @RequestMapping(value = "/updateConversion",method = RequestMethod.GET)
    public String updateConversion(@RequestParam("id") Integer id,HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(user)){
            Conversion conversion = conversionService.getConversion(id);
            model.addAttribute("conversion",conversion);
        }else {
            rs.setFlag(7);
            rs.setData("用户没有登录");
        }
        return "updateConversion";
    }
    @ResponseBody
    @RequestMapping(value = "/updateConversions",method = RequestMethod.POST)
    public Object updateConversions(Conversion conversion, HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(user)){
            rs= conversionService.updateConversion(conversion);
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
    @RequestMapping(value = "delConversion",method = RequestMethod.GET)
    public Object delPutin(@RequestParam("id") Integer id, HttpSession session){
        User user = (User) session.getAttribute("user");
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(user)){
            rs= conversionService.delConversion(id);
        }else {
            rs.setFlag(7);
            rs.setData("用户没有登录");
        }
        return JSON.toJSONString(rs);
    }

}
