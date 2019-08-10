package ua.nick.leetcode.easy;

/*
*
    66. Plus One
    Easy

    Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

    The digits are stored such that the most significant digit is at the head of the list,
    and each element in the array contain a single digit.

    You may assume the integer does not contain any leading zero, except the number 0 itself.

    Example 1:

    Input: [1,2,3]
    Output: [1,2,4]
    Explanation: The array represents the integer 123.
    Example 2:

    Input: [4,3,2,1]
    Output: [4,3,2,2]
    Explanation: The array represents the integer 4321.
* */

import java.util.Arrays;

public class PlusOne66 {

    public static void main(String[] args) {
        int[] arr = new int[]{9};
        System.out.println(Arrays.toString(plusOne(arr)));
    }

    public static int[] plusOne(int[] digits) {
        boolean increaseNextElem = false;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] + 1 > 9) {
                digits[i] = digits[i] + 1 - 10;
                increaseNextElem = true;
            } else {
                digits[i] = digits[i] + 1;
                increaseNextElem = false;
            }
            if (i == 0 && increaseNextElem) {
                digits = new int[digits.length + 1];
                digits[i] = 1;
            }
            if (!increaseNextElem) {
                break;
            }
        }
        return digits;
    }
}
