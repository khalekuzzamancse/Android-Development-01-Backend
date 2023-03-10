package com.example.work_manger;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class FindPrimes extends Worker {
    private long current;
    private final long max;


    public FindPrimes(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        current = 2;
        max = 1_000_000;
    }

    @NonNull
    @Override
    public Result doWork() {
        while (current <= max && !isStopped()) {
            if (isPrime(current)) {
                Log.i("CurrentPrime:", String.valueOf(current));
            }

            current++;
        }
        if (current > max)
            return Result.success();
        else
            return Result.failure();
    }

    private boolean isPrime(long current) {
        for (int i = 2; i < current; i++) {
            if (current % i == 0)
                return false;
        }
        return true;
    }
}
