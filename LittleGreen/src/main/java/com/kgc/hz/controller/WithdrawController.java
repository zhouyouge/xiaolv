package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.WithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class WithdrawController {
    @Autowired
    private WithdrawService withdrawService;

    @RequestMapping(value = "addwithdra",method = RequestMethod.GET)
    public String getWithdrawList(Model model){
       List<Putin> list=withdrawService.getPutin();
        model.addAttribute("witList",list);
        return "addwithdra";
    }

    /**
     * 添加提现记录
     * @param withdraws
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addWithdras",method = RequestMethod.POST)
    public Object addWithdraw(Withdraw withdraws, HttpSession session){
        User us = (User) session.getAttribute("user");
        ResponseResult rs=null;
        if (!StringUtils.isEmpty(us)){
            withdraws.setUserId(us.getId());
            rs = withdrawService.addWithdrawd(withdraws);
        }else {
            rs=new ResponseResult();
            rs.setFlag(7);
            rs.setData("用户没登录");
        }
        System.out.println("++++++++++用户id：：：："+withdraws.getUserId());
        return JSON.toJSONString(rs);

    }

    /**
     * 分页查询
     * @param parameter
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "wits",method = RequestMethod.GET)
    public String geiwit(WithdrawParameter parameter,
                         HttpSession session,Model model){
        User users=(User)session.getAttribute("user") ;
        ResponseResult rs=new ResponseResult();
        if (!StringUtils.isEmpty(users)){
            parameter.setUserName(users.getUserName());
         WithdrawPage page= withdrawService.getWithdraws(parameter);
            rs.setResult(true);
            rs.setFlag(1);
            rs.setData(page);
            rs.setWithdrawLists(page.getWithdrawLists());
        }else {
            rs.setFlag(7);
            rs.setData("用户没登录");
        }
        model.addAttribute("witResult",rs);
        return "wits";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delwit",method = RequestMethod.GET)
    public Object deletewit(@RequestParam("id") Integer id,
                            HttpSession session, Model Model){
        User users=(User)session.getAttribute("user") ;
        ResponseResult rs=new ResponseResult();
        if (!StringUtils.isEmpty(users)) {
                rs=withdrawService.deletewit(id);

        }else {
            rs.setFlag(7);
            rs.setData("用户没登录");

        }
        return JSON.toJSONString(rs);
    }

    /**
     * 视图修改
     * @param
     * @param
     * @return
     */
     @RequestMapping(value = "/updateWit/{id}",
             method = RequestMethod.GET)
     public String viewModifyWit(@PathVariable("id") Integer id,
                                 HttpSession session,Model model){
        User users=(User) session.getAttribute("user");
        ResponseResult rs=new ResponseResult();
        if (!StringUtils.isEmpty(users)){
            Withdraw wit=withdrawService.getWits(id);
            List<Putin> putinList=withdrawService.getPutin();
            model.addAttribute("wit",wit);
            model.addAttribute("putList",putinList);
        }
        return "updateWit";

     }
           /* @RequestMapping(value = "/updateWit",method = RequestMethod.GET)
            public String updateWit(){
                return "updateWit";
            }*/


    /**
     * 保存修改
     * @param withdraw
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updeteWits",method = RequestMethod.POST)
    public Object updeteWits(Withdraw withdraw,HttpSession session){
        ResponseResult rs=withdrawService.updeteWits(withdraw);
        return JSON.toJSONString(rs);
    }

}

