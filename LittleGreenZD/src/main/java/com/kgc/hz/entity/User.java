package com.kgc.hz.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    /**
     * 编号
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     *密码
     */
    private String password;
    /**
     *用户角色id，对应角色表id
     */
    private Integer roleId;
    /**
     *真是姓名
     */
    private String realName;
    /**
     *地址
     */
    private String address;
    /**
     *用户电话
     */
    private String userPhone;



    /**
     *积分
     */
    private Integer integral;
    /**
     *账户余额
     */
    private double account;
    /**
     *创建时间
     */
    private Date createTime;
    /**
     *修改时间
     */
    private Date miTime;

    private String roleName;

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getMiTime() {
        return miTime;
    }

    public void setMiTime(Date miTime) {
        this.miTime = miTime;
    }
}
