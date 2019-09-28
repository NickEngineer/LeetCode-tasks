package ua.nick.leetcode.easy;

/*
    *219. Contains Duplicate II
    Easy

    Given an array of integers and an integer k, find out whether there are two
    distinct indices i and j in the array such that nums[i] = nums[j]
    and the absolute difference between i and j is at most k.

    Example 1:

    Input: nums = [1,2,3,1], k = 3
    Output: true

    Example 2:

    Input: nums = [1,0,1,1], k = 1
    Output: true

    Example 3:

    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false
* */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate2_219 {

    public static void main(String[] args) {
        int[] arr = {99, 99};
        int absoluteDifference = 2;

        System.out.println(containsNearbyDuplicate(arr, absoluteDifference));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean result = false;

        Map<Integer, Integer> valuePositions = new HashMap<>(nums.length);
        Integer mapValue = null;
        int delta;

        for (int i = 0; i < nums.length; ++i) {
            mapValue = valuePositions.get(nums[i]);

            if (mapValue != null) {
                delta = i - mapValue;

                if (delta > k) {
                    valuePositions.put(nums[i], i);
                } else {
                    result = true;
                    break;
                }
            } else {
                valuePositions.put(nums[i], i);
            }
        }

        return result;
    }
}
