package Offer.Chapter4;

import java.util.LinkedList;

public class IsPopOrder {
    public boolean isPopOrder(int[] pPush, int[] pPop){
        if (pPush == null || pPop == null
                || pPush.length != pPop.length || pPush.length == 0)
            return false;
        int curPush = 0, curPop = 0;
        LinkedList<Integer> stack = new LinkedList<>();

        while (curPop < pPop.length){
            while (stack.isEmpty() || stack.peek() != pPop[curPop]){
                if (curPush == pPush.length) break;
                stack.push(pPush[curPush++]);
            }
            if (stack.peek() != pPop[curPop]) break;

            stack.pop();
            curPop++;
        }
        return curPop == pPop.length;
    }
}
