package Offer.Chapter6;

import java.util.ArrayList;
import java.util.LinkedList;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size < 1 || size > num.length) return res;

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 0; i < size; i++){
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                deque.pollLast();
            deque.offer(i);
        }
        for (int i = size; i < num.length; i++){
            res.add(num[deque.peek()]);
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()])
                deque.pollLast();
            if (!deque.isEmpty() && deque.peek() <= (i - size))
                deque.poll();
            deque.offer(i);
        }
        res.add(num[deque.peek()]);
        return res;
    }
}
