package ua.nick.leetcode.easy;

/*
    *107. Binary Tree Level Order Traversal II
    Easy

    Given a binary tree, return the bottom-up level
    order traversal of its nodes' values.
    (ie, from left to right, level by level from leaf to root).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
        /  \
       15   7
    return its bottom-up level order traversal as:
    [
      [15,7],
      [9,20],
      [3]
    ]
* */


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal2_107 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(17);
        root.left.left = new TreeNode(155);
        root.left.right = new TreeNode(458);
        System.out.println(levelOrderBottom(root).toString());
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> treeValuesOrderBottom = new LinkedList<>();

        reviewTree(root, treeValuesOrderBottom, 1);

        Collections.reverse(treeValuesOrderBottom);

        return treeValuesOrderBottom;
    }

    private static void reviewTree(TreeNode root, List<List<Integer>> treeValuesOrderBottom, int level) {

        if (root != null) {

            if (treeValuesOrderBottom.size() < level) {
                List<Integer> newTreeLevel = new LinkedList<>();
                treeValuesOrderBottom.add(newTreeLevel);
            }

            if (root.left != null) {
                reviewTree(root.left, treeValuesOrderBottom, level + 1);
            }
            if (root.right != null) {
                reviewTree(root.right, treeValuesOrderBottom, level + 1);
            }

            List<Integer> treeLevel = treeValuesOrderBottom.get(level - 1);
            treeLevel.add(root.val);
        }
    }
}
