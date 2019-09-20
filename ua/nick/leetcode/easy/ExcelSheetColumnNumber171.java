package ua.nick.leetcode.easy;

/*
    *171. Excel Sheet Column Number
    Easy

    Given a column title as appear in an Excel sheet, return its corresponding column number.

    For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        ...
    Example 1:

    Input: "A"
    Output: 1

    Example 2:

    Input: "AB"
    Output: 28

    Example 3:

    Input: "ZY"
    Output: 701
* */

public class ExcelSheetColumnNumber171 {

    public static void main(String[] args) {
        System.out.println(titleToNumber("asdf"));
    }

    public static int titleToNumber(String s) {
        int result = 0;

        if (s.length() > 0) {
            char[] sChars = s.toUpperCase().toCharArray();

            for (int i = 0; i < sChars.length; ++i) {
                if (sChars[i] < 65 || sChars[i] > 90) {
                    result = 0;
                    break;
                }

                if (i != sChars.length - 1) {
                    result += (sChars[i] - 64) * (Math.pow(26, (sChars.length - 1 - i)));
                } else {
                    result += (sChars[i] - 64);
                }
            }
        }

        return result;
    }
}
