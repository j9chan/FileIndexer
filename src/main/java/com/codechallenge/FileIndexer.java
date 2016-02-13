package com.codechallenge;

import com.codechallenge.Tokenizers.SpecialCharacterTokenizer;
import com.codechallenge.Tokenizers.Tokenizer;

import java.util.*;

/**
 * Contains the main class to run indexers
 */
public class FileIndexer {

    /**
     * Reads in an array of strings
     * Tokenizes the strings
     * Reads in contents of files if file names occur in the string
     * Tokenizes all strings according to some regex
     * Returns sorted list of all uniquely occuring strings
     * @param text Array of strings to tokenize
     * @param tokenizer Tokenizes the strings
     * @return Sorted list of pairs of uniquely occurring strings and their count
     */
    public static List<Map.Entry<String, Integer>> index(String[] text, Tokenizer tokenizer) {
        final Comparator tokenComparator = new TokenComparator();
        HashMap<String, Integer> tokenizedStringCounter = tokenizer.tokenizeAndCount(text);

        // Unlist and sort the pairs
        List<Map.Entry<String, Integer>> tokenizedStringCounterList =
                new ArrayList<Map.Entry<String, Integer>>(tokenizedStringCounter.entrySet());
        Collections.sort(tokenizedStringCounterList, tokenComparator);

        return tokenizedStringCounterList;
    }

    public static void main(String[] args) {
        List<Map.Entry<String, Integer>> tokenizedStringCounterList = index(args, new SpecialCharacterTokenizer());

        for(int i = 0; i < 10 && i < tokenizedStringCounterList.size(); i++) {
            System.out.println(String.format("%d %s",
                    tokenizedStringCounterList.get(i).getValue(), tokenizedStringCounterList.get(i).getKey()));
        }
    }
}