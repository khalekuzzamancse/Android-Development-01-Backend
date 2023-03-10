package com.example.work_manger;

import android.app.Application;

import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class PrimeApp extends Application {
    public  static final String JOB_NAME="findPrimes";
    @Override
    public void onCreate() {
        super.onCreate();
        WorkManager workManager=WorkManager.getInstance(this);
        OneTimeWorkRequest oneTimeWorkRequest;
        Constraints c=
                new Constraints.Builder()
                        .setRequiresBatteryNotLow(true)
                        .build();
        oneTimeWorkRequest=
                new OneTimeWorkRequest.Builder(FindPrimes.class)
                        .setConstraints(c)
                        .setInitialDelay(1, TimeUnit.SECONDS)
                        .build();
        workManager.enqueueUniqueWork(JOB_NAME, ExistingWorkPolicy.REPLACE,oneTimeWorkRequest);

    }
}
