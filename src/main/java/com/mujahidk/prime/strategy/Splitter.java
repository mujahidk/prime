package com.mujahidk.prime.strategy;

import java.util.ArrayList;
import java.util.List;

import com.mujahidk.prime.util.Pair;

class Splitter {
    private int limit;
    private int threads;

    public Splitter(final int limit, final int threads) {
        this.limit = limit;
        this.threads = threads;
    }
    
    public List<Pair<Integer, Integer>> split() {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        if (limit == 0) {
            return list;
        }
        
        int split = limit/threads;
        if ( split < 1) {
            list.add(new Pair<Integer, Integer>(1, limit));
            return list;
        }
        int spill = limit%split;
        int end = 0;
        for (int t = 0; t < threads; t++) {
            int start = end;
            end = start + split + spill;
            list.add(new Pair<Integer, Integer>(start + 1, end));
            spill = 0;
        }
        
        return list;
    }
}