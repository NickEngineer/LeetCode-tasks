package ua.nick.leetcode.easy;

/*
    * 20. Valid Parentheses
    Easy

    Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Note that an empty string is also considered valid.

    Example 1:

    Input: "()"
    Output: true
    Example 2:

    Input: "()[]{}"
    Output: true
    Example 3:

    Input: "(]"
    Output: false
    Example 4:

    Input: "([)]"
    Output: false
    Example 5:

    Input: "{[]}"
    Output: true
* */

import java.util.Stack;

public class ValidParentheses20 {

    public static void main(String[] args) {
        String str = "([)]";

        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        boolean valid = true;
        char[] sChars = s.toCharArray();

        Stack<Character> openBrackets = new Stack<>();

        for (int i = 0; i < sChars.length; ++i) {
            if (sChars[i] == '(' || sChars[i] == '[' || sChars[i] == '{') {
                openBrackets.push(sChars[i]);
            } else if (openBrackets.size() == 0) {
                valid = false;
                break;
            } else if (sChars[i] == ')' && openBrackets.peek() == '(') {
                openBrackets.pop();
            } else if (sChars[i] == ']' && openBrackets.peek() == '[') {
                openBrackets.pop();
            } else if (sChars[i] == '}' && openBrackets.peek() == '{') {
                openBrackets.pop();
            } else {
                valid = false;
                break;
            }
        }

        if (openBrackets.size() != 0) {
            valid = false;
        }

        return valid;
    }
}
