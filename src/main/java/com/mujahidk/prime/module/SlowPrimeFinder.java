package com.mujahidk.prime.module;

import java.util.stream.IntStream;

/**
 * Find the prime numbers for given range of values.
 *
 */
public class SlowPrimeFinder
        extends Thread {
    private final int end;
    private final IPrimeCollector collector;
    private final int start;

    /**
     * Create an instance of prime number finder from 1 to end.
     * @param end - value to search till for prime numbers.
     * @param collector - collector.collect() is called when a prime number is found.
     */
    public SlowPrimeFinder(final int end, final IPrimeCollector collector) {
        this(1, end, collector);
    }

    /**
     * Create an instance of prime number finder from start to end.
     * @param start - start number to look for primes.
     * @param end - value to search till for prime numbers.
     * @param collector - collector.collect() is called when a prime number is found.
     */
    public SlowPrimeFinder(final int start, final int end, final IPrimeCollector collector) {
        this.start = start;
        this.end = end;
        this.collector = collector;
    }

    /**
     * Thread.run() to invoke find().
     */
    @Override
    public void run() {
        // Call the find() when run through the thread.
        this.find();
    }

    /**
     * Start looking for prime numbers in the given range.
     */
    public void find() {
        // ** java 8 ** streams, lambda uses.
        IntStream.rangeClosed(this.start, this.end)
//                .parallel() // Uncomment if parallel processing is required.
                .filter(number -> isPrime(number)) // Check if the number is prime.
//                .sorted() // Uncomment of parallel processed sorted result is required.
                .forEach(number -> collector.collect(number) ); // Call the collector for all numbers.
    }

    /**
     * Test to check if the given number is prime or not.
     * @param number
     * @return true if prime, else false.
     */
    // @VisibleForTesting
    protected boolean isPrime(final int number) {
        if (number <= 1) // 1 or below is not a prime number.
            return false;
        if (number <= 3) // 2 & 3 are prime numbers.
            return true;
        if (number % 2 == 0 || number % 3 == 0) // If a number is divisible by 2 or 3 then it is not prime.
            return false;
        int i = 5; // For numbers 5 and above compare using the square.
        while (i * i <= number) {
            if (number % i == 0 || number % (i + 2) == 0){
                return false;
            }
            i++;
        }
        return true;
    }
}
