package Offer.Chapter6;

import Offer.TreeNode;

import java.util.ArrayList;

public class KthNode {
    private void kthNode(TreeNode pRoot, ArrayList<TreeNode> nodes){
        if (pRoot.left != null) kthNode(pRoot.left, nodes);
        nodes.add(pRoot);
        if (pRoot.right != null) kthNode(pRoot.right, nodes);
    }

    public TreeNode kthNode(TreeNode pRoot, int k){
        if (pRoot == null || k < 1) return null;
        ArrayList<TreeNode> nodes = new ArrayList<>();
        kthNode(pRoot, nodes);
        return k > nodes.size() ? null : nodes.get(k-1);
    }
}
