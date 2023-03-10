package com.example.work_manger;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class PrimeDataSource {
    private List<Long> primes;
    private MutableLiveData<Long> currentLiveData;
    private MutableLiveData<Long> maxLiveData;
    private MutableLiveData<List<Long>> primesLiveData;

    public PrimeDataSource() {
        currentLiveData = new MutableLiveData<>(2L);
        maxLiveData = new MutableLiveData<>(1_000_000L);
        primes = new ArrayList<>();
        primesLiveData = new MutableLiveData<>(primes);

    }

    public LiveData<Long> getCurrentLiveData() {
        return currentLiveData;
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
