package Offer.Chapter3;

import Offer.ListNode;

public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead){
        ListNode first = new ListNode(-1);
        first.next = pHead;

        ListNode pNode = pHead;
        ListNode last = first;
        while (pNode != null && pNode.next != null){
            if (pNode.val == pNode.next.val){
                int val = pNode.val;
                while (pNode != null && pNode.val == val)
                    pNode = pNode.next;
                last.next = pNode;
            }else {
                last = pNode;
                pNode = pNode.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,3,4,4,5};
        ListNode pHead = new ListNode(arr[0]);
        ListNode pNode = pHead;
        for (int i = 1; i < arr.length; i++){
            ListNode tmp = new ListNode(arr[i]);
            pNode.next = tmp;
            pNode = tmp;
        }
        ListNode res = new DeleteDuplication().deleteDuplication(pHead);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
