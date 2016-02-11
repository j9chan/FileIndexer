package com.codechallenge;

/**
 * Strings to test
 */
public class TestStrings {
    // Whitespace
    public static String newline = "\n";
    public static String space = " ";
    public static String tab = "    ";
    public static String whitespace = "\n\t\r\f\b";

    // Special Characters
    public static String sc1 = "#";
    public static String sc2 = "@%";
    public static String sc3 = "!@#$%^&*()";

    // Lower Case
    public static String lc1 = "a";
    public static String lc2 = "az";

    // Upper Case
    public static String uc1 = "A";
    public static String uc2 = "AZ";

    // Numbers
    public static String n1 = "0";
    public static String n2 = "29412398";

    // Combination of valid strings
    public static String cv1 = lc1 + uc1 + n1;
    public static String cv2 = lc2 + n2 + lc1 + uc2;

    // Combination of valid with Special characters
    // Small tests
    public static String s1 = "a a$ a\n a     a#a*";
    public static String s2 = "bye bye aye aye";
    public static String s3 = "a b c d e f g h i j k";
    public static String s4 = "k i a d e f g b c h j";

    // Long tests
    public static String l1 = "Project Gutenberg offers over 50,000 free ebooks: choose among free epub books, free kindle books, download them or read them online.\n We carry high quality ebooks: All our ebooks were previously published by bona fide publishers. We digitized and diligently proofread them with the help of thousands of volunteers.";
}
