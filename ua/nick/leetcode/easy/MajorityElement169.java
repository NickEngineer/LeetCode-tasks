package ua.nick.leetcode.easy;

/*
    * 169. Majority Element
    Easy

    Given an array of size n, find the majority element.
    The majority element is the element that appears more
    than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and
    the majority element always exist in the array.

    Example 1:

    Input: [3,2,3]
    Output: 3
    Example 2:

    Input: [2,2,1,1,1,2,2]
    Output: 2
* */

import java.util.HashMap;
import java.util.Map;

public class MajorityElement169 {

    public static void main(String[] args) {
        int[] input = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(input));
    }

    public static int majorityElement(int[] nums) {
        int majorityEl = nums[0], elemFrequencyInNums = 1, tempFrequency;

        Map<Integer, Integer> frequencyMap = new HashMap<>(nums.length / 2 + 1);

        for (int i = 0; i < nums.length; ++i) {
            if (frequencyMap.containsKey(nums[i])) {
                frequencyMap.put(nums[i], frequencyMap.get(nums[i]) + 1);
            } else {
                frequencyMap.put(nums[i], 1);
            }
        }

        for (Integer key : frequencyMap.keySet()) {
            tempFrequency = frequencyMap.get(key);
            if (tempFrequency > elemFrequencyInNums) {
                majorityEl = key;
                elemFrequencyInNums = tempFrequency;
            }
        }

        return majorityEl;
    }
}
