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
        //-1->5->3->4->0 error
        ListNode head = new ListNode(-700);
        head.next = new ListNode(5);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(50);
        //head.next.next.next.next.next = new ListNode(-1);
        System.out.println(sortList(head));
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode sortList(ListNode head) {
        ListNode minNode = head, beforeStartNode = null;
        ListNode startNode = head;
        ListNode node;

        if (head != null) {
            int minNodeLength = 0, startNodeLength = 0, counter = 0;
            head = head.next;

            while (head != null) {
                node = head;
                head = head.next;
                if (startNode.val > node.val) {
                    ++minNodeLength;
                    node.next = startNode;
                    if (minNodeLength == 1) {
                        minNode = node;
                        beforeStartNode = node;
                    } else {
                        beforeStartNode.next = node;
                        beforeStartNode = node;
                    }
                } else {
                    ++startNodeLength;
                    if (startNodeLength == 1) {
                        node.next = null;
                    } else {
                        node.next = startNode.next;
                    }

                    startNode.next = node;
                }
            }

            if (startNodeLength == 0) {
                startNode.next = null;
            }

            if (minNodeLength > 1) {
                minNode = sortElement(null, minNode, startNode);
            }

            if (startNodeLength > 1) {
                sortElement(startNode, startNode.next, null);
            }
        }

        return minNode;
    }

    private static ListNode sortElement(ListNode beforeHead, ListNode head, ListNode nextBlock) {
        ListNode minNode = head, beforeStartNode = beforeHead;
        ListNode startNode = head;
        ListNode node;

        if (head != null && head != nextBlock) {
            int minNodeLength = 0, startNodeLength = 0;
            head = head.next;

            while (head != nextBlock) {
                node = head;
                head = head.next;
                if (startNode.val > node.val) {
                    ++minNodeLength;
                    node.next = startNode;
                    if (minNodeLength == 1) {
                        minNode = node;

                        if (beforeStartNode != null) {
                            beforeStartNode.next = node;
                        }

                        beforeStartNode = node;
                    } else {
                        beforeStartNode.next = node;
                        beforeStartNode = node;
                    }
                } else {
                    ++startNodeLength;
                    if (startNodeLength == 1) {
                        node.next = nextBlock;
                    } else {
                        node.next = startNode.next;
                    }

                    startNode.next = node;
                }
            }

            if (startNodeLength == 0) {
                startNode.next = nextBlock;
            }

            if (minNodeLength > 1) {
                minNode = sortElement(beforeHead, minNode, startNode);
            }

            if (startNodeLength > 1) {
                sortElement(startNode, startNode.next, nextBlock);
            }
        }

        return minNode;
    }
}
