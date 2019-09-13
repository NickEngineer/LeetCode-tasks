package ua.nick.leetcode.easy;

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
import java.util.Map;

public class SortList148 {

    public static void main(String[] args) {
        System.out.println();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        ListNode minNode = head;
        ListNode maxNode = head;
        ListNode node;

        if (head != null) {
            head = head.next;

            while (head != null) {
                node = head;
                head = head.next;

                if (node.val <= minNode.val) {
                    node.next = minNode;
                    minNode = node;
                } else if (node.val >= maxNode.val) {
                    maxNode.next = node;
                    maxNode = node;
                } else {
                    insertElement(node, minNode);
                }
            }

            maxNode.next = null;
        }

        return minNode;
    }

    private static void insertElement(ListNode elem, ListNode minElem) {
        ListNode elementBeforeInsert = getElementBefore(elem, minElem);
        elem.next = elementBeforeInsert.next;
        elementBeforeInsert.next = elem;
    }

    private static ListNode getElementBefore(ListNode inserted, ListNode minElem) {
        while (minElem.next.val < inserted.val) {
            minElem = minElem.next;
        }
        return minElem;
    }
}
