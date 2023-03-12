package com.app.jz._82;

/**
 * 二叉树中和为某一值的路径(一)
 * <p>
 * 给定一个二叉树root和一个值 sum ，判断是否有从根节点到叶子节点的节点值之和等于 sum 的路径
 */
public class Solution {

    /**
     * 输入： {5,4,8,1,11,#,9,#,#,2,7},22
     * 输出： true
     * 要求：空间复杂度 O(n) 时间复杂度 O(n)
     * 进阶 空间复杂度O(树的高度) 时间复杂度O(n)
     * <p>
     * 开始点是根节点， 结束点是叶子节点，目标就是路径。
     * 由于需要找到所有的路径，而不仅仅是一条，因此这里适合使用回溯暴力枚举
     * <p>
     * 回溯法解决的都是在集合中查找子集，集合的大小就是树的叉树，递归的深度，构成树的高度。
     * <p>
     * 这种满足特定和的题目，我们都可以方便地使用前序遍历 + 参数扩展的形式
     * <p>
     * 算法流程：
     * 1.构造空间树。
     * 2.进行遍历。
     * 3.如遇到边界条件，即不再向下搜索，转而搜索另一条链。
     * 4.达到目标条件，输出结果。
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) return false;
        if (root.left == null && root.right == null && root.val == sum) return true;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

}
