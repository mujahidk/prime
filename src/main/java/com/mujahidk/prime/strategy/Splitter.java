package com.mujahidk.prime.strategy;

import java.util.ArrayList;
import java.util.List;

import com.mujahidk.prime.util.Pair;

/**
 * Helper class to split the prime ranges for threads to process. 
 *
 */
public class Splitter {
    private int limit;
    private int threads;

    /**
     * Create a Splitter instance.
     * @param limit - Prime limit.
     * @param threads - Number of ranges the limit to be split.
     */
    public Splitter(final int limit, final int threads) {
        this.limit = limit;
        this.threads = threads;
    }
    
    public List<Pair<Integer, Integer>> split() {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        // If the limit is 0, return an empty list of pairs. 
        if (limit == 0) {
            return list;
        }
        // Calculate how many slices are required.
        int split = limit/threads;
        // If the slices are less than one, means more threads than limit values...
        if ( split < 1) {
            // ...then make it only one range from 1 to the limit. 
            list.add(new Pair<Integer, Integer>(1, limit));
            return list;
        }
        // Calculate the range for each slice.
        int spill = limit%split; // Calculate the spill/extra ranges. For example 5/2, spill would be 1.
        int end = 0;
        // For each slice...
        for (int t = 0; t < threads; t++) {
            // start with previous end.
            int start = end;
            end = start + split + spill; // Calculate the end by adding start, split and spill.
            // Add the range pair (start, end) to list.
            list.add(new Pair<Integer, Integer>(start + 1, end));
            // Reset the spill, that way one first pair has extra spilled items.
            spill = 0;
        }
        // Return the sliced pair list.
        return list;
    }
}