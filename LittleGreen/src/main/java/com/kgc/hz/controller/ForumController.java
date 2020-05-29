package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ForumController {
    @Autowired
    private ForumService forumService;

    /**
     * 查询论坛
     * @param model
     * @return
     */
    @RequestMapping(value = "/addfor", method = RequestMethod.GET)
    public String addForumList(Model model) {
        List<Forum> list = forumService.getForumList();
        model.addAttribute("forList", list);
        return "addfor";

    }

    /**
     * 添加
     * @param forum
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/forumList", method = RequestMethod.POST)
    public Object addForum(Forum forum, HttpSession session) {
        User us = (User) session.getAttribute("user");
        ResponseResult rs = null;
        if (!StringUtils.isEmpty(us)) {
            forum.setUserId(us.getId());
            rs = forumService.addForum(forum);
        } else {
            rs = new ResponseResult();
            rs.setFlag(7);
            rs.setData("用户没登录");
        }

        return JSON.toJSONString(rs);
    }
    /**
     * 分页查询
     * @param parameter
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "Forum",method = RequestMethod.GET)
    public String getforums(WithdrawParameter parameter,
                         HttpSession session,Model model){
        User users=(User)session.getAttribute("user") ;
        ResponseResult rs =new ResponseResult();
        if (!StringUtils.isEmpty(users)){
            parameter.setUserName(users.getUserName());
            ForumPage page= forumService.getForums(parameter);
            rs.setResult(true);
            rs.setFlag(1);
            rs.setData(page);
            rs.setForumList(page.getForumList());
        }else {
            rs.setFlag(7);
            rs.setData("用户没登录");
        }
        model.addAttribute("forumResult",rs);
        return "Forum";
    }
    /**
     * 删除
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/delfro",method = RequestMethod.GET)
    public Object deletefor(@RequestParam("id") Integer id,
                            HttpSession session){
        User users=(User)session.getAttribute("user") ;
        ResponseResult rs=new ResponseResult();
        if (!StringUtils.isEmpty(users)) {
            rs=forumService.deletefor(id);

        }else {
            rs.setFlag(7);
            rs.setData("用户没登录");

        }
        return JSON.toJSONString(rs);
    }

    /**
     * 视图修改
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "/updetefor/{id}",
            method = RequestMethod.GET)
    public String viewModifyFor(@PathVariable("id") Integer id,
                                HttpSession session,Model model){
        User users=(User) session.getAttribute("user");
        ResponseResult rs=new ResponseResult();
        if (!StringUtils.isEmpty(users)){
            Forum fors=forumService.getfors(id);
            List<Forum> forumList=forumService.getForumList();
            model.addAttribute("fors",fors);
            model.addAttribute("forumList",forumList);
        }
        return "updetefor";

    }

    /**
     * 保存修改
     * @param forum
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "updetefors",method = RequestMethod.POST)
    public Object updeteWits(Forum forum,HttpSession session){
        ResponseResult rs=forumService.updetefor(forum);
        return JSON.toJSONString(rs);
    }

}
