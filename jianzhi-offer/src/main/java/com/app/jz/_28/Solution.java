package com.app.jz._28;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称）
 */
public class Solution {
    /**
     * 输入：
     * {1,2,2,3,4,4,3}
     * 返回值：
     * true
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot){
        return dfs(pRoot,pRoot);
    }

    private boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2==null) return true;
        if (root1 == null || root2 == null || root1.val != root2.val) return false;

        return dfs(root1.left,root2.right) && dfs(root1.right,root2.left);

    }


    /**
     * 两个队列比较
     */
    boolean isSymmetricalV2(TreeNode root){

        if (root == null) return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(root.left);
        q2.offer(root.right);

        while (!q1.isEmpty() && !q2.isEmpty()){

            TreeNode left = q1.poll();
            TreeNode right = q2.poll();

            if (left == null && right == null) continue;
            if (left == null || right == null || left.val != right.val) return false;

            q1.offer(left.left);
            q1.offer(left.right);

            q2.offer(right.right);
            q2.offer(right.left);


        }

        return true;



    }

}
