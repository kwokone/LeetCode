package com.app.jz._33;

import java.util.Stack;

/**
 * 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true ,否则返回 false 。
 * 假设输入的数组的任意两个数字都互不相同。输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回 true ,否则返回 false 。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution {

    /**
     * 输入：
     * [5,7,6,9,11,10,8]
     * 返回值：
     * true
     * <p>
     * 解题思路：
     * 1. 先找到根节点，为序列最后一个元素
     * 2. 遍历整个序列，大于根节点的为右子树，小于根节点的为左子树
     * 3. 如果遍历的过程中，先出现了大于根节点的节点，后面又出现了小于根节点的节点，则说明不是二叉搜索树的后序遍历
     *
     * @param s
     * @return
     */
    public boolean verifySequenceOfBST(int[] s) {

        if (s == null || s.length <1) return false;
        return isTreeBST(s, 0, s.length - 1);

    }

    public boolean isTreeBST(int[] s, int left, int right) {

        if (left <= right ) return true;

        int root = s[right];
        int i = left;

        // 找出分割两颗子树的临界点 i

        for (; i < right; i++) {
            if (s[i] > root) break;
        }
        for (int j = i; j < right; j++) {
            if (s[j] < root) return false;
        }

        return isTreeBST(s, left, i - 1) && isTreeBST(s, i, right - 1);
    }


    /**
     * 二叉树的中序后序遍历对应着一种栈的压入、弹出序列
     * 对后序遍历的序列从小到大排列也就得到了中序遍历序列
     * 得到中序遍历序列后，将其作为入栈序列，检查后序遍历是不是一个合法的出栈序列即可
     *
     * @param pushA
     * @param popA
     * @return
     */
    public boolean verifySequenceOfBSTV2(int[] pushA, int[] popA) {

        if (pushA.length == 0 || popA.length == 0) return false;

        Stack<Integer> stack = new Stack<>();

        // 用于标识弹出序列的位置
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            // 如果栈不为空 且栈顶元素等于弹出序列
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                stack.pop(); // 出栈
                popIndex++; // 弹出序列向后一位
            }
        }

        return stack.empty();


    }


}
