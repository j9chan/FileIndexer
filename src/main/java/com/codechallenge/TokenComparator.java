package com.codechallenge;

import java.util.Comparator;
import java.util.Map;

/**
 * Compares entries of strings according to the appearance of the word
 * If a tie exists, the word sorted alphabetically
 */
public class TokenComparator implements Comparator<Map.Entry<String, Integer>> {
    public int compare(Map.Entry<String, Integer> token1, Map.Entry<String, Integer> token2) {
        if (token1.getValue() > token2.getValue()) {
            return 1;
        } else if (token1.getValue() < token2.getValue()) {
            return 0;
        } else {
            return token1.getKey().compareTo(token2.getKey());
        }
    }
}