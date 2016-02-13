package com.codechallenge.Tokenizers;

import java.util.HashMap;

/**
 * Tokenizer Base Class
 */
public abstract class Tokenizer {
    public abstract HashMap<String, Integer> tokenizeAndCount(String[] text);
    public abstract HashMap<String, Integer> tokenizeAndCount(String text);
}
