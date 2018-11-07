package Offer.Chapter4;

import Offer.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            res.add(node.val);

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return res;
    }
}
