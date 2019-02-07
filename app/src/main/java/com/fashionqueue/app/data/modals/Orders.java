package com.fashionqueue.app.data.modals;

public class Orders {
    private String order_id;
    private String order_date;
    private String status;
    private String address;
    private String delivery_by;
    private String order_tracking_id;

    public Orders(String order_id, String order_date, String status, String address, String delivery_by, String order_tracking_id) {
        this.order_id = order_id;
        this.order_date = order_date;
        this.status = status;
        this.address = address;
        this.delivery_by = delivery_by;
        this.order_tracking_id = order_tracking_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDelivery_by() {
        return delivery_by;
    }

    public void setDelivery_by(String delivery_by) {
        this.delivery_by = delivery_by;
    }

    public String getOrder_tracking_id() {
        return order_tracking_id;
    }

    public void setOrder_tracking_id(String order_tracking_id) {
        this.order_tracking_id = order_tracking_id;
    }
}
