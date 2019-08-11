package ua.nick.leetcode.easy;

/*
    58. Length of Last Word
    Easy

    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

    If the last word does not exist, return 0.

    Note: A word is defined as a character sequence consists of non-space characters only.

    Example:

    Input: "Hello World"
    Output: 5
* */

public class LengthOfALastWord58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World "));
    }

    public static int lengthOfLastWord(String s) {
        int wordLength = 0;

        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ') {
                if (wordLength == 0) {
                    continue;
                }
                break;
            } else {
                ++wordLength;
            }
        }

        return wordLength;
    }
}
