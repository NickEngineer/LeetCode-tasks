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
        System.out.println(isPalindrome("_A man, a plan, a canal: Panama_"));
    }

    public static boolean isPalindrome(String s) {
        boolean result = false;

        String pattern = "[\\w]+";

        Pattern r = Pattern.compile(pattern);

        Matcher mExp;

        mExp = r.matcher(s);

        StringBuilder filteredString = new StringBuilder();

        while (mExp.find()) {
            filteredString.append(mExp.group().toLowerCase());
        }

        if (filteredString.toString().equals(filteredString.reverse().toString())) {
            result = true;
        }

        return result;
    }
}
