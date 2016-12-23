package com.mujahidk.prime.strategy;

import com.mujahidk.prime.module.IPrimeCollector;
import com.mujahidk.prime.module.SlowPrimeFinder;

/**
 * Simple application execution strategy. Does not use threading. 
 *
 */
public class SimpleConsoleHandler
        implements IHandler {

    private final int limit;

    public SimpleConsoleHandler(final int limit) {
        this.limit = limit;
    }

    @Override
    public void handle() {
        // Use ConsoleHandler to write prime number to console and keep track of prime number counts.
        IPrimeCollector collector = new ConsoleCollector();
        // Use the finder to find the prime numbers from 1 to given limit.
        new SlowPrimeFinder(limit, collector).find();
        // After finding all, print the prime count.
        System.out.println("Prime numbers found: " + collector.count());
    }

}
