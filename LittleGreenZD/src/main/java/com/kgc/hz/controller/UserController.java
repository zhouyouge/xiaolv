package com.kgc.hz.controller;

import com.alibaba.fastjson.JSON;
import com.kgc.hz.entity.ResponseResult;
import com.kgc.hz.entity.User;
import com.kgc.hz.entity.UserPage;
import com.kgc.hz.entity.UserParameter;
import com.kgc.hz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *用户登录
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public Object loginUser(User user, HttpSession session){
        ResponseResult rs = userService.loginUser(user);
        if (!StringUtils.isEmpty(rs)) {
            if (rs.getResult()==true) {
                User users = (User) rs.getData();
                if (!StringUtils.isEmpty(users)) {
                    session.setAttribute("user",user);
                }
            }
        }
        return rs;
    }

    /**
     * 退出登录
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "loginOut",method = RequestMethod.GET)
    public Object loginOut(User user,HttpSession session){
        ResponseResult rs = new ResponseResult();
        user = (User) session.getAttribute("user");
        if (!StringUtils.isEmpty(user)) {
            session.removeAttribute("user");
            rs.setFlag(1);
            rs.setResult(true);
        }else {
            rs.setFlag(2);
            rs.setData("用户未登录");
            rs.setResult(false);
        }
        return JSON.toJSON(rs);
    }

    /**
     * 分页查询用户信息
     * @param parameter
     * @param model
     * @return
     */
    @RequestMapping(value = "user",method = RequestMethod.POST)
    public String User(UserParameter parameter, Model model){
        UserPage page = userService.getUser(parameter);
        model.addAttribute("userList",page);
        return "users";
    }
}
