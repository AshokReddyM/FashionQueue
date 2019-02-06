package com.fashionqueue.app.data.modals;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class CreateUserModal implements Parcelable {
    public static CreateUserModal create(String profile, String orders, String offers,
                                         String favorites) {
        return new AutoValue_CreateUserModal(profile, orders, offers, favorites);
    }

    static Builder builder() {
        return new AutoValue_CreateUserModal.Builder();
    }

    public abstract String profile();

    public abstract String orders();

    public abstract String offers();

    public abstract String favorites();

    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder offer(String offer);

        abstract Builder profile(String profile);

        abstract Builder orders(String orders);

        abstract Builder favorites(String favorites);


        abstract CreateUserModal build();
    }
}