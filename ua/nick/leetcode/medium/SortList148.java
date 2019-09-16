package ua.nick.leetcode.medium;

/*
    *148. Sort List
    Medium

    Sort a linked list in O(n log n) time using constant space complexity.

    Example 1:

    Input: 4->2->1->3
    Output: 1->2->3->4

    Example 2:

    Input: -1->5->3->4->0
    Output: -1->0->3->4->5
* */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortList148 {

    public static void main(String[] args) {

        ListNode head = new ListNode(-700);
        head.next = new ListNode(5);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(400);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(-1);
        ListNode sortedHead = sortList(head);
        System.out.println(sortedHead);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        ListNode newHead = null;

        int all = 0, ifComp = 0;
        if (head != null) {
            ListNode lastElemOfNewSequence = null;
            ListNode minNode = head;
            ListNode startNode = head;
            ListNode beforeElem = null, beforeMinElem = null;

            while (startNode != null) {

                if (head == null) {
                    beforeMinElem = null;
                }

                while (head != null) {
                    ++all;
                    if (head.val < minNode.val) {
                        ++ifComp;
                        beforeMinElem = beforeElem;
                        minNode = head;
                    }
                    beforeElem = head;
                    head = head.next;
                }

                if (beforeMinElem != null) {
                    beforeMinElem.next = minNode.next;
                }


                if (newHead != null) {
                    lastElemOfNewSequence.next = minNode;
                    lastElemOfNewSequence = lastElemOfNewSequence.next;
                } else {
                    newHead = minNode;
                    lastElemOfNewSequence = newHead;
                }


                if (minNode == startNode) {
                    startNode = startNode.next;
                }
                head = startNode;
                minNode = head;
                beforeElem = null;
                beforeMinElem = null;
            }

        }

        System.out.println(all);
        System.out.println(ifComp);

        return newHead;
    }
}
