package com.app.jz._79;

/**
 * 判断是不是平衡二叉树
 *
 */
public class Solution {

    private boolean flag = false;
    public boolean isBalancedV2(TreeNode root){
        getDepthV2(root);
        return flag;
    }

    /**
     * 从叶子节点遍历到根节点
     * @param root
     * @return
     */
    private int getDepthV2(TreeNode root) {
        if (root == null) {
            flag = true;
            return 0;
        }
        int left = getDepthV2(root.left);
        int right = getDepthV2(root.right);

        int depth = (left > right ? left:right) +1;

        if(Math.abs(left -right) <= 1) {
            flag = true;
        }
        return depth;

    }


    /**
     * 从根节点遍历到叶子节点
     * @param root
     * @return
     */
    public boolean isBanlanced(TreeNode root){

        if (root == null) return true;
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) <=1){

            return isBanlanced(root.left) && isBanlanced(root.right);

        }else {
            return false;
        }

    }
    public int getDepth(TreeNode root){
        if (root == null) return 0;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        return (left > right ? left: right) +1;
    }
}
