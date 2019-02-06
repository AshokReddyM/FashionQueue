package com.fashionqueue.app.data.modals;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Product implements Parcelable {

    public abstract String offer();

    public abstract String availableStatus();

    public abstract String productType();

    public abstract String productName();

    public abstract String productId();

    public abstract String productPrice();

    public abstract String productDescription();

    public abstract String productQuantity();

    public static Product create(String offer, String available_status, String product_type,
                                 String product_name, String product_id,
                                 String product_price, String product_description,String product_quantity) {
        return new AutoValue_Product(offer, available_status, product_type, product_name,
                product_id, product_price, product_description,product_quantity);
    }


    static Builder builder() {
        return new AutoValue_Product.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder offer(String offer);

        abstract Builder availableStatus(String available_status);

        abstract Builder productType(String product_type);

        abstract Builder productName(String product_name);

        abstract Builder productId(String product_id);

        abstract Builder productPrice(String product_price);

        abstract Builder productDescription(String product_description);

        abstract Product build();
    }


}