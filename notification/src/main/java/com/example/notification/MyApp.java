package com.example.notification;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;

import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class MyApp extends Application {
    public static final String JOB_NAME = "notify";
    WorkManager workManager;

    @Override
    public void onCreate() {
        super.onCreate();
        workManager = WorkManager.getInstance(this);
        createWorker();
       // createNotificationChannels();
    }



    private void createWorker() {

        OneTimeWorkRequest oneTimeWorkRequest;
        Constraints c =
                new Constraints.Builder()
                        .setRequiresBatteryNotLow(true)
                        .build();
        oneTimeWorkRequest =
                new OneTimeWorkRequest.Builder(NotifyWorker.class)
                        .setConstraints(c)
                        .setInitialDelay(1, TimeUnit.SECONDS)
                        .build();
        workManager.enqueueUniqueWork(JOB_NAME, ExistingWorkPolicy.REPLACE, oneTimeWorkRequest);
    }

}
