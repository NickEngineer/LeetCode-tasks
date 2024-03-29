package ua.nick.leetcode.easy;

/*
    * 167. Two Sum II - Input array is sorted
    Easy


    Given an array of integers that is already sorted in ascending order,
    find two numbers such that they add up to a specific target number.

    The function twoSum should return indices of the two numbers such that
    they add up to the target, where index1 must be less than index2.

    Note:

    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution
    and you may not use the same element twice.

    Example:

    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
* */

import java.util.Arrays;

public class TwoSum2InputArrayIsSorted167 {

    public static void main(String[] args) {
        int[] array = {5, 25, 75};
        int target = 100;

        System.out.println(Arrays.toString(twoSum(array, target)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        if (numbers.length > 1) {
            int top = numbers.length - 1;
            int low = 0;

            while (top > low) {
                if (numbers[top] + numbers[low] == target) {
                    result[0] = low + 1;
                    result[1] = top + 1;
                    break;
                } else if (numbers[top] + numbers[low] > target) {
                    --top;
                } else {
                    ++low;
                }
            }
        }

        return result;
    }
}
