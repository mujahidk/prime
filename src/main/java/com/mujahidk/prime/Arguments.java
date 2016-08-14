package com.mujahidk.prime;

import java.util.Optional;

public class Arguments {

    private final Integer limit;
    private final Optional<Integer> threads;
    private final boolean valid;

    public Arguments(final Integer limit, final Optional<Integer> threads, final boolean valid) {
        this.limit = limit;
        this.threads = threads;
        this.valid = valid;
    }

    public Integer getLimit() {
        return limit;
    }

    public Optional<Integer> getThreads() {
        return threads;
    }

    public boolean isValid() {
        return valid;
    }

}