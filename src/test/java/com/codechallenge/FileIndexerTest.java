package com.codechallenge;

import org.junit.Test;
import org.junit.internal.InexactComparisonCriteria;

import java.util.List;
import java.util.Map;

/**
 * Created by jenniferchan on 2016-02-09.
 */
public class FileIndexerTest {
    @Test
    public void testMain(){
        String[] str = new String[0];

        List<Map.Entry<String, Integer>> test1 = FileIndexer.index(str);
        assert(test1.isEmpty());
    }
}
