package ua.nick.leetcode.easy;

/*
    * 104. Maximum Depth of Binary Tree
    Easy

    Given a binary tree, find its maximum depth.

    The maximum depth is the number of nodes along
    the longest path from the root node down to
    the farthest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    return its depth = 3.
* */

public class MaximumDepthOfBinaryTree104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        System.out.println();
    }

    public static int maxDepth(TreeNode root) {
        int maxDepthValue = 0, left=0, right=0;

        if(root!=null){
            maxDepthValue = 1;

            if (root.left != null) {
                left = maxDepth(root.left);
            }

            if (root.right != null) {
                right = maxDepth(root.right);
            }

            maxDepthValue += Math.max(left,right);
        }



        return maxDepthValue;
    }
}
