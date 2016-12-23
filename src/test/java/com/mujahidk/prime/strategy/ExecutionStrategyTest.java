package com.mujahidk.prime.strategy;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExecutionStrategyTest {

    @Test
    public void testGetHandler() {
        // When: There are no arguments.
        String[] args = null;
        ExecutionStrategy strategy = new ExecutionStrategy(args);
        IHandler handler = strategy.getHandler();
        assertEquals("When no arguments are passed in return InvalidConsoleArgumentsHandler.",
                     InvalidConsoleArgumentsHandler.class, handler.getClass());

        // When: Arguments with 0 thread size.
        args = new String[] { "10", "0" };
        strategy = new ExecutionStrategy(args);
        handler = strategy.getHandler();
        assertEquals("When there are arguments, but threads value is 1 or below, use SimpleConsoleHandler.",
                     SimpleConsoleHandler.class, handler.getClass());
        
        // When: Arguments with 2 thread size.
        args = new String[] { "10", "2" };
        strategy = new ExecutionStrategy(args);
        handler = strategy.getHandler();
        assertEquals("When there are arguments, and threads value is above 0 then use MultiThreadConsoleHandler.",
                     MultiThreadConsoleHandler.class, handler.getClass());
    }

}
