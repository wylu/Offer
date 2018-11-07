package Offer.Chapter6;

import Offer.TreeNode;

public class TreeDepth {
    public static int treeDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(treeDepth(root.left) + 1, treeDepth(root.right) + 1);
    }

    public static void main(String[] args){
        TreeNode node7 = new TreeNode(7);
        TreeNode node5 = new TreeNode(5);
        node5.left = node7;

        TreeNode node4 = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        node3.right = node6;

        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;

        System.out.println(treeDepth(node1));
    }
}
