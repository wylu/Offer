package Offer.Chapter4;

import Offer.TreeNode;

public class BinaryTreeMirror {
    public void mirror(TreeNode pRoot){
        if (pRoot == null) return;
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        pRoot.left = right;
        pRoot.right = left;
        if (left != null) mirror(left);
        if (right != null) mirror(right);
    }
}
