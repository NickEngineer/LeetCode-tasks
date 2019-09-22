package ua.nick.leetcode.easy;

/*
    * 172. Factorial Trailing Zeroes
    Easy

    Given an integer n, return the number of trailing zeroes in n!.

    Example 1:

    Input: 3
    Output: 0
    Explanation: 3! = 6, no trailing zero.

    Example 2:

    Input: 5
    Output: 1
    Explanation: 5! = 120, one trailing zero.
    Note: Your solution should be in logarithmic time complexity.
* */

import java.math.BigInteger;

public class FactorialTrailingZeroes172 {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(26));
    }

    public static int trailingZeroes(int n) {
        int trailingZeroes = 0;

        while (n > 0) {
            trailingZeroes += n / 5;
            n /= 5;
        }

        return trailingZeroes;
    }
}
