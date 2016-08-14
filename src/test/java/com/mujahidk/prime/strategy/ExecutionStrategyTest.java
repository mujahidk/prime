package com.mujahidk.prime.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExecutionStrategyTest {

    @Test
    public void testGetHandler() {
        String[] args = null;
        ExecutionStrategy strategy = new ExecutionStrategy(args);
        IHandler handler = strategy.getHandler();
        assertEquals("When no arguments are passed in return InvalidConsoleArgumentsHandler.",
                     InvalidConsoleArgumentsHandler.class,
                     handler.getClass());

        // When: Arguments with 0 thread size.
        args = new String[] { "0", "0" };
        strategy = new ExecutionStrategy(args);
        handler = strategy.getHandler();
        assertEquals("When there are arguments, but threads are 1 or below, use SimpleConsoleHandler.",
                     SimpleConsoleHandler.class,
                     handler.getClass());
    }

}
