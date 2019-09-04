package ua.nick.leetcode.easy;

/*
    * 111. Minimum Depth of Binary Tree
    Easy

    Given a binary tree, find its minimum depth.

    The minimum depth is the number of nodes along
    the shortest path from the root node down
    to the nearest leaf node.

    Note: A leaf is a node with no children.

    Example:

    Given binary tree [3,9,20,null,null,15,7],

        3
       / \
      9  20
        /  \
       15   7
    return its minimum depth = 2.
* */

public class MinimumDepthOfBinaryTree111 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        int minDepth = 0;

        if (root != null) {
            minDepth = depthFinder(root, 0);
        }

        return minDepth;
    }

    private int depthFinder(TreeNode root, int depth) {
        ++depth;
        int depthBefore = depth;
        if (root.left != null) {
            depth = depthFinder(root.left, depth);
        }

        if (root.right != null) {
            int tempDepth = depthFinder(root.right, depthBefore);
            if (tempDepth < depth || root.left == null) {
                depth = tempDepth;
            }
        }

        return depth;
    }
}
