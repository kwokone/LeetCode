package com.app.jz._26;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（我们约定空树不是任意一个树的子结构）
 * <p>
 * 输入：
 * {8,8,7,9,2,#,#,#,#,4,7},{8,9,2}
 * 返回值：
 * true
 * 输入：
 * {1,2,3},{3,1}
 * 返回值：
 * false
 */
public class Solution {


    /**
     * 解题思路：
     * （1）两颗二叉树节点值不同：1. 递归遍历A树左子树 2. 递归遍历A树右子树
     * （2）两颗二叉树节点值相同： 1. B树为空，则B是A的子树 2.递归判断AB树节点值是否相同
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {

        if (root1 == null || root2 == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root1);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (test(cur, root2)) return true;

            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);


        }

        return false;

    }

    private boolean test(TreeNode root1, TreeNode root2) {

        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val != root2.val) return false;

        return (root1.val == root2.val) && test(root1.left, root2.left) && test(root1.right, root2.right);

    }


}
