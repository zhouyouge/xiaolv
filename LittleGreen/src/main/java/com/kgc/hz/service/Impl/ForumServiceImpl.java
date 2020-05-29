package com.kgc.hz.service.Impl;

import com.kgc.hz.dao.ForumDao;
import com.kgc.hz.entity.*;
import com.kgc.hz.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("forumService")
public class ForumServiceImpl implements ForumService {
    @Autowired
    private ForumDao forumDao;

    @Override
    public  List<Forum> getForumList() {
        return forumDao.getForumList();
    }

    @Override
    public ResponseResult addForum(Forum forum) {
        ResponseResult rs=new ResponseResult();
        if (StringUtils.isEmpty(forum)){
            rs.setFlag(0);
            rs.setData("传参为空");
        }
        if (StringUtils.isEmpty(forum.getForumContent())){
            rs.setFlag(1);
            rs.setData("论坛内容为空");
        }
        if (StringUtils.isEmpty(forum.getForumName())){
            rs.setFlag(2);
            rs.setData("论坛主题为空");
        }
        if (StringUtils.isEmpty(forum.getUploader())){
            rs.setFlag(3);
            rs.setData("上传人为空");
        }
       if ( forumDao.addForum(forum)>0){
           rs.setResult(true);
           rs.setFlag(4);
           rs.setData("论坛信息添加成功!");
       }


        return rs;
    }

    /**
     * 分页
     * @param parameter
     * @return
     */
    @Override
    public ForumPage getForums(WithdrawParameter parameter) {
        if (StringUtils.isEmpty(parameter)){
            parameter= new WithdrawParameter();
        }
        //计算当前页下标
        parameter.setPageIndex((parameter.getCurPage()-1)* parameter.getPageSize());
        int count= forumDao.getForumCount(parameter);
        List<Forum> list=forumDao.getForumPage(parameter);
        ForumPage page=new ForumPage();
        page.setTotalCount(count);
        page.setForumList(list);
        page.setCurPage(parameter.getCurPage());
        page.setPageSize(parameter.getPageSize());
        page.setTotalPageCount((count/page.getPageSize())+
                ((count%page.getPageSize())==0?0:1));

        return page;
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @Override
    public ResponseResult deletefor(int id) {
        int flag=  forumDao.deletefor(id);
        ResponseResult rs=new ResponseResult();
        if (flag>0){
            rs.setResult(true);
            rs.setFlag(1);
            rs.setData("删除成功");
        }else {
            rs.setFlag(2);
            rs.setData("删除失败");
        }
        return rs;
    }

    /**
     * 修改
     * @param forum
     * @return
     */
    @Override
    public ResponseResult updetefor(Forum forum) {
        ResponseResult rs=new ResponseResult();
        int flag=forumDao.updetefor(forum);
        rs.setResult(true);
        rs.setFlag(1);
        rs.setData("论坛信息修改成功");
        return rs;
    }

    /**
     * 修改
     * @param id
     * @return
     */
    @Override
    public Forum getfors(int id) {
        return forumDao.getfors(id);
    }
}
