package com.fashionqueue.app.data.modals;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue public abstract class Status implements Parcelable{

    public abstract String status();


    static Builder builder() {
        return new AutoValue_Status.Builder();
    }
    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder setStatus(Status status);
        abstract Status build();
    }

}