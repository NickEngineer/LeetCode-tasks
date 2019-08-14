package ua.nick.leetcode.easy;

/*
    * 28. Implement strStr()
    Easy

    Implement strStr().

    Return the index of the first occurrence of needle in haystack,
    or -1 if needle is not part of haystack.

    Example 1:

    Input: haystack = "hello", needle = "ll"
    Output: 2
    Example 2:

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
    Clarification:

    What should we return when needle is an empty string?
    This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string.
    This is consistent to C's strstr() and Java's indexOf().
* */

public class ImplementStrStr28 {

    public static void main(String[] args) {
        System.out.println(strStr("aaa", "aaaa"));
    }

    public static int strStr(String haystack, String needle) {
        int index = -1, pointer, counter = 0;

        if (needle.length() == 0) {
            index = 0;
        } else if (haystack.length() > needle.length() - 1) {
            char[] haystackChars = haystack.toCharArray(),
                    needleChars = needle.toCharArray();

            for (int i = 0; i < haystackChars.length; ++i) {
                pointer = i;

                if (haystackChars.length - i >= needleChars.length) {
                    for (int j = 0; j < needleChars.length && pointer < haystackChars.length; ++j) {
                        if (haystackChars[pointer] != needleChars[j]) {
                            counter = 0;
                            break;
                        }
                        ++pointer;
                        ++counter;
                        if (counter == needleChars.length) {
                            index = i;
                            i = haystackChars.length;
                            break;
                        }
                    }
                    counter = 0;
                } else {
                    break;
                }
            }
        }

        return index;
    }
}
