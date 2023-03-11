package com.app.jz._77;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按之字形顺序打印二叉树
 * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替)
 */
public class Solution {

    /**
     * 输入：
     * {1,2,3,#,#,4,5}
     * 返回值：
     * [[1],[3,2],[4,5]]
     * <p>
     * 设两个栈，s1存放偶数层，s2 存放奇数层
     * 遍历s2节点的同时按左子树、右子树加入s1
     * s1          右    左       s2
     *
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(pRoot);
        boolean reverse = false;

        while (!queue.isEmpty()) {

            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();

            while (cnt-- > 0) {

                TreeNode node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse) Collections.reverse(list);
            reverse = !reverse;
            if (list.size() != 0)
                res.add(list);
        }
        return res;


    }
}
