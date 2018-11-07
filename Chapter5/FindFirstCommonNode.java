package Offer.Chapter5;

import Offer.ListNode;

public class FindFirstCommonNode {
    private static int getListLength(ListNode pHead){
        int len = 0;
        ListNode pNode = pHead;
        while (pNode != null){
            len++;
            pNode = pNode.next;
        }
        return len;
    }

    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2){
        if (pHead1 == null || pHead2 == null) return null;
        int len1 = getListLength(pHead1);
        int len2 = getListLength(pHead2);
        ListNode pNode1 = pHead1, pNode2 = pHead2;
        int t = Math.abs(len1 - len2);
        if (len1 < len2){
            while (t-- != 0) pNode2 = pNode2.next;
        }else if(len1 > len2){
            while (t-- != 0) pNode1 = pNode1.next;
        }
        while (pNode1 != pNode2){
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

    public static void main(String[] args){
        ListNode node7 = new ListNode(7);
        ListNode node6 = new ListNode(6);
        node6.next = node7;

        ListNode node3 = new ListNode(3);
        ListNode node5 = new ListNode(5);
        node3.next = node6;
        node5.next = node6;

        ListNode node4 = new ListNode(4);
        node4.next = node5;

        ListNode node2 = new ListNode(2);
        node2.next = node3;
        ListNode node1 = new ListNode(1);
        node1.next = node2;

        System.out.println(findFirstCommonNode(node1, node4).val);
    }
}
