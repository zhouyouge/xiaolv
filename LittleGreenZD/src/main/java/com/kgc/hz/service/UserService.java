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
     * 分页查询用户信息
     * @param parameter
     * @return
     */
    UserPage getUser(UserParameter parameter);
}
