package Offer.Chapter4;

import Offer.RandomListNode;

public class ComplexLinkedListCopy {
    private void cloneNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pClone = new RandomListNode(pNode.label);
            pClone.next = pNode.next;
            pNode.next = pClone;
            pNode = pClone.next;
        }
    }

    private void connectRandomNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        while (pNode != null){
            RandomListNode pClone = pNode.next;
            if (pNode.random != null) pClone.random = pNode.random.next;
            pNode = pClone.next;
        }
    }

    private RandomListNode reconnectNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pCloneHead = null, pCloneNode = null;
        if (pNode != null){
            pCloneHead = pCloneNode = pNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        while (pNode != null){
            pCloneNode.next = pNode.next;
            pCloneNode = pCloneNode.next;
            pNode.next = pCloneNode.next;
            pNode = pNode.next;
        }
        return pCloneHead;
    }

    public RandomListNode clone(RandomListNode pHead){
        cloneNodes(pHead);
        connectRandomNodes(pHead);
        return reconnectNodes(pHead);
    }
}
