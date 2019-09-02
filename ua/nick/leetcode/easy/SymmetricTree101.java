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
        root.right = new TreeNode(3);
        /*root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(3);*/

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

    private static class MyResult {
        private boolean result;

        MyResult() {
            result = true;
        }

        public boolean getResult() {
            return result;
        }

        public void setResult(boolean result) {
            this.result = result;
        }
    }

    public static boolean isSymmetric(TreeNode root) {

        MyResult result = new MyResult();

        if (root != null) {
            TreeNode left = root.left, right = root.right;
            checkTreeSymmetric(left, right, result);
        }

        return result.getResult();
    }

    private static void checkTreeSymmetric(TreeNode left, TreeNode right, MyResult result) {

        if (result.getResult()) {
            if (left != null && right != null) {
                if (left.val != right.val) {
                    result.setResult(false);
                    return;
                }

                checkTreeSymmetric(left.left, right.right, result);

                if(result.getResult()){
                    checkTreeSymmetric(left.right, right.left, result);
                }

            } else if (!(left == null && right == null)) {
                result.setResult(false);
                return;
            }
        }

    }
}
