package com.codechallenge.Tokenizers;

import java.util.HashMap;

/**
 * Tokenizer that delimits strings by any character other than a-z, A-Z, or 0-9.
 */
public class SpecialCharacterTokenizer extends Tokenizer {
    // REGEX used to tokenize string
    private static final String TOKENIZER_REGEX = "[^a-zA-Z0-9]";

    /**
     * Reads in an array of text and tokenizes and counts unique words
     * @param text
     * @return map of the unique strings in lowercase with the number of times they appeared
     */
    @Override
    public HashMap<String, Integer> tokenizeAndCount(String[] text) {
        HashMap<String, Integer> tokenizedStringCounter = new HashMap<String, Integer>();

        for (String str : text) {
            String[] tokens = str.split(TOKENIZER_REGEX);
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    Integer searchResult = tokenizedStringCounter.get(token.toLowerCase());
                    int updatedTokenCount = (searchResult == null) ? 1 : searchResult + 1;
                    tokenizedStringCounter.put(token.toLowerCase(), updatedTokenCount);
                }
            }
        }
        return tokenizedStringCounter;
    }

    public HashMap<String, Integer> tokenizeAndCount(String text) {
        String[] text1 = {text};
        return tokenizeAndCount(text1);
    }
}
