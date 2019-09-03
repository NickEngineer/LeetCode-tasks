package ua.nick.leetcode.easy;

/*
    *108. Convert Sorted Array to Binary Search Tree
    Easy

    Given an array where elements are sorted in ascending order,
    convert it to a height balanced BST.

    For this problem, a height-balanced binary tree is defined
    as a binary tree in which the depth of the two subtrees
    of every node never differ by more than 1.

    Example:

    Given the sorted array: [-10,-3,0,5,9],

    One possible answer is: [0,-3,9,-10,null,5],
    which represents the following height balanced BST:

          0
         / \
       -3   9
       /   /
     -10  5
* */

public class ConvertSortedArrayToBinarySearchTree108 {

    public static void main(String[] args) {
        System.out.println();
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;

        if (nums.length != 0) {
            root = sortedArrayToBST(nums, new int[]{0}, 0, nums.length);
        }

        return root;
    }

    private static TreeNode sortedArrayToBST(int[] nums, int[] pointer, int left, int right) {
        TreeNode root = null;

        if (left < right) {
            int middle = (left + right) / 2;

            TreeNode leftTreeNode = sortedArrayToBST(nums, pointer, left, middle);

            root = new TreeNode(nums[pointer[0]++]);

            root.left = leftTreeNode;

            root.right = sortedArrayToBST(nums, pointer, middle + 1, right);

        }

        return root;
    }
}
