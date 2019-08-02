package ua.nick.leetcode.easy;

/*
*
    1. Two Sum
    Easy

    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    Example:

    Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,
    return [0, 1].
*
* */

public class TwoSum1 {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length - 1; ++i) {
            answer[1] = getSecondIndex(i, target, nums);
            if (answer[1] != -1) {
                answer[0] = i;
                break;
            }
        }

        return answer;
    }

    private static int getSecondIndex(int firstIndex, int target, int[] nums) {
        for (int i = firstIndex + 1; i < nums.length; ++i) {
            if (nums[firstIndex] + nums[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
