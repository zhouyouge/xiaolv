package com.kgc.hz.service;

import com.kgc.hz.entity.ResponseResult;
import com.kgc.hz.entity.User;
import com.kgc.hz.entity.UserPage;
import com.kgc.hz.entity.UserParameter;

public interface UserService {
    /**
     * 登录接口
     * @param user
     * @return
     */
    ResponseResult loginUser(User user);
    /**
     * 分页查询用户
     * @param parameter
     * @return
     */
    UserPage getUser(UserParameter parameter);
    /**
     * 添加用户，使用结果集
     * @param user
     * @return
     */
    ResponseResult addUsers(User user);

    /**
     * 修改用户
     * @param id
     * @return
     */
    User getUsers(int id);
    ResponseResult updateUser(User user);

    /**
     * 删除
     * @param user
     * @return
     */
    ResponseResult deleteUser(User user);
}
