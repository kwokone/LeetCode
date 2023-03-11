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
     * 迭代 Iteration
     * 1. 初始化集合和一个栈
     * 2. 添加根结点
     * 3. 当栈不为空时，最上面的元素出栈，若该元素不为null，则：
     * -- 栈是先进后出
     * （1）将他的值添加到集合
     * （2）将右子树添加到栈
     * （3）将左子树添加到栈
     * 4. 重复3，栈为空时得到目标集合
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode curNode = stack.peek(); // 查询顶部元素
            stack.pop();

            if (curNode != null) {
                ret.add(curNode.val);
                stack.add(curNode.right);
                stack.add(curNode.left);
            }
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
