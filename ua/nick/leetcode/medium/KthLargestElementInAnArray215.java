package ua.nick.leetcode.medium;

/*
    *215. Kth Largest Element in an Array
    Medium

    Find the kth largest element in an unsorted array.
    Note that it is the kth largest element in the sorted
    order, not the kth distinct element.

    Example 1:

    Input: [3,2,1,5,6,4] and k = 2
    Output: 5

    Example 2:

    Input: [3,2,3,1,2,4,5,5,6] and k = 4
    Output: 4
    Note:
    You may assume k is always valid, 1 ≤ k ≤ array's length.
* */

import java.util.Arrays;

public class KthLargestElementInAnArray215 {

    public static void main(String[] args) {
        int[] inputArr = {3,2,3,1,2,4,5,5,6};

        System.out.println(findKthLargest(inputArr, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }
}
