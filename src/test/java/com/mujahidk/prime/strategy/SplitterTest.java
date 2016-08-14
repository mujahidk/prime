package com.mujahidk.prime.strategy;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.mujahidk.prime.util.Pair;

public class SplitterTest {

    @Test
    public void testSplit() {
        Splitter handler = new Splitter(0, 0);
        List<Pair<Integer,Integer>> result = handler.split();
        assertEquals("When there is 0 thread count and 0 limit, nothing to do.", 
                     0, result.size());
        
        Map<Pair<Integer, Integer>, Integer> testData = new HashMap<>();
        testData.put(new Pair<Integer, Integer>(1, 2), 1);
        testData.put(new Pair<Integer, Integer>(50, 2), 2);
        testData.put(new Pair<Integer, Integer>(50, 3), 3);
        testData.put(new Pair<Integer, Integer>(50, 50), 50);
        testData.put(new Pair<Integer, Integer>(50, 100), 1);
        testData.put(new Pair<Integer, Integer>(65, 2), 2);
        
        for (Entry<Pair<Integer, Integer>, Integer> entry : testData.entrySet()) {
            Pair<Integer,Integer> pair = entry.getKey();
            // Create splitter for each test data value.
            handler = new Splitter( pair.getFirst(), pair.getSecond() );
            List<Pair<Integer, Integer>> split = handler.split();
            assertEquals( "Number of start to end pairs for thread range is mismatching.", 
                          entry.getValue().intValue(), 
                          split.size() );
        }
    }
}
