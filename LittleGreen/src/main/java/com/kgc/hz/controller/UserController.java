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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 管理员登录
     * @param user
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "login",method = RequestMethod.POST)
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
     * @param
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/loginOut",method = RequestMethod.GET)
    public Object loginOut(HttpSession session){
        ResponseResult rs = new ResponseResult();
        User users = (User) session.getAttribute("user");
        if (!StringUtils.isEmpty(users)){
            session.removeAttribute("user");
            rs.setFlag(1);
            rs.setResult(true);
        }else {
            rs.setFlag(2);
            rs.setData("用户未登录！");
            rs.setResult(false);
        }
        return JSON.toJSON(rs);
    }
    /**
     * 分页查询用户
     * @param parameter
     * @param model
     * @return
     */
    @RequestMapping(value = "user",method = RequestMethod.GET)
    public String getUser(UserParameter parameter, Model model){
        UserPage page = userService.getUser(parameter);
        model.addAttribute("userList",page);
        return "users";
    }
    /**
     * 添加用户
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "/addUsers",method = RequestMethod.GET)
    public String addUsers(Model model){
        return "addUser";
    }

    @ResponseBody
    @RequestMapping(value = "addUsers",method = RequestMethod.POST)
    public Object addUser(User user,Model model){
        ResponseResult rs = userService.addUsers(user);
        return JSON.toJSONString(rs);
    }

    /**
     * 修改用户信息
     * @param id
     * @param model
     * @param user
     * @return
     */
    @RequestMapping(value = "/updateUser/{id}",method = RequestMethod.GET)
    public String getUsers(@PathVariable("id") int id, Model model, User user){
        User users = userService.getUsers(id);
        model.addAttribute("users",users);
        return "updateUser";
    }
    @ResponseBody
    @RequestMapping(value = "update",method = RequestMethod.POST)
    public Object updateUser(User user){
        ResponseResult rs = userService.updateUser(user);
        return JSON.toJSONString(rs);
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "deleteUser",method = RequestMethod.GET)
    public String deleteUsers(User user){
        ResponseResult rs = userService.deleteUser(user);
        return JSON.toJSONString(rs);
    }

}
