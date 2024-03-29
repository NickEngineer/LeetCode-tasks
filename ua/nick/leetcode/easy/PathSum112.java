package ua.nick.leetcode.easy;

    /*
    * 112. Path Sum
    Easy

    Given a binary tree and a sum, determine if the tree has a root-to-leaf path
    such that adding up all the values along the path equals the given sum.

    Note: A leaf is a node with no children.

    Example:

    Given the below binary tree and sum = 22,

          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
    return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
    * */

public class PathSum112 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result = false;

        if (root != null) {
            result = findPathSumResult(root, sum, 0);
        }

        return result;
    }

    private static boolean findPathSumResult(TreeNode root, int sum, int totalSumOfThePath) {
        boolean result = false;

        totalSumOfThePath += root.val;

        if (root.left == null && root.right == null) {
            if (sum == totalSumOfThePath) {
                result = true;
            }
        } else {
            if (root.left != null) {
                result |= findPathSumResult(root.left, sum, totalSumOfThePath);
            }
            if (root.right != null) {
                result |= findPathSumResult(root.right, sum, totalSumOfThePath);
            }
        }

        return result;
    }
}
