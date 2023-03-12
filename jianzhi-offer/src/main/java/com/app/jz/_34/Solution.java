package com.app.jz._34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 输入一颗二叉树的根节点root和一个整数expectNumber，找出二叉树中结点值的和为expectNumber的所有路径。
 * 1.该题路径定义为从树的根结点开始往下一直到叶子结点所经过的结点
 * 2.叶子节点是指没有子节点的节点
 * 3.路径只能从父节点到子节点，不能从子节点到父节点
 * 4.总节点数目为n
 * <p>
 * 输入：
 * {10,5,12,4,7},22
 * 返回值：
 * [[10,5,7],[10,12]]
 * 说明：
 * 返回[[10,12],[10,5,7]]也是对的
 */
public class Solution {

    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int sum) {

        dfs(root, sum);
        return ret;

    }

    private void dfs(TreeNode root, int sum) {

        if (root==null) return;
        stack.add(root.val);
        sum = sum - root.val;
        if (root.left == null && root.right == null && sum ==0) ret.add(new ArrayList<Integer>(stack));
        dfs(root.left,sum);
        dfs(root.right,sum);
        stack.pop(); // 移除最后一个元素，队列是先进先出，栈才是后进先出
    }
}
