package com.pms.dao.pojo;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

public class User implements Serializable {
    private int userid;
    private String username;
    private String password;
    private int pri;

    public User(int userid, String username, String password, int pri) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.pri = pri;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", pri=" + pri +
                '}';
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPri() {
        return pri;
    }

    public void setPri(int pri) {
        this.pri = pri;
    }
}
