package com.kgc.hz.dao;

import com.kgc.hz.entity.User;
import com.kgc.hz.entity.UserParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public interface UserDao {
    /**
     * 用户登录
     * @param user
     * @return
     */
    User getUser(User user);
    /**
     * 分页查询用户
     * @param parameter
     * @return
     */
    List<User> getuserList(UserParameter parameter);

    /**
     * 获取总页数
     * @param parameter
     * @return
     */
    int getCount(UserParameter parameter);
    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 修改用户
     * @param id
     * @return
     */
    User getUsers(@Param("id") int id);
    int updateUser(User user);

    /**
     * 删除
     * @param user
     * @return
     */
    int deleteUser(User user);
}
