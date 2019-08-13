package ua.nick.leetcode.easy;

/*
    21. Merge Two Sorted Lists
    Easy

    Merge two sorted linked lists and return it as a new list.
    The new list should be made by splicing together the nodes of the first two lists.

    Example:

    Input: 1->2->4, 1->3->4
    Output: 1->1->2->3->4->4
* */

public class MergeTwoSortedLists21 {

    public static void main(String[] args) {
        System.out.println();
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergedListNode, pointer = null;

        if (l1 != null && l2 != null && l1.val < l2.val) {
            pointer = l1;
            l1 = l1.next;
        } else if (l2 != null) {
            pointer = l2;
            l2 = l2.next;
        } else if (l1 != null) {
            pointer = l1;
            l1 = l1.next;
        }

        mergedListNode = pointer;

        while (l1 != null) {
            while (l2 != null && l2.val <= l1.val) {
                pointer.next = l2;
                l2 = l2.next;
                pointer = pointer.next;
            }

            pointer.next = l1;
            l1 = l1.next;
            pointer = pointer.next;
        }

        while (l2 != null) {
            pointer.next = l2;
            l2 = l2.next;
            pointer = pointer.next;
        }

        return mergedListNode;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
