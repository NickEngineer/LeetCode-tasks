package ua.nick.leetcode.easy;

/*
    *160. Intersection of Two Linked Lists
    Easy

    Write a program to find the node at which the intersection of two singly linked lists begins.

    For example, the following two linked lists:


    begin to intersect at node c1.



    Example 1:


    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
    Output: Reference of the node with value = 8
    Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the
    two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B,
    it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3
    nodes before the intersected node in B.


    Example 2:


    Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
    Output: Reference of the node with value = 2
    Input Explanation: The intersected node's value is 2 (note that this must not be 0 if
    the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head
    of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A;
    There are 1 node before the intersected node in B.


    Example 3:


    Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
    Output: null
    Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B,
    it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
    while skipA and skipB can be arbitrary values.
    Explanation: The two lists do not intersect, so return null.


    Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.
* */

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoLinkedLists160 {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersectionNode = null;

        if (headA != null && headB != null) {
            ListNode listALastNode = headA, listBLastNode = headB;
            int listALength = 1, listBLength = 1;

            while (listALastNode.next != null) {
                listALastNode = listALastNode.next;
                ++listALength;
            }

            while (listBLastNode.next != null) {
                listBLastNode = listBLastNode.next;
                ++listBLength;
            }

            if (listALastNode == listBLastNode) {
                int differenceLengthOfLists = Math.abs(listALength - listBLength);

                listALastNode = headA;
                listBLastNode = headB;

                if (listALength > listBLength) {
                    for (int i = 0; i < differenceLengthOfLists; ++i) {
                        listALastNode = listALastNode.next;
                    }
                } else {
                    for (int i = 0; i < differenceLengthOfLists; ++i) {
                        listBLastNode = listBLastNode.next;
                    }
                }

                while (listALastNode != listBLastNode) {
                    listALastNode = listALastNode.next;
                    listBLastNode = listBLastNode.next;
                }

                intersectionNode = listALastNode;
            }
        }

        return intersectionNode;
    }
}
