package com.mujahidk.prime;

import java.util.Optional;

/**
 * Application aware arguments parser. Processes the arguments and prepares Arguments instance. 
 *
 */
public class Parser {

    private final String[] args;
    private final Integer ZERO = Integer.valueOf(0);

    public Parser(final String[] args) {
        this.args = args;
    }

    public Arguments parse() {
        // If there are no arguments...
        if (args == null || args.length == 0) {
            //...then return an Arguments instance with invalid flag set.
            return empty();
        } else {
            Integer limit;
            Optional<Integer> threads = Optional.empty();
            // Is there a limit value is specified in arguments...
            try {
                int parseInt = Integer.parseInt(args[0]);
                // ...then set the value to limit argument value.
                limit = parseInt;
            } catch (NumberFormatException e) {
                // ...value format is invalid return Arguments instance with invalid flag set.
                return empty();
            }
            // Is there a threads size specified...
            if (args.length > 1 && args[1] != null) {
                try {
                    int parseInt = Integer.parseInt(args[1]);
                    // ...then set the value to threads argument value.
                    threads = Optional.of(parseInt);
                } catch (NumberFormatException e) {
                    // ...value format is invalid return Arguments instance with invalid flag set.
                    return empty();
                }
            }
            // No errors were found, return a new instance of arguments with valid flag set.
            return new Arguments(limit, threads, true);
        }
    }

    /**
     * Creates an Arguments instance with null argument values and invalid flag.
     * @return Arguments instance.
     */
    private Arguments empty() {
        return new Arguments(ZERO, Optional.empty(), false);
    }

}