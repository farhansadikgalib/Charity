package com.farhan.charity.Model;

public class LogInModelClass {
    private String admin_mobile;
    private String admin_password;

    public LogInModelClass(String admin_mobile, String admin_password) {
        this.admin_mobile = admin_mobile;
        this.admin_password = admin_password;
    }

    public String getAdmin_mobile() {
        return admin_mobile;
    }

    public void setAdmin_mobile(String admin_mobile) {
        this.admin_mobile = admin_mobile;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
}
