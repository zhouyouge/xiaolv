package com.kgc.hz.service;

import com.kgc.hz.entity.*;

import java.util.List;

public interface ForumService {

    /**
     * 查询
     * @return
     */
    List<Forum> getForumList();

    /**
     * 添加
     * @param forum
     * @return
     */
    ResponseResult addForum(Forum forum);

    /**
     * 分页查询
     * @param parameter
     * @return
     */
    ForumPage getForums(WithdrawParameter parameter);

    /**
     * 删除
     * @param id
     * @return
     */
    ResponseResult deletefor(int id);

    /**
     * 修改
     * @param forum
     * @return
     */
    ResponseResult updetefor(Forum forum);

    /**
     * 根据ID查询单个销售记录信息
     * @param id
     * @return
     */
    Forum getfors(int id);
}
