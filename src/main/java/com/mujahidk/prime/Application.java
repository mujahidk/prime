package com.mujahidk.prime;

import com.mujahidk.prime.strategy.ExecutionStrategy;
import com.mujahidk.prime.strategy.IHandler;

/**
 * Application entry point. Accepts two arguments for range end and number of threads. 
 *
 */
public class Application {

    public static void main(final String[] args) {
        // Using the arguments get the handler for running the application.
        IHandler handler = new ExecutionStrategy(args).getHandler();
        // Print the handler name for reference.
        System.out.println("Strategy: " + handler.getClass().getSimpleName());
        // Invoke the execution strategy.
        handler.handle();
    }

}
