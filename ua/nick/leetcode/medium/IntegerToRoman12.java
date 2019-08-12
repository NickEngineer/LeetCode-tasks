package ua.nick.leetcode.medium;

/*
12. Integer to Roman
Medium

Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together.
 Twelve is written as, XII, which is simply X + II.
 The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right.
However, the numeral for four is not IIII. Instead, the number four is written as IV.
 Because the one is before the five we subtract it making four.
 The same principle applies to the number nine, which is written as IX.
 There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
* */

public class IntegerToRoman12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    private static int nValue = 0;

    private static Object[][] intNumbers = new Object[][]{
            {1000, "M"},
            {900, "CM"},
            {500, "D"},
            {400, "CD"},
            {100, "C"},
            {90, "XC"},
            {50, "L"},
            {40, "XL"},
            {10, "X"},
            {9, "IX"},
            {5, "V"},
            {4, "IV"},
            {1, "I"}
    };

    public static String intToRoman(int n) {

        StringBuilder romanValue = new StringBuilder();
        nValue = n;


        while (nValue > 0) {
            romanValue.append(getRomanCombination(intNumbers));
        }

        return romanValue.toString();
    }

    private static String getRomanCombination(Object[][] arr) {
        String value = "";

        for (int i = 0; i < arr.length; ++i) {
            if ((Integer) arr[i][0] <= nValue) {
                value = (String) arr[i][1];
                nValue -= (Integer) arr[i][0];
                break;
            }
        }
        return value;
    }
}
