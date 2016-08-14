package com.mujahidk.prime.strategy;

import com.mujahidk.prime.Arguments;
import com.mujahidk.prime.Parser;

public class ExecutionStrategy {

    private final String[] args;

    public ExecutionStrategy(final String[] args) {
        this.args = args;
    }

    public IHandler getHandler() {
        Arguments arguments = new Parser(args).parse();
        if (!arguments.isValid()) {
            return new InvalidConsoleArgumentsHandler();
        } else if (arguments.getThreads().isPresent() && arguments.getThreads().orElse(0) > 0) {
            return new MultiThreadConsoleHandler(arguments.getLimit(), arguments.getThreads().get());
        }
        return new SimpleConsoleHandler(arguments.getLimit());
    }
}
