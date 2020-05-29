package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 论坛信息表
 */
public class Forum implements Serializable {

    private Integer id;//论坛id
    private String forumName;//主题
    private String forumContent;//发表内容
    private String uploader;//上传人
    private Date forumTime;//上传时间
    private Integer userId;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getForumName() {
        return forumName;
    }

    public void setForumName(String forumName) {
        this.forumName = forumName;
    }

    public String getForumContent() {
        return forumContent;
    }

    public void setForumContent(String forumContent) {
        this.forumContent = forumContent;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public Date getForumTime() {
        return forumTime;
    }

    public void setForumTime(Date forumTime) {
        this.forumTime = forumTime;
    }
}
