package com.mujahidk.prime.module;

public class SlowPrimeFinder
        extends Thread {
    private final int end;
    private final IPrimeCollector collector;
    private final int start;

    public SlowPrimeFinder(final int till, final IPrimeCollector collector) {
        this(1, till, collector);
    }

    public SlowPrimeFinder(final int start, final int end, final IPrimeCollector collector) {
        this.start = start;
        this.end = end;
        this.collector = collector;
    }

    @Override
    public void run() {
        this.find();
    }

    public void find() {
        for (int number = start; number <= this.end; number++) {
            // Check if the number is prime...
            if (isPrime(number)) {
                // ...is so then call the collector.
                collector.collect(number);
            }
        }
    }

    private boolean isPrime(final int number) {
        if (number <= 1)
            return false;
        if (number <= 3)
            return true;
        if (number % 2 == 0 || number % 3 == 0)
            return false;
        int i = 5;
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0){
                return false;
            }
            i++;
        }
        return true;
    }
}
