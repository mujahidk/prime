package com.mujahidk.prime.strategy;

import com.mujahidk.prime.Arguments;
import com.mujahidk.prime.Parser;

/**
 * Strategy class to decide which handler the application to use based on the arguments passed to it. 
 *
 */
public class ExecutionStrategy {

    private final String[] args;

    public ExecutionStrategy(final String[] args) {
        this.args = args;
    }

    /**
     * Create and return an IHandler instance based on the different argument values.
     * @return IHandler instance based on the argument values.
     */
    public IHandler getHandler() {
        // Parse the arguments.
        Arguments arguments = new Parser(args).parse();
        // If arguments are...
        if (!arguments.isValid()) {
            // ...invalid, then use use InvalidConsoleArgumentsHandler to write help message to console. 
            return new InvalidConsoleArgumentsHandler();
        } else if (arguments.getThreads().isPresent() && arguments.getThreads().get() > 0) {
            // ...valid, and threads argument value is provided or above 0 then use multi-threaded prime finder.
            return new MultiThreadConsoleHandler(arguments.getLimit(), arguments.getThreads().get());
        }
        // ...valid and not multi threaded, use simple console based handler.
        return new SimpleConsoleHandler(arguments.getLimit());
    }
}
