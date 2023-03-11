package com.app.leetcode._0145;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历
 */
public class Solution {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ret = new ArrayList<>();

        traversal(root, ret);

        return ret;

    }

    private void traversal(TreeNode root, List<Integer> ret) {
        if (root == null) return;

        traversal(root.left, ret);
        traversal(root.right, ret);
        ret.add(root.val);
    }

    /*
     * 迭代 Iteration
     * 前序遍历： root -> left -> right
     * 后序遍历： left -> right -> root
     *
     * 修改前序遍历为 root -> right -> left之后，那么顺序正好和后续遍历相反

     */

    public List<Integer> postorderTraversalV2(TreeNode root) {

        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur == null) continue;
            ret.add(cur.val);
            stack.push(cur.left);
            stack.push(cur.right);
        }
        Collections.reverse(ret);
        return ret;


    }


}
