package com.mujahidk.prime.module;

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
