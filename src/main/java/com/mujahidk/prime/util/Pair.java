package com.mujahidk.prime.util;

/**
 * Helper bean to keep pair of two items.
 *
 * @param <T>
 * @param <V>
 */
public class Pair<T,V> {
    private T first;
    private V second;

    public Pair(T first, V second) {
        this.setFirst(first);
        this.setSecond(second);
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }
}
