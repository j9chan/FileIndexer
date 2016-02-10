package com.codechallenge.Tokenizers;

import java.util.HashMap;

/**
 * Tokenizer that delimits strings by any character other than a-z, A-Z, or 0-9.
 */
public class SpecialCharacterTokenizer extends Tokenizer {
    // Tokenize strings according to regex
    private static final String TOKENIZER_REGEX = "[^a-zA-Z0-9]";

    /**
     * Reads in an array of text and tokenizes the
     * @param text
     * @return
     */
    @Override
    public HashMap<String, Integer> tokenizeAndCount(String[] text) {
        HashMap<String, Integer> tokenizedStringCounter = new HashMap<String, Integer>();

        for (String str : text) {
            String[] tokens = str.split(TOKENIZER_REGEX);
            for (String token : tokens) {
                token = token.toLowerCase();
                Integer searchResult = tokenizedStringCounter.get(token);
                int updatedTokenCount = 1;
                if (searchResult != null) {
                    updatedTokenCount = searchResult + 1;
                }
                tokenizedStringCounter.put(token, updatedTokenCount);
            }
        }
        return tokenizedStringCounter;
    }
}
