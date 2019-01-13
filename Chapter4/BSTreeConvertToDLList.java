package Offer.Chapter4;

import Offer.TreeNode;

public class BSTreeConvertToDLList {
    private void convertNode(TreeNode pRoot, TreeNode[] pLast){
        if (pRoot == null) return;
        convertNode(pRoot.left, pLast);

        pRoot.left = pLast[0];
        if (pLast[0] != null) pLast[0].right = pRoot;
        pLast[0] = pRoot;

        convertNode(pRoot.right, pLast);
    }

    public TreeNode convert(TreeNode pRoot) {
        if (pRoot == null) return null;
        TreeNode[] pLast = new TreeNode[]{null};
        convertNode(pRoot, pLast);

        TreeNode pHeadOfList = pRoot;
        while (pHeadOfList.left != null) pHeadOfList = pHeadOfList.left;
        return pHeadOfList;
    }
}
