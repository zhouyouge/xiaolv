package com.kgc.hz.dao;

import com.kgc.hz.entity.Forum;
import com.kgc.hz.entity.WithdrawParameter;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("forumDao")
public interface ForumDao {
    /**
     * 查询
     * @return
     */
    List<Forum> getForumList();

    /**
     * 添加论坛信息
     * @param forum
     * @return
     */
    int  addForum(Forum forum);

    /**
     * 分页
     * @param parameter
     * @return
     */
    List<Forum> getForumPage(WithdrawParameter parameter);

    /**
     * 分页查总记录数
     * @param parameter
     * @return
     */
    int getForumCount(WithdrawParameter parameter);

    /**
     * 删除
     * @param id
     * @return
     */
    int deletefor(@Param("id") int id);

    /**
     * 修改
     * @param forum
     * @return
     */
    int updetefor(Forum forum);

    /**
     * 根据ID查询单个销售记录信息
     * @param id
     * @return
     */
    Forum getfors(@Param("id") int id);
}
