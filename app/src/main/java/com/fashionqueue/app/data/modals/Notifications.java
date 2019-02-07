package com.fashionqueue.app.data.modals;

public class Notifications {
    private String notification_id;
    private String notification_title;
    private String notification_details;

    public Notifications(String notification_id, String notification_title, String notification_details) {
        this.notification_id = notification_id;
        this.notification_title = notification_title;
        this.notification_details = notification_details;
    }

    public String getNotification_id() {
        return notification_id;
    }

    public void setNotification_id(String notification_id) {
        this.notification_id = notification_id;
    }

    public String getNotification_title() {
        return notification_title;
    }

    public void setNotification_title(String notification_title) {
        this.notification_title = notification_title;
    }

    public String getNotification_details() {
        return notification_details;
    }

    public void setNotification_details(String notification_details) {
        this.notification_details = notification_details;
    }
}
