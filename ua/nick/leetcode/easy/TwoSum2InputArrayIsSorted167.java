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
        int nextElemPosition = 1;

        if (numbers.length > 1) {
            top:
            for (int i = 0; i < numbers.length - 1; ++i) {
                if (numbers[i] > target) {
                    break;
                }
                while (nextElemPosition < numbers.length) {
                    if (numbers[i] + numbers[nextElemPosition] == target) {
                        result[0] = i + 1;
                        result[1] = nextElemPosition + 1;
                        break top;
                    }
                    if (numbers[i] + numbers[nextElemPosition] > target) {
                        break;
                    }
                    ++nextElemPosition;
                }
                nextElemPosition = i + 2;
            }
        }

        return result;
    }
}
