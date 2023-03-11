package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        createNotificationChannels();
        finishNotification(this);
    }

    private void finishNotification(Context context) {
        //buiding the pending inent
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        @SuppressLint("UnspecifiedImmutableFlag") PendingIntent contentIntent =
                PendingIntent.getActivity(context,
                        100,
                        intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
        //build notification
        Notification notification =
                new NotificationCompat.
                        Builder(context, "channel-1")
                        .setContentTitle("this is title")
                        .setContentText("finished")
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(contentIntent)
                        .setAutoCancel(true)
                        .build();
        //show notification
        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(1, notification);


    }

    private void createNotificationChannels() {
        NotificationChannel channel =
                new NotificationChannel("channel-1",
                        "testChannel",
                        NotificationManager.IMPORTANCE_DEFAULT
                );
        channel.setDescription("this test notification");
        NotificationManager manager =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
    }
}