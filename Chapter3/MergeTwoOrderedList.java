package Offer.Chapter3;

import Offer.ListNode;

public class MergeTwoOrderedList {
    public ListNode merge(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null) return pHead2;
        if (pHead2 == null) return pHead1;
        ListNode pResHead;
        if (pHead1.val < pHead2.val){
            pResHead = pHead1;
            pResHead.next = merge(pHead1.next, pHead2);
        }else {
            pResHead = pHead2;
            pResHead.next = merge(pHead1, pHead2.next);
        }
        return pResHead;
    }

    public ListNode mergeII(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null) return pHead2;
        if (pHead2 == null) return pHead1;

        ListNode pResHead, pResEnd, pNode1, pNode2;
        if (pHead1.val < pHead2.val){
            pResHead = pResEnd = pHead1;
            pNode1 = pHead1.next;
            pNode2 = pHead2;
        }else {
            pResHead = pResEnd = pHead2;
            pNode1 = pHead1;
            pNode2 = pHead2.next;
        }
        while (pNode1 != null && pNode2 != null){
            ListNode minNode;
            if (pNode1.val < pNode2.val){
                minNode = pNode1;
                pNode1 = pNode1.next;
            }else {
                minNode = pNode2;
                pNode2 = pNode2.next;
            }
            pResEnd = pResEnd.next = minNode;
        }
        pResEnd.next = (pNode1 != null) ? pNode1 : pNode2;
        return pResHead;
    }
}
