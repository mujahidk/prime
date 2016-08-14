package com.mujahidk.prime.module;

import java.util.ArrayList;
import java.util.List;

public class PrimeListCollector
        implements IPrimeCollector {

    private final List<Integer> primes = new ArrayList<>();

    @Override
    public synchronized void collect(final int prime) {
        // Auto boxing
        getPrimes().add(prime);
    }

    @Override
    public int count() {
        return getPrimes().size();
    }

    public List<Integer> getPrimes() {
        return primes;
    }

}
