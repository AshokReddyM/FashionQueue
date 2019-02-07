package com.fashionqueue.app.data.modals;

public class Profile {
    private String first_name;
    private String last_name;
    private String mobile_number;
    private int gender;
    private String email;
    private String dob;

    public Profile(String first_name, String last_name, String mobile_number, int gender, String email, String dob) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.mobile_number = mobile_number;
        this.gender = gender;
        this.email = email;
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
