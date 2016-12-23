package com.mujahidk.prime.strategy;

import com.mujahidk.prime.module.IPrimeCollector;

/**
 * Implements IPrimeCollector to print prime numbers on console, collect() method is synchronized to make sure
 * count value is accurate in multi-thread environment.
 *
 */
public class ConsoleCollector
        implements IPrimeCollector {
    private int count = 0;

    @Override
    public synchronized void collect(final int prime) {
        System.out.println(prime);
        count++;
    }

    public int count() {
        return count;
    }
}
