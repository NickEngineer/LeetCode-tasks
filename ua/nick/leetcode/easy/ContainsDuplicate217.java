package ua.nick.leetcode.easy;

/*
    217. Contains Duplicate
    Easy

    Given an array of integers, find if the array contains any duplicates.

    Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

    Example 1:

    Input: [1,2,3,1]
    Output: true
    Example 2:

    Input: [1,2,3,4]
    Output: false
    Example 3:

    Input: [1,1,1,3,3,4,3,2,4,2]
    Output: true
*
* */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 8,7};

        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        boolean answer = false;
        Set<Integer> valuesOfNums = new HashSet<>(nums.length);
        int i = 0;
        while (i < nums.length && valuesOfNums.add(nums[i])) {
            ++i;
        }

        if (i != nums.length) {
            answer = true;
        }

        return answer;
    }
}
