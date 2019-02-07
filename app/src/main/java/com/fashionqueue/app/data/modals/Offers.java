package com.fashionqueue.app.data.modals;

public class Offers {
    private String offer_title;
    private String offer_details;
    private String offer_validation;
    private String offer_code;
    private String percentage;
    private String offer_type;

    public Offers(String offer_title, String offer_details, String offer_validation, String offer_code, String percentage, String offer_type) {
        this.offer_title = offer_title;
        this.offer_details = offer_details;
        this.offer_validation = offer_validation;
        this.offer_code = offer_code;
        this.percentage = percentage;
        this.offer_type = offer_type;
    }

    public String getOffer_title() {
        return offer_title;
    }

    public void setOffer_title(String offer_title) {
        this.offer_title = offer_title;
    }

    public String getOffer_details() {
        return offer_details;
    }

    public void setOffer_details(String offer_details) {
        this.offer_details = offer_details;
    }

    public String getOffer_validation() {
        return offer_validation;
    }

    public void setOffer_validation(String offer_validation) {
        this.offer_validation = offer_validation;
    }

    public String getOffer_code() {
        return offer_code;
    }

    public void setOffer_code(String offer_code) {
        this.offer_code = offer_code;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getOffer_type() {
        return offer_type;
    }

    public void setOffer_type(String offer_type) {
        this.offer_type = offer_type;
    }
}
