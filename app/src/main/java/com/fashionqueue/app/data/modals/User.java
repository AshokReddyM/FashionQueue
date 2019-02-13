package com.fashionqueue.app.data.modals;

public class User {
    private String mobile_number;
    private String email;

    public User(String mobile_number, String email) {
        this.mobile_number = mobile_number;
        this.email = email;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}