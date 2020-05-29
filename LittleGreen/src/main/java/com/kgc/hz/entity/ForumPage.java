package com.kgc.hz.entity;

import java.util.List;

public class ForumPage extends Page {
    private List<Forum> forumList;

    public List<Forum> getForumList() {
        return forumList;
    }

    public void setForumList(List<Forum> forumList) {
        this.forumList = forumList;
    }
}
