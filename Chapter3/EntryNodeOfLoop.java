package Offer.Chapter3;

import Offer.ListNode;

public class EntryNodeOfLoop {
    private ListNode meetingNode(ListNode pHead){
        ListNode pSlow = pHead, pFast = pHead.next;
        while (pFast != null){
            if (pFast == pSlow) return pFast;
            pSlow = pSlow.next;
            pFast = pFast.next;
            if (pFast != null) pFast = pFast.next;
        }
        return null;
    }

    public ListNode entryNodeOfLoop(ListNode pHead){
        if (pHead == null || pHead.next == null) return null;
        ListNode meetNode = meetingNode(pHead);
        if (meetNode == null) return null;

        int nodesInLoop = 1;
        ListNode pNode = meetNode;
        while (pNode.next != meetNode){
            pNode = pNode.next;
            nodesInLoop++;
        }

        ListNode pNode1 = pHead, pNode2 = pHead;
        for (int i = 0; i < nodesInLoop; i++) pNode1 = pNode1.next;

        while (pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

    public static void main(String[] args){
        EntryNodeOfLoop entryNodeOfLoop = new EntryNodeOfLoop();
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        ListNode entryNode = entryNodeOfLoop.entryNodeOfLoop(node1);
        System.out.println(entryNode.val);
    }
}
