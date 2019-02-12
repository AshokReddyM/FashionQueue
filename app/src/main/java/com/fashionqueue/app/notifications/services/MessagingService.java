package com.fashionqueue.app.notifications.services;

import android.app.Notification;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.fashionqueue.app.R;
import com.fashionqueue.app.data.local.DatabaseHelper;
import com.fashionqueue.app.data.modals.Notifications;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MessagingService extends FirebaseMessagingService {

    public static final String TAG = "MsgFirebaseServ";
    private DatabaseHelper db;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);


        if (remoteMessage.getData() != null) {
            String title = remoteMessage.getData().get("title");
            String body = remoteMessage.getData().get("body");
            String objectId = remoteMessage.getData().get("object_id");
            String objectType = remoteMessage.getData().get("objectType");

            Notification notification = new NotificationCompat.Builder(this)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(R.drawable.ic_notifications)
                    .build();
            NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
            manager.notify(/*notification id*/0, notification);

            saveNotification(objectId,title,body);

        }

    }


    /**
     * Inserting new note in db
     * and refreshing the list
     */
    private void saveNotification(String notificationsId, String title, String description) {
        // inserting note in db and getting
        // newly inserted note id
        db = new DatabaseHelper(this);

        long id = db.insertNotification(title,description);

        // get the newly inserted note from db
        Notifications n = db.getNote(id);

    }

}
