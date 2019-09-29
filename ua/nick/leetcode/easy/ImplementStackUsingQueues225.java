package ua.nick.leetcode.easy;

/*
    *225. Implement Stack using Queues
    Easy

    Implement the following operations of a stack using queues.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    empty() -- Return whether the stack is empty.
    Example:

    MyStack stack = new MyStack();

    stack.push(1);
    stack.push(2);
    stack.top();   // returns 2
    stack.pop();   // returns 2
    stack.empty(); // returns false

    Notes:

    You must use only standard operations of a queue -- which means
    only push to back, peek/pop from front, size, and is empty operations are valid.
    Depending on your language, queue may not be supported natively. You may simulate
    a queue by using a list or deque (double-ended queue), as long as you use only
    standard operations of a queue.
    You may assume that all operations are valid (for example, no pop or top
    operations will be called on an empty stack).
* */

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues225 {

    Queue<Integer> stackQueue;
    //int topElement, popLimiter;
    int addLimiter;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues225() {
        stackQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        addLimiter = stackQueue.size();

        stackQueue.add(x);
        for (int i = 0; i < addLimiter; ++i) {
            stackQueue.add(stackQueue.remove());
        }

        /*topElement = x;
        stackQueue.add(x);*/
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        /*if (stackQueue.size() > 1) {
            popLimiter = stackQueue.size() - 2;

            for (int i = 0; i < popLimiter; ++i) {
                stackQueue.add(stackQueue.poll());
            }

            topElement = stackQueue.poll();
            stackQueue.add(topElement);
        }

        return stackQueue.poll();*/

        return stackQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return stackQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stackQueue.isEmpty();
    }
}
