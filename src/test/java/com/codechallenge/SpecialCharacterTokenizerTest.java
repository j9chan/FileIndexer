package com.codechallenge;

import com.codechallenge.Tokenizers.SpecialCharacterTokenizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Tests SpecialCharacterTokenizer Class
 */
public class SpecialCharacterTokenizerTest {

    @Test
    public void testWhiteSpace() {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();
        Assert.assertTrue(tokenizer.tokenizeAndCount(TestStrings.newline).isEmpty());
        Assert.assertTrue (tokenizer.tokenizeAndCount(TestStrings.space).isEmpty());
        Assert.assertTrue (tokenizer.tokenizeAndCount(TestStrings.tab).isEmpty());
        Assert.assertTrue (tokenizer.tokenizeAndCount(TestStrings.whitespace).isEmpty());
    }

    @Test
    public void testSpecialCharacters() {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();
        Assert.assertTrue (tokenizer.tokenizeAndCount(TestStrings.sc1).isEmpty());
        Assert.assertTrue (tokenizer.tokenizeAndCount(TestStrings.sc2).isEmpty());
        Assert.assertTrue (tokenizer.tokenizeAndCount(TestStrings.sc3).isEmpty());
    }

    @Test
    public void lowerCase() {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();

        HashMap<String, Integer> t1 = tokenizer.tokenizeAndCount(TestStrings.lc1);
        Assert.assertEquals (t1.size(), 1);
        assert (t1.get(TestStrings.lc1) ==  1);

        HashMap<String, Integer> t2 = tokenizer.tokenizeAndCount(TestStrings.lc2);
        assert (t2.size() == 1);
        assert (t2.get(TestStrings.lc2) == 1);
    }

    @Test
    public void upperCase() {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();

        HashMap<String, Integer> t1 = tokenizer.tokenizeAndCount(TestStrings.uc1);
        assert(t1.size() == 1);
        assert(t1.get(TestStrings.uc1.toLowerCase()) == 1);

        HashMap<String, Integer> t2 = tokenizer.tokenizeAndCount(TestStrings.uc2);
        assert (t2.size() == 1);
        assert (t2.get(TestStrings.uc2.toLowerCase()) == 1);
    }

    @Test
    public void numbers() {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();

        HashMap<String, Integer> t1 = tokenizer.tokenizeAndCount(TestStrings.n1);
        assert(t1.size() == 1);
        assert(t1.get(TestStrings.n1) == 1);

        HashMap<String, Integer> t2 = tokenizer.tokenizeAndCount(TestStrings.n2);
        assert (t2.size() == 1);
        assert (t2.get(TestStrings.n2) == 1);
    }

    @Test
    public void combinationValid(){
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();

        HashMap<String, Integer> t1 = tokenizer.tokenizeAndCount(TestStrings.cv1);
        assert(t1.size() == 1);
        assert(t1.get(TestStrings.cv1.toLowerCase()) == 1);

        HashMap<String, Integer> t2 = tokenizer.tokenizeAndCount(TestStrings.cv2);
        assert (t2.size() == 1);
        assert (t2.get(TestStrings.cv2.toLowerCase()) == 1);
    }

    @Test
    public void combinationSpecialAndValid() {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();

        HashMap<String, Integer> t1 = tokenizer.tokenizeAndCount(TestStrings.s1);
        assert(t1.size() == 1);
        assert(t1.get("a") == 6);

        HashMap<String, Integer> t2 = tokenizer.tokenizeAndCount(TestStrings.s2);
        assert (t2.size() == 2);
        assert (t2.get("bye") == 2);
        assert (t2.get("aye") == 2);

        HashMap<String, Integer> t3 = tokenizer.tokenizeAndCount(TestStrings.s3);
        assert(t3.size() == 11);
        assert(t3.get("a") == 1);
        assert(t3.get("b") == 1);
        assert(t3.get("c") == 1);
        assert(t3.get("d") == 1);
        assert(t3.get("e") == 1);
        assert(t3.get("f") == 1);
        assert(t3.get("g") == 1);
        assert(t3.get("h") == 1);
        assert(t3.get("i") == 1);
        assert(t3.get("j") == 1);
        assert(t3.get("k") == 1);
    }

    @Test
    public void combinationSpecialAndValid2() {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();
        HashMap<String, Integer> t1 = tokenizer.tokenizeAndCount(TestStrings.l1);
        assert(t1.size() == 41);
        assert(t1.get("ebooks") == 3);
        assert (t1.get("free") == 3);
        assert (t1.get("them") == 3);
        assert (t1.get("books") == 2);
        assert (t1.get("of") == 2);
        assert (t1.get("we") == 2);
        assert (t1.get("000") == 1);
        assert (t1.get("50") == 1);
        assert (t1.get("all") == 1);
        assert (t1.get("among") == 1);
        assert (t1.get("and") == 1);
        assert (t1.get("bona") == 1);
        assert (t1.get("by") == 1);
        assert (t1.get("carry") == 1);
        assert (t1.get("proofread") == 1);
        assert (t1.get("publishers") == 1);
        assert (t1.get("quality") == 1);
        assert (t1.get("read") == 1);
        assert (t1.get("volunteers") == 1);
        assert (t1.get("were") == 1);
        assert (t1.get("with") == 1);
    }
}
