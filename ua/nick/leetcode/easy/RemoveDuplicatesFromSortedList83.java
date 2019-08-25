package ua.nick.leetcode.easy;

/*
    * 83. Remove Duplicates from Sorted List
    Easy

    Given a sorted linked list, delete all duplicates such that each element
    appear only once.

    Example 1:

    Input: 1->1->2
    Output: 1->2
    Example 2:

    Input: 1->1->2->3->3
    Output: 1->2->3
* */

public class RemoveDuplicatesFromSortedList83 {

    public static void main(String[] args) {
        ListNode head = createList(new int[]{1, 2, 2, 3, 3});
        deleteDuplicates(head);
        printMyList(head);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head != null) {
            ListNode next = head.next, elem = head;

            while (next != null) {
                if (elem.val == next.val) {
                    next = next.next;
                    elem.next = next;
                } else {
                    elem = next;
                    next = next.next;
                }

            }
        }
        return head;
    }

    private static ListNode createList(int[] values) {
        ListNode head = null;

        if (values.length > 0) {
            head = new ListNode(values[0]);
            ListNode elem = head;

            for (int i = 1; i < values.length; ++i) {
                elem.next = new ListNode(values[i]);
                elem = elem.next;
            }
        }
        return head;
    }

    private static void printMyList(ListNode head) {
        ListNode elem = head;

        while (elem != null) {
            System.out.print(elem.val);
            System.out.print(",  ");
            elem = elem.next;
        }
    }
}
