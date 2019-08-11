package ua.nick.leetcode.easy;

/*
    69. Sqrt(x)
    Easy

    839

    1463

    Favorite

    Share
    Implement int sqrt(int x).

    Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

    Since the return type is an integer, the decimal digits are truncated and
    only the integer part of the result is returned.

    Example 1:

    Input: 4
    Output: 2
    Example 2:

    Input: 8
    Output: 2
    Explanation: The square root of 8 is 2.82842..., and since
                 the decimal part is truncated, 2 is returned.
* */

public class SqrtX69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {
        double result = 1;

        result = (result + (x / result)) / 2;//Geron's formula

        while ((long) result * (long) result > x) {
            result = (result + (x / result)) / 2;
        }

        return (int) result;
    }
}

