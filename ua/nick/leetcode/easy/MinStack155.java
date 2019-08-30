package ua.nick.leetcode.easy;

public class MinStack155 {

    public static void main(String[] args) {
        MinStack155 minS = new MinStack155();
        minS.push(2147483646);
        minS.push(2147483646);
        minS.push(2147483647);
        System.out.println(minS.top());
        minS.pop();
        System.out.println(minS.getMin());
        minS.pop();
        System.out.println(minS.getMin());
        minS.pop();
        minS.push(2147483647);
        System.out.println(minS.top());
        System.out.println(minS.getMin());
        minS.push(-2147483648);
        System.out.println(minS.top());
        System.out.println(minS.getMin());
        minS.pop();
        System.out.println(minS.getMin());

    }

    private static class ListNode {
        int val;
        int minVal;
        ListNode next;
        ListNode before;

        ListNode(int x, int minVal) {
            val = x;
            next = null;
            before = null;
            this.minVal = minVal;
        }
    }

    private ListNode head;
    private ListNode top;
    private ListNode tempPointer;
    int minValue;


    public MinStack155() {
        head = null;
        top = null;
        minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (minValue > x) {
            minValue = x;
        }

        if (top != null) {
            tempPointer = top;
            top = new ListNode(x, minValue);
            top.before = tempPointer;
            tempPointer.next = top;
        } else {
            head = new ListNode(x, minValue);
            top = head;
        }
    }

    public void pop() {
        top = top.before;
        if (top != null) {
            top.next = null;
            minValue = top.minVal;
        } else {
            minValue = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return top.minVal;
    }
}
