package com.codechallenge;

import com.codechallenge.Tokenizers.SpecialCharacterTokenizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class FileIndexerTest {
    @Test
    public void testIndex1(){
        String[] str = new String[0];
        List<Map.Entry<String, Integer>> test1 = FileIndexer.index(str, new SpecialCharacterTokenizer());
        assert(test1.isEmpty());
    }

    @Test
    public void testIndex2(){
        String[] ts1 = {TestStrings.s4};
        List<Map.Entry<String, Integer>> t1 = FileIndexer.index(ts1, new SpecialCharacterTokenizer());
        assert (t1.size() == 11);
        Assert.assertEquals(t1.get(0).getKey(), "a");
        assert(t1.get(0).getValue() == 1);
        Assert.assertEquals (t1.get(1).getKey(), "b");
        assert (t1.get(1).getValue() == 1);
        Assert.assertEquals(t1.get(2).getKey(), "c");
        assert (t1.get(2).getValue() == 1);
        Assert.assertEquals (t1.get(3).getKey(), "d");
        assert (t1.get(3).getValue() == 1);
        Assert.assertEquals (t1.get(4).getKey(), "e");
        assert (t1.get(4).getValue() == 1);
        Assert.assertEquals (t1.get(5).getKey(), "f");
        assert (t1.get(5).getValue() == 1);
        Assert.assertEquals (t1.get(6).getKey(), "g");
        assert (t1.get(6).getValue() == 1);
        Assert.assertEquals (t1.get(7).getKey(), "h");
        assert (t1.get(7).getValue() == 1);
        Assert.assertEquals (t1.get(8).getKey(), "i");
        assert (t1.get(8).getValue() == 1);
        Assert.assertEquals (t1.get(9).getKey(), "j");
        assert (t1.get(9).getValue() == 1);
        Assert.assertEquals (t1.get(10).getKey(), "k");
        assert (t1.get(10).getValue() == 1);
    }

    @Test
    public void testIndex4() {
        String[] ts1 = {TestStrings.l1};
        List<Map.Entry<String, Integer>> t1 = FileIndexer.index(ts1, new SpecialCharacterTokenizer());
        assert(t1.size() == 41);
        Assert.assertEquals(t1.get(0).getKey(), "ebooks");
        assert(t1.get(0).getValue() == 3);
        Assert.assertEquals (t1.get(1).getKey(), "free");
        assert (t1.get(1).getValue() == 3);
        Assert.assertEquals(t1.get(2).getKey(), "them");
        assert (t1.get(2).getValue() == 3);
        Assert.assertEquals (t1.get(3).getKey(), "books");
        assert (t1.get(3).getValue() == 2);
        Assert.assertEquals (t1.get(4).getKey(), "of");
        assert (t1.get(4).getValue() == 2);
        Assert.assertEquals (t1.get(5).getKey(), "we");
        assert (t1.get(5).getValue() == 2);
        Assert.assertEquals (t1.get(6).getKey(), "000");
        assert (t1.get(6).getValue() == 1);
        Assert.assertEquals (t1.get(7).getKey(), "50");
        assert (t1.get(7).getValue() == 1);
        Assert.assertEquals (t1.get(39).getKey(), "were");
        assert (t1.get(39).getValue() == 1);
        Assert.assertEquals (t1.get(40).getKey(), "with");
        assert (t1.get(40).getValue() == 1);
    }
}
