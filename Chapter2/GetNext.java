package Offer.Chapter2;

import Offer.TreeLinkNode;

public class GetNext {
    public TreeLinkNode getNext(TreeLinkNode pNode){
        if (pNode == null) return null;
        TreeLinkNode pNext;
        if (pNode.right != null){
            TreeLinkNode pRight = pNode.right;
            while (pRight.left != null) pRight = pRight.left;
            pNext = pRight;
        }else{
            TreeLinkNode pCurrent = pNode, pParent = pNode.next;
            while (pParent != null && pCurrent == pParent.right){
                pCurrent = pParent;
                pParent = pCurrent.next;
            }
            pNext = pParent;
        }
        return pNext;
    }
}
