package Offer.Chapter2;

import Offer.TreeNode;

public class ReconstructBinaryTree {
    public TreeNode constructCore(int[] pre, int[] in,
                                  int startPre, int endPre,
                                  int startIn, int endIn){
        int rootValue = pre[startPre];
        TreeNode root = new TreeNode(rootValue);
        if (startPre == endPre) return root;

        int rootIn = startIn;
        while (rootIn <= endIn && in[rootIn] != rootValue) rootIn++;

        int leftLen = rootIn - startIn;
        if (leftLen > 0){
            root.left = constructCore(pre, in,
                    startPre+1, startPre+leftLen,
                    startIn, rootIn-1);
        }
        if (leftLen < endPre - startPre){
            root.right = constructCore(pre, in,
                    startPre+leftLen+1, endPre,
                    rootIn+1, endIn);
        }
        return root;
    }

    public TreeNode construct(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || pre.length != in.length)
            return null;
        return constructCore(pre, in,
                0, pre.length-1, 0, in.length-1);
    }
}
