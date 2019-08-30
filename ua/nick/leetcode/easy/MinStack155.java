package ua.nick.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

public class MinStack155 {

    public static void main(String[] args) {
        MinStack155 minS = new MinStack155();
        minS.push(-2);
        minS.push(0);
        minS.push(-3);
        System.out.println(minS.getMin());
        minS.pop();
        System.out.println(minS.top());
        System.out.println(minS.getMin());

    }

    List<Integer> values;
    int valLength;

    public MinStack155() {
        values = new LinkedList<>();
        valLength = -1;
    }

    public void push(int x) {
        values.add(x);
        ++valLength;
    }

    public void pop() {
        values.remove(valLength);
        --valLength;
    }

    public int top() {
        return values.get(valLength);
    }

    public int getMin() {
        int minValue = Integer.MAX_VALUE;
        for (Integer val : values) {
            if (val < minValue) {
                minValue = val;
            }
        }
        return minValue;
    }
}
