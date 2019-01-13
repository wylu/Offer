package Offer.Chapter4;

import Offer.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
public class ZPrintTree {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> layerList = new ArrayList<>();
        if (pRoot == null) return layerList;

        LinkedList<TreeNode> stack1 = new LinkedList<>();
        LinkedList<TreeNode> stack2 = new LinkedList<>();
        stack1.push(pRoot);

        ArrayList<Integer> layer = new ArrayList<>();
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            int size = stack1.size();
            while (!stack1.isEmpty()){
                TreeNode pNode = stack1.pop();
                layer.add(pNode.val);
                if (pNode.left != null) stack2.push(pNode.left);
                if (pNode.right != null) stack2.push(pNode.right);
            }
            if (stack1.size() != size){
                layerList.add(layer);
                layer = new ArrayList<>();
            }
            size = stack2.size();
            while (!stack2.isEmpty()){
                TreeNode pNode = stack2.pop();
                layer.add(pNode.val);
                if (pNode.right != null) stack1.push(pNode.right);
                if (pNode.left != null) stack1.push(pNode.left);
            }
            if (stack2.size() != size){
                layerList.add(layer);
                layer = new ArrayList<>();
            }
        }
        return layerList;
    }
}
*/


public class ZPrintTree {
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> layerList = new ArrayList<>();
        if (pRoot == null) return layerList;

        LinkedList[] levels = new LinkedList[2];
        levels[0] = new LinkedList<TreeNode>();
        levels[1] = new LinkedList<TreeNode>();
        int current = 0, next = 1;
        levels[current].push(pRoot);

        ArrayList<Integer> layer = new ArrayList<>();
        while (!levels[0].isEmpty() || !levels[1].isEmpty()){
            TreeNode pNode = (TreeNode) levels[current].pop();
            layer.add(pNode.val);

            if (current == 0){
                if (pNode.left != null) levels[next].push(pNode.left);
                if (pNode.right != null) levels[next].push(pNode.right);
            }else {
                if (pNode.right != null) levels[next].push(pNode.right);
                if (pNode.left != null) levels[next].push(pNode.left);
            }

            if (levels[current].isEmpty()){
                layerList.add(layer);
                layer = new ArrayList<>();
                current = 1 - current;
                next = 1 - next;
            }
        }
        return layerList;
    }

    public static void main(String[] args){
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        for (ArrayList<Integer> e : new ZPrintTree().print(node1)){
            System.out.println(Arrays.toString(e.toArray()));
        }
    }
}

