package com.mujahidk.prime.module;

/**
 * PrimeCollector interface used by SlowPrimeFinder, whenever it finds a prime collect() method is called.
 * Implementing class should also keep track of collect() call counts. 
 *
 */
public interface IPrimeCollector {
    void collect(final int prime);
    int count();
}
