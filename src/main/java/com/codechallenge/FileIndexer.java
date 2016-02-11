package com.codechallenge;

import com.codechallenge.Tokenizers.SpecialCharacterTokenizer;

import java.util.*;

/**
 * Contains the main class to run indexers
 */
public class FileIndexer {
    private static final Comparator TOKEN_ORDER = new TokenComparator();

    public static List<Map.Entry<String, Integer>> index(String[] text) {
        SpecialCharacterTokenizer tokenizer = new SpecialCharacterTokenizer();
        HashMap<String, Integer> tokenizedStringCounter = tokenizer.tokenizeAndCount(text);

        // Unlist and sort the pairs
        List<Map.Entry<String, Integer>> tokenizedStringCounterList =
                new ArrayList<Map.Entry<String, Integer>>(tokenizedStringCounter.entrySet());
        Collections.sort(tokenizedStringCounterList, TOKEN_ORDER);

        return tokenizedStringCounterList;
    }

    public static void main(String[] args) {
        List<Map.Entry<String, Integer>> tokenizedStringCounterList = index(args);

        for(int i = 0; i < 10 && i < tokenizedStringCounterList.size(); i++) {
            System.out.println(String.format("%d %s",
                    tokenizedStringCounterList.get(i).getValue(), tokenizedStringCounterList.get(i).getKey()));
        }
    }
}