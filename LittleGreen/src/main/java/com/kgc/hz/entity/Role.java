package com.kgc.hz.entity;

import java.io.Serializable;

public class Role implements Serializable {
    /**
     * 编号
     */
    private Integer id;


    /**
     * 用户角色
     */
    private String roleName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
