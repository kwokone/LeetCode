package com.app.jz._27;


import java.util.Stack;

/**
 * 二叉树的镜像
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=13&tqId=1374963&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * 输入：
 * {8,6,10,5,7,9,11}
 * 返回值：
 * {8,10,6,11,9,7,5}
 */
public class Solution {

    /**
     * 原二叉树 ：
     * 8
     * /  \
     * 6   10
     * / \  / \
     * 5  7 9 11
     * 镜像二叉树：
     * 8
     * /  \
     * 10   6
     * / \  / \
     * 11 9 7  5
     * <p>
     * 解题思路： 先前序遍历这棵树的每个结点，如果遍历的节点有子节点，那么就进行左右子节点的交换
     *
     * @param root
     * @return
     */
    public TreeNode mirror(TreeNode root) {

        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            TreeNode node = stack.pop();
            /**
             * 只要右任何一个孩子节点存在，就要交换两者间的位置
             */
            if (node.left != null || node.right != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }

            /*
             * 已经交换的复节点直接出栈
             */

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }

        }

        /**
         * 返回头结点的引用即可
         */
        return root;

    }
}
