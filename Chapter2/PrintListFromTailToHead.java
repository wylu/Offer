package Offer.Chapter2;

import Offer.ListNode;

import java.util.ArrayList;
import java.util.Collections;

public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode pHead) {
        ArrayList<Integer> nodes = new ArrayList<>();
        if (pHead == null) return nodes;
        while (pHead != null){
            nodes.add(pHead.val);
            pHead = pHead.next;
        }
        Collections.reverse(nodes);
        return nodes;
    }
}
