package Offer.Chapter4;

import Offer.TreeNode;

import java.util.ArrayList;

public class FindPath {
    private void findPathCore(TreeNode root, int target, int[] curSum,
                              ArrayList<Integer> curPath,
                              ArrayList<ArrayList<Integer>> paths){
        curSum[0] += root.val;
        curPath.add(root.val);
        if (root.left == null && root.right == null && curSum[0] == target)
            paths.add(new ArrayList<>(curPath)); //浅拷贝，线性时间
        if (root.left != null) findPathCore(root.left, target, curSum, curPath, paths);
        if (root.right != null) findPathCore(root.right, target, curSum, curPath, paths);
        curPath.remove(curPath.size()-1);
        curSum[0] -= root.val;
    }

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        int[] curSum = new int[]{0};
        ArrayList<Integer> curPath = new ArrayList<>();
        findPathCore(root, target, curSum, curPath, paths);
        return paths;
    }
}
