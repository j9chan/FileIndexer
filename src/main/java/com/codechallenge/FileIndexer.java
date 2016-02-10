package com.codechallenge;

import com.codechallenge.Tokenizers.SpecialCharacterTokenizer;

import java.util.*;

/**
 * Contains the main class to run indexers
 */
public class FileIndexer {
    // REGEX used to tokenize string
    private static final Comparator TOKEN_ORDER = new TokenComparator();

    public static void main(String[] args) {

        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();
        HashMap<String, Integer> tokenizedStringCounter = tokenizer.tokenizeAndCount(args);

        // Unlist and sort the pairs
        List<Map.Entry<String, Integer>> tokenizedStringCounterList =
                new ArrayList<Map.Entry<String, Integer>>(tokenizedStringCounter.entrySet());
        Collections.sort(tokenizedStringCounterList, TOKEN_ORDER);

        for(int i = 0; i < 10 && i < tokenizedStringCounterList.size(); i++) {
            System.out.println(String.format("String[%d]: %s, Count: %d",
                    i, tokenizedStringCounterList.get(i).getKey(), tokenizedStringCounterList.get(i).getValue()));
        }
    }
}