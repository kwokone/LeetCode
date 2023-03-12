package com.app.jz._78;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 将二叉树打印成多行
 * 给定一个节点数为 n 二叉树，要求从上到下按层打印二叉树的 val 值，
 * 同一层结点从左至右输出，每一层输出一行，将输出的结果存放到一个二维数组中返回
 */
public class Solution {

    /**
     * 输入：
     * {8,6,10,5,7,9,11}
     * 返回值：
     * [[8],[6,10],[5,7,9,11]]
     *
     * @param root
     * @return
     */

    // 层次遍历
    ArrayList<ArrayList<Integer>> printV2(TreeNode root) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        if (root == null) return ret;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int n = queue.size(); // 必须在初始化数组后立即确定queuqe的长度，否则层次会出错
            for (int i = 0; i < n; i++) {
                TreeNode p = queue.poll();
                list.add(p.val);

                if (p.left != null) queue.offer(p.left);
                if (p.right != null) queue.offer(p.right);
            }
            ret.add(list);
        }
        return ret;
    }


    // 递归
    ArrayList<ArrayList<Integer>> print(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        dfs(root, ret, 1);
        return ret;
    }

    private void dfs(TreeNode root, ArrayList<ArrayList<Integer>> ret, int depth) {
        if (root != null) {
            if (ret.size() < depth) ret.add(new ArrayList<>());

            ret.get(depth - 1).add(root.val);
            dfs(root.left, ret, depth - 1);
            dfs(root.right, ret, depth - 1);
        }
    }

}
