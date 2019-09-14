package ua.nick.leetcode.easy;

/*
    * 125. Valid Palindrome
    Easy

    Given a string, determine if it is a palindrome, considering only
    alphanumeric characters and ignoring cases.

    Note: For the purpose of this problem, we define empty
    string as valid palindrome.

    Example 1:

    Input: "A man, a plan, a canal: Panama"
    Output: true

    Example 2:

    Input: "race a car"
    Output: false
* */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Pp0"));
    }

    public static boolean isPalindrome(String s) {
        boolean result = true;

        if (s.length() > 1) {
            int limiter = s.length() / 2 + s.length() % 2;
            char[] stringChars = s.toLowerCase().toCharArray();

            top:
            for (int i = 0, j = s.length() - 1; i < limiter; ++i, --j) {

                while (!((stringChars[i] > 47 && stringChars[i] < 58)
                        || (stringChars[i] > 96 && stringChars[i] < 123))) {
                    ++i;
                    if (i >= stringChars.length) {
                        break top;
                    }
                }
                while (!((stringChars[j] > 47 && stringChars[j] < 58)
                        || (stringChars[j] > 96 && stringChars[j] < 123))) {
                    --j;
                    if (j < 0) {
                        break top;
                    }
                }

                if (stringChars[i] != stringChars[j]) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }
}
