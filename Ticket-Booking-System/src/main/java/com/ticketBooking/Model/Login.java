package com.ticketBooking.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Login {

    private String emailId;
    private String pswd;

    @Autowired
    public Login(String emailId, String pswd) {
        this.emailId = emailId;
        this.pswd = pswd;
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
