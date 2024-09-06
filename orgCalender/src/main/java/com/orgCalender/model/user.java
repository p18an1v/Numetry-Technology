package com.orgCalender.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public  class user{

    private String userName;
    private int userPswd;


    public user(String userName, int userPswd) {
        this.userName = userName;
        this.userPswd = userPswd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserPswd() {
        return userPswd;
    }

    public void setUserPswd(int userPswd) {
        this.userPswd = userPswd;
    }
}

