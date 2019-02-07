package com.fashionqueue.app.data.modals;

public class Favorite {
    private String product_id;

    public Favorite(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
}
