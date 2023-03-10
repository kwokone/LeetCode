package com.app.jz._55;


/**
 * 二叉树的深度
 * 输入：
 * {1,2,3,4,5,#,6,#,#,7}
 * 返回值：
 * 4
 */
public class Solution {

    /**
     * 树的深度 等于 它的左子树的深度 与 它的右子树的深度 中的 最大值 +1
     *
     * @param root
     * @return
     */
    public int treeDepth(TreeNode root) {

        if (root == null) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);

        int childMaxDepth = Math.max(left, right);
        return childMaxDepth + 1;

    }
}
