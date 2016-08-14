package com.mujahidk.prime.strategy;

import com.mujahidk.prime.module.ConsoleCollector;
import com.mujahidk.prime.module.IPrimeCollector;
import com.mujahidk.prime.module.SlowPrimeFinder;

public class SimpleConsoleHandler
        implements IHandler {

    private final int limit;

    public SimpleConsoleHandler(final int limit) {
        this.limit = limit;
    }

    @Override
    public void handle() {
        IPrimeCollector collector = new ConsoleCollector();
        new SlowPrimeFinder(limit, collector).find();
        System.out.println("Primes Found: " + collector.count());
    }

}
