package ua.nick.leetcode.easy;

/*
    * 203. Remove Linked List Elements
    Easy

    Remove all elements from a linked list of integers that have value val.

    Example:

    Input:  1->2->6->3->4->5->6, val = 6
    Output: 1->2->3->4->5
* */

public class RemoveLinkedListElements203 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head != null) {
            while (head != null
                    && head.val == val) {
                head = head.next;
            }

            ListNode listPointer = head;
            ListNode searchNotEqualNode;

            while (listPointer != null) {

                if (listPointer.next != null) {

                    searchNotEqualNode = listPointer.next;

                    while (searchNotEqualNode != null
                            && searchNotEqualNode.val == val) {
                        searchNotEqualNode = searchNotEqualNode.next;
                    }

                    listPointer.next = searchNotEqualNode;
                    listPointer = searchNotEqualNode;
                } else {
                    listPointer = null;
                }
            }
        }

        return head;
    }
}
