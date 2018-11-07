package Offer.Chapter3;

import Offer.ListNode;

public class DeleteNode {
    public void delete(ListNode[] pHead, ListNode[] pDel){
        if (pHead == null || pDel == null) return;

        if (pDel[0].next != null){
            ListNode pNode = pDel[0].next;
            pDel[0].val = pNode.val;
            pDel[0].next = pNode.next;
            pNode.next = null;
        }else if (pDel == pHead){
            pDel[0] = null;
            pHead[0] = null;
        }else {
            ListNode pNode = pHead[0];
            while (pNode.next != pDel[0]) pNode = pNode.next;
            pNode.next = null;
            pDel[0] = null;
        }
    }
}
