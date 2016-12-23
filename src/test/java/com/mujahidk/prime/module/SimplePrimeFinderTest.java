package com.mujahidk.prime.module;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimplePrimeFinderTest {

    @Test
    public void testIsPrime() {
        SlowPrimeFinder finder = new SlowPrimeFinder(1, null);
        assertFalse("Negative 1 is not a prime number.", finder.isPrime(-1));
        assertFalse("1 is not a prime number.", finder.isPrime(1));
        assertTrue("2 is a prime number.", finder.isPrime(2));
        assertTrue("7 is a prime number.", finder.isPrime(7));
    }
}
