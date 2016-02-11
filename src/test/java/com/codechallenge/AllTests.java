package com.codechallenge;

import com.codechallenge.Tokenizers.SpecialCharacterTokenizer;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test Suite
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FileIndexerTest.class,
        SpecialCharacterTokenizerTest.class
})
public class AllTests {
}
