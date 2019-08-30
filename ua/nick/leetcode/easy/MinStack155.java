package ua.nick.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinStack155 {

    public static void main(String[] args) {
        MinStack155 minS = new MinStack155();
        minS.push(-2);
        minS.push(0);
        minS.push(-6);
        minS.push(0);
        minS.push(5);
        minS.push(0);
        minS.push(8);
        minS.push(0);
        minS.push(4);
        minS.push(0);
        minS.push(7);
        minS.push(54);
        minS.push(0);
        minS.push(2);
        minS.push(-3);
        minS.push(-5);
        minS.push(-3);
        minS.push(-8);
        minS.push(-3);
        System.out.println(minS.getMin());
        minS.pop();
        System.out.println(minS.top());
        System.out.println(minS.getMin());

    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode before;

        ListNode(int x) {
            val = x;
            next = null;
            before = null;
        }
    }

    private ListNode head;
    private ListNode top;
    private ListNode tempPointer;

    public MinStack155() {
        head = null;
        top = null;
    }

    public void push(int x) {
        if (top != null) {
            tempPointer = top;
            top = new ListNode(x);
            top.before = tempPointer;
            tempPointer.next = top;
        } else {
            head = new ListNode(x);
            top = head;
        }
    }

    public void pop() {
        top = top.before;

        if (top != null) {
            top.next = null;
        }

    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        tempPointer = head;
        int minValue = Integer.MAX_VALUE;

        while (tempPointer != null) {
            if (tempPointer.val < minValue) {
                minValue = tempPointer.val;
            }
            tempPointer = tempPointer.next;
        }
        return minValue;
    }
}
