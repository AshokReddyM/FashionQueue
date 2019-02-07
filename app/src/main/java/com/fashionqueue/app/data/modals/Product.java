package com.fashionqueue.app.data.modals;

public class Product {
    private String offer;
    private String available_status;
    private String product_type;
    private String product_name;
    private String product_id;
    private String product_price;
    private String product_description;
    private String product_quantity;

    public Product(String offer, String available_status, String product_type,
                   String product_name, String product_id, String product_price,
                   String product_description, String product_quantity) {
        this.offer = offer;
        this.available_status = available_status;
        this.product_type = product_type;
        this.product_name = product_name;
        this.product_id = product_id;
        this.product_price = product_price;
        this.product_description = product_description;
        this.product_quantity = product_quantity;
    }

    public String getOffer() {
        return offer;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public String getAvailable_status() {
        return available_status;
    }

    public void setAvailable_status(String available_status) {
        this.available_status = available_status;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_quantity() {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }
}
