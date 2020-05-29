package com.kgc.hz.entity;

import java.util.List;

public class UserPage extends Page {
    private List<User> userList;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
