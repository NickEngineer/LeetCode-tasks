package ua.nick.leetcode.easy;

/*
    * 100. Same Tree
    Easy

    Given two binary trees, write a function to check if they are the same or not.

    Two binary trees are considered the same if they are structurally identical and
    the nodes have the same value.

    Example 1:

    Input:     1         1
              / \       / \
             2   3     2   3

            [1,2,3],   [1,2,3]

    Output: true
    Example 2:

    Input:     1         1
              /           \
             2             2

            [1,2],     [1,null,2]

    Output: false
    Example 3:

    Input:     1         1
              / \       / \
             2   1     1   2

            [1,2,1],   [1,1,2]

    Output: false
*
* */

public class SameTree100 {

    public static void main(String[] args) {
        System.out.println();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public static boolean isSameTree(TreeNode p, TreeNode q) {
        boolean result = true;

        if(p!=null && q!=null) {
            if (p.val != q.val) {
                result = false;
            }


            if (result != false) {
                if (p.left != null && q.left != null) {
                    result = isSameTree(p.left, q.left);
                } else if (p.left == null && q.left == null) {

                } else {
                    result = false;
                }

                if(result!=false){
                    if (p.right != null && q.right != null) {
                        result = isSameTree(p.right, q.right);
                    } else if (p.right == null && q.right == null) {

                    } else {
                        result = false;
                    }
                }
            }
        } else if(p==null && q==null){
            result = true;
        } else {
            result = false;
        }

        return result;
    }

}
