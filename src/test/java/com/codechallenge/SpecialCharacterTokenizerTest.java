package com.codechallenge;

import com.codechallenge.Tokenizers.SpecialCharacterTokenizer;
import org.junit.Test;

import java.util.HashMap;

/**
 * Tests SpecialCharacterTokenizer Class
 */
public class SpecialCharacterTokenizerTest {

    @Test
    public void testWhiteSpace() {

        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();

        assert (tokenizer.tokenizeAndCount(TestStrings.newline).isEmpty());

        assert (tokenizer.tokenizeAndCount(TestStrings.space).isEmpty());

        assert (tokenizer.tokenizeAndCount(TestStrings.tab).isEmpty());

        assert (tokenizer.tokenizeAndCount(TestStrings.whitespace).isEmpty());
    }

    @Test
    public void testSpecialCharacters() {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();

        assert (tokenizer.tokenizeAndCount(TestStrings.sc1).isEmpty());

        assert (tokenizer.tokenizeAndCount(TestStrings.sc2).isEmpty());

        assert (tokenizer.tokenizeAndCount(TestStrings.sc3).isEmpty());
    }

    @Test
    public void lowerCase() {

    }

    @Test
    public void upperCase() {

    }

    @Test

    public void numbers() {

    }

    @Test
    public void combinationValid(){

    }

    @Test
    public void combinationSpecialAndValid() {

    }
}
