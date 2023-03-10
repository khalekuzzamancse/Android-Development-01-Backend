package com.example.work_manger;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class PrimeDataSource {
    private MutableLiveData<Boolean>isRunning;
    private List<Long> primes;
    private MutableLiveData<Long> currentLiveData;
    private MutableLiveData<Long> maxLiveData;
    private MutableLiveData<List<Long>> primesLiveData;

    public PrimeDataSource() {
        currentLiveData = new MutableLiveData<>(2L);
        maxLiveData = new MutableLiveData<>(1_000_000L);
        primes = new ArrayList<>();
        primesLiveData = new MutableLiveData<>(primes);
        isRunning=new MutableLiveData<>(false);

    }

    public LiveData<Long> getCurrentLiveData() {
        return currentLiveData;
    }

    public LiveData<Boolean> getIsRunning()
    {
        return isRunning;
    }

    public void setIsRunning(boolean running) {
      this.isRunning.postValue(running);
    }

    public LiveData<Long> getMaxLiveData() {
        return maxLiveData;
    }

    public LiveData<List<Long>> getPrimesLiveData() {
        return primesLiveData;
    }

    public void addPrime(Long prime) {
        this.primes.add(prime);
        this.currentLiveData.postValue(prime);
        this.primesLiveData.postValue(primes);
    }

}
