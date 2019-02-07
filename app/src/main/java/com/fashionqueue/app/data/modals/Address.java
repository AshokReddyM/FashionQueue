package com.fashionqueue.app.data.modals;

public class Address {
    private String name;
    private String flat_no;
    private String apartment_name;
    private String locality;
    private String nearby;
    private String district;
    private String state;
    private String pincode;
    private String mobile_number;

    public Address(String name, String flat_no, String apartment_name, String locality, String nearby, String district, String state, String pincode, String mobile_number) {
        this.name = name;
        this.flat_no = flat_no;
        this.apartment_name = apartment_name;
        this.locality = locality;
        this.nearby = nearby;
        this.district = district;
        this.state = state;
        this.pincode = pincode;
        this.mobile_number = mobile_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlat_no() {
        return flat_no;
    }

    public void setFlat_no(String flat_no) {
        this.flat_no = flat_no;
    }

    public String getApartment_name() {
        return apartment_name;
    }

    public void setApartment_name(String apartment_name) {
        this.apartment_name = apartment_name;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getNearby() {
        return nearby;
    }

    public void setNearby(String nearby) {
        this.nearby = nearby;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }
}