package com.codechallenge.Tokenizers;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Tokenizer that delimits strings by any character other than a-z, A-Z, or 0-9.
 */
public class SpecialCharacterTokenizer extends Tokenizer {
    // REGEX used to tokenize string
    private static final String TOKENIZER_REGEX = "[^a-zA-Z0-9]";
    private static final String WHITESPACE_REGEX = "\\s+";

    /**
     * Reads in an array of text and tokenizes and counts unique words
     * @param text
     * @return map of the unique strings in lowercase with the number of times they appeared
     */
    @Override
    public HashMap<String, Integer> tokenizeAndCount(String[] text) {
        HashMap<String, Integer> tokenizedStringCounter = new HashMap<String, Integer>();
        for (String str : text) {
            String[] tokens = str.split(WHITESPACE_REGEX);
            for (String token : tokens) {
                if (!token.isEmpty()) {
                    token = readStringFromFile(token);
                    tokenizeAndCount(token, tokenizedStringCounter, TOKENIZER_REGEX);
                }
            }
        }
        return tokenizedStringCounter;
    }

    /**
     *  Tokenizes according to specified regex
     * @param str Array of text to be tokenized
     * @param tokenizedStringCounter Map of unique words and their count
     * @return Map of unique words in all files and strings and their count
     */
    private void tokenizeAndCount(String str, HashMap<String, Integer> tokenizedStringCounter, String regex) {
        String[] tokens = str.split(regex);
        for (String token : tokens) {
            if (!token.isEmpty()) {
                Integer searchResult = tokenizedStringCounter.get(token.toLowerCase());
                int updatedTokenCount = (searchResult == null) ? 1 : searchResult + 1;
                tokenizedStringCounter.put(token.toLowerCase(), updatedTokenCount);
            }
        }
    }

    /**
     * Read in a string and return map of unqiue words and count
     * @param text
     * @return map of unique words and count
     */
    public HashMap<String, Integer> tokenizeAndCount(String text) {
        String[] text1 = {text};
        return tokenizeAndCount(text1);
    }

    /**
     * Determines if str is a file, if so, reads in the file and returns. Otherwise returns str.
     * @param str
     * @return Contents of str, is str is a file, otherwise returns str
     */
    public String readStringFromFile(String str) {
        String retStr = str;
        File file = new File(str);
        if (str.matches("(.*)\\.(.*)") && file.exists() && !file.isDirectory() && file.canRead()) {
            try {
                byte[] encoded = Files.readAllBytes(Paths.get(str));
                return new String(encoded, Charset.defaultCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return retStr;
    }
}
