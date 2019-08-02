package ua.nick.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;

/*
    53. Maximum Subarray
    Easy

    Given an integer array nums, find the contiguous subarray (containing at least one number) which has
    the largest sum and return its sum.

    Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
    Follow up:
    
    If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
    which is more subtle.
*
* */

public class MaximumSubarray53 {

    public static void main(String[] args) {
        int[] myArr = new int[]{-1, 4, -2, 7, -5, -755, -2000};

        System.out.println(maxSubArray(myArr));
    }

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        LinkedList<Integer> maxValues = new LinkedList<>();
        int tempSum = 0;

        /*for (int i = 0; i < nums.length - 1; ++i) {

            tempSum = sum + nums[i];*/
            /*if (i == 0 && nums[i] < 0) {
                 sum = nums[i];
            }*/
          /*  if ((tempSum < nums[i + 1] || nums[i] < tempSum)) {
                if ( nums[i] < 0 && sum <= 0) {
                    sum += nums[i];
                }
                maxValues.add(sum);
                sum = 0;
            } else {
                sum = tempSum;
            }
        }*/


        for (int i = 0; i < nums.length - 1; ++i) {
            tempSum = sum + nums[i];

            if (tempSum < nums[i + 1] && nums[i] < 0) {
                maxValues.add(sum);
                sum = 0;
            } else {
                sum += nums[i];
            }
        }

        if (nums.length == 1) {
            sum = nums[0];
        }

        if (nums[nums.length - 1] > 0) {
            sum += nums[nums.length - 1];
            maxValues.add(sum);
        } else {
            maxValues.add(sum);
        }


        for (int elem :
                maxValues) {
            if (elem > max) {
                max = elem;
            }
        }

        return max;
    }
}
