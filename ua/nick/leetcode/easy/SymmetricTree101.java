package ua.nick.leetcode.easy;

/*
    *101. Symmetric Tree
    Easy

    Given a binary tree, check whether it is a mirror
    of itself (ie, symmetric around its center).

    For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

        1
       / \
      2   2
     / \ / \
    3  4 4  3


    But the following [1,2,2,null,3,null,3] is not:

        1
       / \
      2   2
       \   \
       3    3


    Note:
    Bonus points if you could solve it both recursively
    and iteratively.
* */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SymmetricTree101 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);

        System.out.println(isSymmetric(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        boolean result = true;

        if(root!=null){
            TreeNode left, right;

            List<TreeNode> myLeftTree = new LinkedList<>();
            List<TreeNode> myRightTree = new LinkedList<>();

            if (root.left != null) {
                myLeftTree.add(root.left);
            }

            if (root.right != null) {
                myRightTree.add(root.right);
            }

            getLeftTree(root.left, myLeftTree);
            getRightTree(root.right, myRightTree);

            Iterator<TreeNode> leftIterator = myLeftTree.iterator();
            Iterator<TreeNode> rightIterator = myRightTree.iterator();


            while (leftIterator.hasNext() && rightIterator.hasNext()) {
                left = leftIterator.next();
                right = rightIterator.next();

                if (left != null && right != null) {
                    if (left.val != right.val) {
                        result = false;
                        break;
                    }
                } else if (left != right) {
                    result = false;
                    break;
                }
            }

            if (leftIterator.hasNext() || rightIterator.hasNext()) {
                result = false;
            }
        } else {
            result = false;
        }

        return result;
    }

    private static void getLeftTree(TreeNode root, List<TreeNode> tree) {

        if (root != null) {
            if (root.left != null || root.right != null) {
                tree.add(root.left);
                getLeftTree(root.left, tree);

                tree.add(root.right);
                getLeftTree(root.right, tree);
            }
        }
    }

    private static void getRightTree(TreeNode root, List<TreeNode> tree) {

        if (root != null) {
            if (root.left != null || root.right != null) {
                tree.add(root.right);
                getRightTree(root.right, tree);

                tree.add(root.left);
                getRightTree(root.left, tree);
            }
        }
    }
}
