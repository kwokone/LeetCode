package com.app.jz._84;

/**
 * 二叉树中和为某一值的路径(三)
 * 给定一个二叉树root和一个整数值 sum ，求该树有多少路径的的节点值之和等于 sum 。
 * 1.该题路径定义不需要从根节点开始，也不需要在叶子节点结束，但是一定是从父亲节点往下到孩子节点
 * 2.总节点数目为n
 * 3.保证最后返回的路径个数在整形范围内(即路径个数小于231-1)
 */
public class Solution {

    /**
     * step 1：每次将原树中遇到的节点作为子树的根节点送入dfs函数中查找有无路径，如果该节点为空则返回。
     * step 2：然后递归遍历这棵树每个节点，每个节点都需要这样操作。
     * step 3：在dfs函数中，也是往下递归，遇到一个节点就将sum减去节点值再往下。
     * step 4：剩余的sum等于当前节点值则找到一种情况
     *
     * @param root
     * @param sum
     * @return
     */
    public int findPath(TreeNode root, int sum) {

        if (root == null) return res;
        dfs(root, sum);
        findPath(root.left, sum);
        findPath(root.right, sum);
        return res;


    }

    private int res = 0;

    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        if (sum == root.val) res++;
        // 进入子节点继续找
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
    }

}
