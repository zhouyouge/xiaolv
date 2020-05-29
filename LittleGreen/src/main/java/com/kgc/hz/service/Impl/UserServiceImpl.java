package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.UserDao;
import com.kgc.hz.entity.ResponseResult;
import com.kgc.hz.entity.User;
import com.kgc.hz.entity.UserPage;
import com.kgc.hz.entity.UserParameter;
import com.kgc.hz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResponseResult loginUser(User user) {
        ResponseResult rs = new ResponseResult();
        if (StringUtils.isEmpty(user)) {
            rs.setFlag(0);
            rs.setData("传参为空");
        }
        if (StringUtils.isEmpty(user.getUserName())) {
            rs.setFlag(1);
            rs.setData("用户名为空");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            rs.setFlag(2);
            rs.setData("密码为空");
        }
        User users = userDao.getUser(user);
        if (StringUtils.isEmpty(users)) {
            rs.setFlag(3);
            rs.setData("用户名或密码不正确！");
        }else {
            rs.setResult(true);
            rs.setFlag(4);
            rs.setData(users);
        }
        return rs;
    }
    @Override
    public UserPage getUser(UserParameter parameter) {
        if(StringUtils.isEmpty(parameter)){
            parameter = new UserParameter();
        }
        parameter.setPageIndex((parameter.getCurPage()-1)*parameter.getPageSize());
        List<User> list = userDao.getuserList(parameter);
        int count = userDao.getCount(parameter);
        UserPage page = new UserPage();
        page.setUserList(list);
        page.setTotalCount(count);
        page.setCurPage(parameter.getCurPage());
        page.setPageSize(parameter.getPageSize());
        page.setTotalPageCount((count/page.getPageSize())
                +((count%page.getPageSize())==0?0:1));
        return page;
    }
    @Override
    public ResponseResult addUsers(User user) {
        if(StringUtils.isEmpty(user)){
        }
        int flag = userDao.addUser(user);
        ResponseResult rs = new ResponseResult();
        if(!StringUtils.isEmpty(flag)){
            rs.setResult(true);
            rs.setFlag(1);
            rs.setData(flag);
        }
        return rs;
    }

    @Override
    public User getUsers(int id) {
        return userDao.getUsers(id);
    }

    @Override
    public ResponseResult updateUser(User user) {
        int flag = userDao.updateUser(user);
        ResponseResult rs = new ResponseResult();
        if(StringUtils.isEmpty(flag)){

        }
        rs.setFlag(1);
        rs.setResult(true);
        rs.setData(flag);
        return rs;
    }

    @Override
    public ResponseResult deleteUser(User user) {
        ResponseResult rs = new ResponseResult();
        int flag = userDao.deleteUser(user);
        rs.setResult(true);
        rs.setFlag(1);
        rs.setData(flag);
        return rs;
    }
}
