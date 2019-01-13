package Offer.Chapter4;

import Offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class LayerPrintTree {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> layerList = new ArrayList<>();
        if (pRoot == null) return layerList;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        TreeNode last = pRoot, nextLast = pRoot;

        ArrayList<Integer> layer = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode pNode = queue.poll();
            layer.add(pNode.val);
            if (pNode.left != null){
                queue.offer(pNode.left);
                nextLast = pNode.left;
            }
            if (pNode.right != null){
                queue.offer(pNode.right);
                nextLast = pNode.right;
            }
            if (pNode == last){
                last = nextLast;
                layerList.add(layer);
                layer = new ArrayList<>();
            }
        }
        return layerList;
    }
}
