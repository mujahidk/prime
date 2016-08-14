package com.mujahidk.prime.strategy;

import java.util.List;

import com.mujahidk.prime.module.IPrimeCollector;
import com.mujahidk.prime.module.PrimeListCollector;
import com.mujahidk.prime.module.SlowPrimeFinder;
import com.mujahidk.prime.util.Pair;

public class MultiThreadConsoleHandler
        implements IHandler {

    private final int limit;
    private final int threads;

    public MultiThreadConsoleHandler(final int limit, final int threads) {
        this.limit = limit;
        // If thread count is 0, reset it to 1.
        this.threads = threads <= 0 ? 1 : threads;
    }

    @Override
    public void handle() {
        IPrimeCollector collector = new PrimeListCollector();

        List<Pair<Integer,Integer>> slices = new Splitter(limit, threads).split();
        
        slices.forEach(range -> {
            SlowPrimeFinder worker = new SlowPrimeFinder(range.getFirst(), range.getSecond(), collector);
            write("Starting new thread for range [%s - %s].", range.getFirst(), range.getSecond());
            startThreadAndJoin(worker);
        });

        for (Integer prime : ((PrimeListCollector) collector).getPrimes()) {
            write("%s", prime);
        }

        write("Total collected primes: %s", collector.count());
    }

    private void startThreadAndJoin(Thread worker) {
        worker.start();
        try {
            worker.join();
        } catch (InterruptedException e) {
            System.err.println("Having difficulty joining the main thread.");
            e.printStackTrace();
        }
    }
    
    private void write(String message, Object...args) {
        System.out.println( String.format(message, args));
    }
}
