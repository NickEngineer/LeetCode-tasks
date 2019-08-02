package ua.nick.leetcode.easy;

//7.  ReverseInteger

/*
    Reverse Integer
    Easy

    Given a 32-bit signed integer, reverse digits of an integer.

    Example 1:

    Input: 123
    Output: 321
    Example 2:

    Input: -123
    Output: -321
    Example 3:

    Input: 120
    Output: 21
    Note:
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range:
    [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0
    when the reversed integer overflows.
*
* */

import static java.lang.Math.toIntExact;

public class ReverseInteger {
    public static void main(String args[]) {
        int length = String.valueOf(1000).length();

        System.out.println(reverse(1563847412));
    }

    public static int reverse(int x) {

        long res = 0;

        int temp = 0;

        boolean positive = true;

        if (x < 0) {
            positive = false;
            x = Math.abs(x);
        }

        int length = (int) (Math.log10(x) + 1);


        for (int i = 0; i < length; ++i) {
            temp = x % 10;
            x /= 10;

            if (res == 0 && temp == 0) {
                continue;
            }

            res += temp;

            if (i != length - 1) {
                res *= 10;
            }
        }
        if (!positive) {
            res *= -1;
        }

        if (res < -2147483648 || res > 2147483647) {
            res = 0;
        }

        return toIntExact(res);
    }
}
