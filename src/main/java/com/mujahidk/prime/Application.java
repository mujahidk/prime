package com.mujahidk.prime;

import com.mujahidk.prime.strategy.ExecutionStrategy;
import com.mujahidk.prime.strategy.IHandler;

public class Application {

    public static void main(final String[] args) {
        IHandler handler = new ExecutionStrategy(args).getHandler();
        System.out.println("Strategy: " + handler.getClass().getSimpleName());
        handler.handle();
    }

}
