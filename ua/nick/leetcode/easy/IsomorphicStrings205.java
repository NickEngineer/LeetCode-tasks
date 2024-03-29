package ua.nick.leetcode.easy;

/*
*
    205. Isomorphic Strings
    Easy

    Given two strings s and t, determine if they are isomorphic.

    Two strings are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

    Example 1:

    Input: s = "egg", t = "add"
    Output: true
    Example 2:

    Input: s = "foo", t = "bar"
    Output: false
    Example 3:

    Input: s = "paper", t = "title"
    Output: true
    Note:
    You may assume both s and t have the same length.
*
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings205 {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "ab"));
    }

    public static boolean isIsomorphic(String s, String t) {
        boolean answer = true;
        if (s.length() == t.length()) {
            char[] sChars = s.toCharArray(), tChars = t.toCharArray();
            Map<Character, Character> mapIsomorphicCharacters = new HashMap<>(s.length());
            Set<Character> tCharactersSet = new HashSet<>(t.length());

            for (int i = 0; i < sChars.length; ++i) {
                if (mapIsomorphicCharacters.containsKey(sChars[i])) {
                    if (mapIsomorphicCharacters.get(sChars[i]) != tChars[i]) {
                        answer = false;
                        break;
                    }
                } else {
                    if (!tCharactersSet.add(tChars[i])) {
                        answer = false;
                        break;
                    }
                    mapIsomorphicCharacters.put(sChars[i], tChars[i]);
                }
            }
        } else {
            answer = false;
        }
        return answer;
    }
}
