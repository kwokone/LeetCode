package com.app.jz._54;

/**
 * 二叉搜索树的第k小的节点
 * <p>
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k大的TreeNode结点值
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 输入：
 * {5,3,7,2,4,6,8},3
 * 返回值：
 * 4
 */
public class Solution {

    int res, k;

    /**
     * 思路一：
     * 二叉搜索树的中序遍历为 递增序列
     * 转换为求中序遍历倒序的第k大节点
     * <p>
     *  思路二：
     * 1. 左子树的节点个数大于了 K 的值，那么此节点只会存在左子树中
     * 2. 左子树的节点个数再加上 1 也就是加上根节点的个数等于了 K ，第K小节点就是根节点
     * 3. 上面都不满足，那么此节点只能存在右子树中，但是在递归中需要缩小查找的节点范围，也就是 K 值减去左子树节点数加一的值，因为要剔除掉这么多个比 K 节点大的节点
     * <p>
     * 所以核心就落在怎么求解右子树的节点个数身上
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {

        // 特殊情况
        if (root == null) return -1;

        int count = getCount(root.left);
        if (count >= k) return kthLargest(root.left, k);
        if (count + 1 == k) return root.val;

        return kthLargest(root.right, k - count - 1);


    }

    public int getCount(TreeNode root) {

        if (root == null) return 0;

        return getCount(root.left) + getCount(root.right) + 1;

    }


}
