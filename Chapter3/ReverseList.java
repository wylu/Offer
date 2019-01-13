package Offer.Chapter3;

import Offer.ListNode;

public class ReverseList {
    public ListNode reverseList(ListNode pHead){
        if (pHead == null) return null;
        ListNode pPrev = null;
        ListNode pNode = pHead;
        ListNode pNext;
        while (pNode != null){
            pNext = pNode.next;
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return pPrev;
    }
}
