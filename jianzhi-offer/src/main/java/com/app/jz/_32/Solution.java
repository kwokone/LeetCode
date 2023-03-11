package com.app.jz._32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * <p>
 * 不分行从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * 输入：
 * {8,6,10,#,#,2,1}
 * 返回值：
 * [8,6,10,2,1]
 */
public class Solution {


    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {

        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> ret = new ArrayList<>();

        if (root == null) return ret;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            ret.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return ret;

    }

}
