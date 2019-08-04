package ua.nick.leetcode.easy;

/*
*
    206. Reverse Linked List
    Easy

    Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
*
* */

import java.util.LinkedList;

public class ReverseLinkedList206 {

    public static void main(String[] args) {
        ListNode myListNodeHead = new ListNode(1);
        ListNode pointer = myListNodeHead;

        for (int i = 2; i <= 9; ++i) {
            pointer.next = new ListNode(i);
            pointer = pointer.next;
        }

        pointer = myListNodeHead;
        do {
            System.out.println(pointer.val);
            pointer = pointer.next;
        } while (pointer != null);

        myListNodeHead = reverseList(myListNodeHead);

        System.out.println("\n\n");

        pointer = myListNodeHead;
        do {
            System.out.println(pointer.val);
            pointer = pointer.next;
        } while (pointer != null);
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = null, reversedListPointer = null, pointer, nextPointer;

        if (head != null) {
            pointer = head;
            nextPointer = head.next;

            while (pointer.next != null) {
                pointer.next = null;

                if (reversedListPointer != null) {
                    newHead = reversedListPointer;
                    reversedListPointer = pointer;
                    reversedListPointer.next = newHead;

                } else {
                    reversedListPointer = pointer;
                }


                pointer = nextPointer;
                nextPointer = nextPointer.next;
            }
            newHead = reversedListPointer;
            reversedListPointer = pointer;
            reversedListPointer.next = newHead;
            newHead = reversedListPointer;
        }

        return newHead;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
