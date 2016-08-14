package com.mujahidk.prime.strategy;

import java.util.ArrayList;
import java.util.List;

import com.mujahidk.prime.module.IPrimeCollector;
import com.mujahidk.prime.module.SlowPrimeFinder;
import com.mujahidk.prime.util.Pair;

/**
 * When application is asked to use multiple threads, MultiThreadConsoleHandler strategy is used to handle the execution.  
 *
 */
public class MultiThreadConsoleHandler
        implements IHandler {

    private final int limit;
    private final int threads;

    public MultiThreadConsoleHandler(final int limit, final int threads) {
        this.limit = limit;
        // If thread count is 0 or less, reset it to 1.
        this.threads = threads <= 0 ? 1 : threads;
    }

    @Override
    public void handle() {
        // Use ConsoleHandler to write prime number to console and keep track of prime number counts.
        IPrimeCollector collector = new ConsoleCollector();
        // Based on the number of threads requested, split the prime lookup range for each thread.
        List<Pair<Integer,Integer>> slices = new Splitter(limit, threads).split();
        // For each lookup range, one SlowPrimeFinder thread is created.
        List<SlowPrimeFinder> threads = new ArrayList<>(slices.size());
        // Use ** java 8 ** lambda expression for each range...
        slices.forEach(range -> {
            // ... create new finder thread.
            SlowPrimeFinder worker = new SlowPrimeFinder(range.getFirst(), range.getSecond(), collector);
            // Add the newly created instance to the list.
            threads.add(worker);
            // Start the new finder thread.
            worker.start();
        });

        // When all the threads are created and started. 
        for (SlowPrimeFinder worker : threads) {
            try {
                // Main thread to wait for the worker thread to die.
                worker.join();
            } catch (InterruptedException e) {
                // If there is an exception, write message to error console and stack trace, then continue.
                System.err.println("Having difficulty joining the main thread.");
                e.printStackTrace();
            }
        }
        // When all threads die, print the count of prime numbers collected by collector.
        System.out.println("Total collected primes: " + collector.count());
    }
}
