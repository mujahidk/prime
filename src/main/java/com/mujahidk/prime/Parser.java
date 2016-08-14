package com.mujahidk.prime;

import java.util.Optional;

public class Parser {

    private final String[] args;

    public Parser(final String[] args) {
        this.args = args;
    }

    public Arguments parse() {
        if (args == null || args.length == 0) {
            return empty();
        } else {
            Integer limit;
            Optional<Integer> threads = Optional.empty();

            try {
                int parseInt = Integer.parseInt(args[0]);
                limit = parseInt;
            } catch (NumberFormatException e) {
                return empty();
            }

            if (args.length > 1) {
                try {
                    int parseInt = Integer.parseInt(args[1]);
                    threads = Optional.of(parseInt);
                } catch (NumberFormatException e) {
                    return empty();
                }
            }
            return new Arguments(limit, threads, true);
        }
    }

    private Arguments empty() {
        return new Arguments(null, null, false);
    }

}