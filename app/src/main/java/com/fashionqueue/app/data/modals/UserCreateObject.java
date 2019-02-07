package com.fashionqueue.app.data.modals;

public class UserCreateObject {
    private String profile;
    private String orders;
    private String offers;
    private String favorites;

    public UserCreateObject(String profile, String orders, String offers, String favorites) {
        this.profile = profile;
        this.orders = orders;
        this.offers = offers;
        this.favorites = favorites;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getOffers() {
        return offers;
    }

    public void setOffers(String offers) {
        this.offers = offers;
    }

    public String getFavorites() {
        return favorites;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }
}
