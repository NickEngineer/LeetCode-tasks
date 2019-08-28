package ua.nick.leetcode.easy;

/*
    *141. Linked List Cycle
    Easy

    Given a linked list, determine if it has a cycle in it.

    To represent a cycle in the given linked list, we use an integer
    pos which represents the position (0-indexed) in the linked list
    where tail connects to. If pos is -1, then there is no cycle in
    the linked list.


    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: true
    Explanation: There is a cycle in the linked list, where tail
    connects to the second node.


    Example 2:

    Input: head = [1,2], pos = 0
    Output: true
    Explanation: There is a cycle in the linked list, where tail
    connects to the first node.


    Example 3:

    Input: head = [1], pos = -1
    Output: false
    Explanation: There is no cycle in the linked list.

* */

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {

    public static void main(String[] args) {
        System.out.println();
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        boolean isCycle = false;
        ListNode pointer = head;
        /*Set<Integer> values = new HashSet<>();
        Set<ListNode> nodes = new HashSet<>();

        if (pointer != null) {
            while (pointer.next != null) {

                if (!values.add(pointer.val)) {
                    if (!nodes.add(pointer)) {
                        isCycle = true;
                        break;
                    }
                }

                pointer = pointer.next;
            }
        }*/

        /*Set<ListNode> nodes = new HashSet<>();

        if (pointer != null) {
            while (pointer.next != null) {

                if (!nodes.add(pointer)) {
                    isCycle = true;
                    break;
                }

                pointer = pointer.next;
            }
        }*/
        if (pointer != null) {
            for (int i = 0; pointer.next != null; ++i) {
                if (isCheckNextCycle(pointer, i)) {
                    isCycle = true;
                    break;
                }
                pointer = pointer.next;
            }
        }

        return isCycle;
    }

    private static boolean isCheckNextCycle(ListNode pointer, int position) {
        boolean isCycle = false;
        ListNode check = pointer;

        for (int i = 0; i < position; ++i) {
            check = check.next;
            if (check == null) {
                break;
            } else if (check == pointer) {
                isCycle = true;
                break;
            }
        }
        return isCycle;
    }
}
