package com.kgc.hz.dao;

import com.kgc.hz.entity.User;
import com.kgc.hz.entity.UserParameter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    /**
     * 登录接口
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 分页查询
     * @param parameter
     * @return
     */
    List<User> getUserList(UserParameter parameter);

    /**
     * 记录总页数
     * @param parameter
     * @return
     */
    int getCount(UserParameter parameter);
}
