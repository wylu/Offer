package Offer.Chapter4;

import java.util.LinkedList;

public class StackWithMin {
    private LinkedList<Integer> dataStack = new LinkedList<>();
    private LinkedList<Integer> minStack = new LinkedList<>();

    public void push(int num) {
        dataStack.push(num);
        if (minStack.isEmpty()) minStack.push(num);
        else {
            int curMin = minStack.peek();
            minStack.push((num < curMin) ? num : curMin);
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
