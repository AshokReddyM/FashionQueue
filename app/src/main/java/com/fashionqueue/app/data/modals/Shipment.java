package com.fashionqueue.app.data.modals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Shipment implements Serializable {
    private static final long serialVersionUID = 1L;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("cost")
    @Expose
    private String cost;

    @SerializedName("shipped_at")
    @Expose
    private Address shippedAt;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("selected_shipping_rate_id")
    @Expose
    private Integer selectedShippingRateId;


    public Shipment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public Address getShippedAt() {
        return shippedAt;
    }

    public void setShippedAt(Address shippedAt) {
        this.shippedAt = shippedAt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getSelectedShippingRateId() {
        return selectedShippingRateId;
    }

    public void setSelectedShippingRateId(Integer selectedShippingRateId) {
        this.selectedShippingRateId = selectedShippingRateId;
    }

}
