package Offer.Chapter6;

import Offer.TreeNode;

public class IsAVLTree {
    private static int getDepth(TreeNode root){
        if (root == null) return 0;
        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1) return -1;
        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }

    public static boolean isBalanced(TreeNode root){
        return getDepth(root) != -1;
    }

    public static void main(String[] args){
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        System.out.println(isBalanced(node1));
    }
}
