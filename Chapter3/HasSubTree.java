package Offer.Chapter3;

import Offer.TreeNode;

public class HasSubTree {
    private boolean doesTree1HaveTree2(TreeNode pRoot1, TreeNode pRoot2) {
        if (pRoot2 == null) return true;
        if (pRoot1 == null) return false;
        if (pRoot1.val == pRoot2.val)
            return doesTree1HaveTree2(pRoot1.left, pRoot2.left)
                    && doesTree1HaveTree2(pRoot1.right, pRoot2.right);
        return false;
    }

    public boolean hasSubTree(TreeNode pRoot1, TreeNode pRoot2){
        boolean result = false;
        if (pRoot1 != null && pRoot2 != null){
            if (pRoot1.val == pRoot2.val) result = doesTree1HaveTree2(pRoot1, pRoot2);
            if (!result) result = hasSubTree(pRoot1.left, pRoot2);
            if (!result) result = hasSubTree(pRoot1.right, pRoot2);
        }
        return result;
    }
}
