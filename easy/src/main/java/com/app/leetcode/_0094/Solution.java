package com.app.leetcode._0094;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class Solution {

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();

        traversal(root, ret);

        return ret;


    }

    private void traversal(TreeNode root, List<Integer> ret) {

        if (root == null) return;

        traversal(root.left, ret);
        ret.add(root.val);
        traversal(root.right, ret);

    }


    /**
     * 迭代（使用栈）
     * 深度优先遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalV2(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

             cur = stack.pop();
            ret.add(cur.val);
            cur = cur.right;


        }
        return ret;


    }

    /**
     * Morris Traversal
     * Threaded Binary Tree
     * 1. 初始化当前节点为root
     * 2. cur不为空时，
     * （1）不存在左孩子，添加值，然后去右孩子
     * （2）反之，使得当前右孩子成为最右的结点，然后，继续移动左孩子的指针
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversalV3(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        TreeNode cur = root;
        TreeNode pre;

        while (cur != null) {

            if (cur != null) {

                ret.add(cur.val);
                cur = cur.right;


            } else {
                pre = cur.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = cur;
                TreeNode temp = cur;

                cur = cur.left;
                temp.left = null;


            }
        }

        return ret;

    }

}
