package ua.nick.leetcode.easy;

/*
    * 231. Power of Two
    Easy

    Given an integer, write a function to determine if it is a power of two.

    Example 1:

    Input: 1
    Output: true
    Explanation: 20 = 1
    Example 2:

    Input: 16
    Output: true
    Explanation: 24 = 16
    Example 3:

    Input: 218
    Output: false
*
* */

public class PowerOfTwo231 {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE);
    }

    public static boolean isPowerOfTwo(int n) {
        boolean answer = false;

        if (hammingWeight(n) == 1 && n!=Integer.MIN_VALUE) {
            answer = true;
        }

        return answer;
    }

    public static int hammingWeight(int n) {
        int answer = 0;

        for (int i = 0; i < 32; ++i) {
            answer += n & 1;
            n = n >> 1;
        }

        return answer;
    }
}
