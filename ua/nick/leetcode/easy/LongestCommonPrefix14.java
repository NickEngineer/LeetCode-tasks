package ua.nick.leetcode.easy;

/*
    14. Longest Common Prefix
    Easy

    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
    Note:

    All given inputs are in lowercase letters a-z.
* */

public class LongestCommonPrefix14 {

    public static void main(String[] args) {
        String[] input = {"dog","racecar","car"};

        System.out.println(longestCommonPrefix(input));
    }

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefixBuilder;
        char[] stringChars;

        if (strs.length != 0) {
            prefixBuilder = new StringBuilder(strs[0].length());

            prefixBuilder.append(strs[0]);

            for (int i = 1; i < strs.length; ++i) {
                if (strs[i].length() < prefixBuilder.length()) {
                    prefixBuilder.delete(strs[i].length(), prefixBuilder.length());
                }
                stringChars = strs[i].toCharArray();

                for (int j = 0; j < prefixBuilder.length(); ++j) {
                    if (prefixBuilder.charAt(j) != stringChars[j]) {
                        prefixBuilder.delete(j, prefixBuilder.length());
                        break;
                    }
                }
            }
        } else {
            prefixBuilder = new StringBuilder(0);
        }

        return prefixBuilder.toString();
    }
}
