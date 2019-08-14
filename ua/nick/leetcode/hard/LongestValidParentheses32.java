package ua.nick.leetcode.hard;

/*
    * 32. Longest Valid Parentheses
    Hard

    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

    Example 1:

    Input: "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()"
    Example 2:

    Input: ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()"
* */

import java.util.Stack;

public class LongestValidParentheses32 {


    public static void main(String[] args) {
        String str = "())(){{{}(})}(()()()";

        System.out.println(longestValidParentheses(str));
    }

    public static int longestValidParentheses(String s) {
        int maxValidSize = 0, tempSize = 0;
        char[] sChars = s.toCharArray();
        Stack<Character> openBrackets = new Stack<>();

        for (int i = 0; i < sChars.length; ++i) {
            if (sChars[i] == '(') {
                openBrackets.push(sChars[i]);
            } else if (openBrackets.size() == 0) {
                tempSize *= 2;
                if (tempSize > maxValidSize) {
                    maxValidSize = tempSize;
                }
                tempSize = 0;
                openBrackets.clear();
            } else if (sChars[i] == ')' && openBrackets.peek() == '(') {
                openBrackets.pop();
                ++tempSize;
            } else {
                tempSize *= 2;
                if (tempSize > maxValidSize) {
                    maxValidSize = tempSize;
                }
                tempSize = 0;
                openBrackets.clear();
            }
        }


        if (openBrackets.size() != 0) {
            int forLimiter = sChars.length - tempSize * 2 - openBrackets.size();
            ;
            tempSize = 0;
            openBrackets.clear();

            for (int i = sChars.length - 1; i >= forLimiter; --i) {
                if (sChars[i] == ')') {
                    openBrackets.push(sChars[i]);
                } else if (openBrackets.size() == 0) {
                    tempSize *= 2;
                    if (tempSize > maxValidSize) {
                        maxValidSize = tempSize;
                    }
                    tempSize = 0;
                    openBrackets.clear();
                } else if (sChars[i] == '(' && openBrackets.peek() == ')') {
                    openBrackets.pop();
                    ++tempSize;
                } else {
                    tempSize *= 2;
                    if (tempSize > maxValidSize) {
                        maxValidSize = tempSize;
                    }
                    tempSize = 0;
                    openBrackets.clear();
                }
            }
        }

        tempSize *= 2;
        if (tempSize > maxValidSize) {
            maxValidSize = tempSize;
        }

        return maxValidSize;
    }
}
