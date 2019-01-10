package com.netflix.houserental.business.model;

import java.util.Date;
import java.util.UUID;

public class User {
    private String userId;

    private String userName;

    private String password;

    private Date createTime;

    private Date updateTime;

    public User(String userName, String password) {
        this.userId=UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public User(){ }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}