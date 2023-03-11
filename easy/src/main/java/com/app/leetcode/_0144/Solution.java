package com.app.leetcode._0144;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 */
public class Solution {

    /**
     * 递归 Recursion
     * 1. 初始化集合存放结果，如果根节点不为空则添加值到集合
     * 2. 先遍历左子树，再遍历右子树
     * 3. 重复2
     *
     * @param root
     * @return
     */
    private List<Integer> ret = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {

        dfs(root);
        return ret;
    }

    private void dfs(TreeNode node) {

        if (node == null) {
            return;
        }

        ret.add(node.val);
        dfs(node.left);
        dfs(node.right);


    }

    /**
     * （基于深度优先遍历）
     * 迭代 Iteration
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop(); // 查询顶部元素
            if (cur == null) continue;
                ret.add(cur.val);
                stack.push(cur.right); // 先右后左，保证左子树先遍历
                stack.push(cur.left);
        }

        return ret;

    }

    /**
     * Morris Traversal
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalV3(TreeNode root) {
        List<Integer> ret = new ArrayList<>();

        TreeNode cur = root, last;
        while (cur != null) {

            if (cur.left != null) {
                ret.add(cur.val);
                cur = cur.right;
            } else {

                last = cur.left;
                while (last.right != null && last.right != cur) {
                    last = last.right;
                }

                // If the last node is not modified, we let
                // 'curr' be its right child. Otherwise, it means we
                // have finished visiting the entire left subtree
                if (last.right == null) {
                    ret.add(cur.val);
                    last.right = cur;
                    cur = cur.left;
                } else {
                    last.right = null;
                    cur = cur.right;
                }


            }


        }

        return ret;


    }


}
