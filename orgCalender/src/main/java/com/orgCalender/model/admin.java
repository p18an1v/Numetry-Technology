package com.orgCalender.model;

import org.springframework.beans.factory.annotation.Autowired;

public class admin {

    private String admin;
    private String adminPswd;

    public admin(String admin, String adminPswd) {
        this.admin = admin;
        this.adminPswd = adminPswd;
    }


    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAdminPswd() {
        return adminPswd;
    }

    public void setAdminPswd(String adminPswd) {
        this.adminPswd = adminPswd;
    }
}
