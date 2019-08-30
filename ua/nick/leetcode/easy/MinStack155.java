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

    int[] values;
    int top;

    public MinStack155() {
        values = new int[16];
        top = -1;
    }

    public void push(int x) {
        if (values.length == top + 1) {
            values = Arrays.copyOf(values, top + 16);
        }

        values[++top] = x;
    }

    public void pop() {
        --top;
    }

    public int top() {
        return values[top];
    }

    public int getMin() {
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i <= top; ++i) {
            if (values[i] < minValue) {
                minValue = values[i];
            }
        }
        return minValue;
    }
}
