package com.ticketBooking.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class user {
    private String userName;
    private long mobNumber;
    private String emailId;
    private String pswd;

    @Autowired
    public user(String userName, long mobNumber, String emailId, String pswd) {
        this.userName = userName;
        this.mobNumber = mobNumber;
        this.emailId = emailId;
        this.pswd = pswd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(long mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }
}
