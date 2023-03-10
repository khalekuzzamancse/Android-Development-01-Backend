package com.example.work_manger;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FindPrimes extends Worker {
    private PrimeApp app;
    private PrimeDataSource dataSource;
    private long current;
    private final long max;


    public FindPrimes(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        app = (PrimeApp) context;
        dataSource = app.getPrimeDataSource();
        current = dataSource.getCurrentLiveData().getValue();
        max = dataSource.getMaxLiveData().getValue();
    }

    @NonNull
    @Override
    public Result doWork() {
        dataSource.setIsRunning(true);
        while (current <= max && !isStopped()) {
            if (isPrime(current)) {
                dataSource.addPrime(current);
                Log.i("CurrentPrime:", String.valueOf(current));
            }

            current++;
        }
        dataSource.setIsRunning(false);
        if (current > max) {
            return Result.success();
        } else {
            return Result.failure();
        }

    }

    private boolean isPrime(long current) {
        for (int i = 2; i < current; i++) {
            if (current % i == 0)
                return false;
        }
        return true;
    }
}
