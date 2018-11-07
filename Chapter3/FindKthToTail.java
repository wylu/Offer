package Offer.Chapter3;

import Offer.ListNode;

public class FindKthToTail {
    public ListNode findKthToTail(ListNode pHead, int k){
        if (pHead == null || k < 1) return null;

        ListNode p1 = pHead, p2 = pHead;
        for (int i = 0; i < k - 1 && p1 != null; i++) p1 = p1.next;
        if (p1 == null) return null;

        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
