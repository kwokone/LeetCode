package com.app.jz._07;

/**
 * 重建二叉树
 * 给定节点数为 n 的二叉树的前序遍历和中序遍历结果，请重建出该二叉树并返回它的头结点
 * 提示:
 * 1.vin.length == pre.length
 * 2.pre 和 vin 均无重复元素
 * 3.vin出现的元素均出现在 pre里
 * 4.只需要返回根结点，系统会自动输出整颗树做答案对比
 * 要求：
 * 空间复杂度 O(n)，时间复杂度 O(n)
 */
public class Solution {

    /**
     * 输入：
     * [1,2,4,7,3,5,6,8],[4,7,2,1,5,3,8,6]
     * 返回值：
     * {1,2,3,4,#,5,6,#,7,#,#,8}
     * <p>
     * 解题思路：
     * 1. 通过前序序列确定第一个元素是根节点
     * 2. 通过根节点把中序序列分成两个序列，[4,7,2] [5,3,8，6]
     * 3. 左右子树的中序序列可以求出前序遍历的左右子树序列：[2,4,7] [3,5,8,6]
     * 4. 左右子树的前序序列的第一个元素分别是根接电脑的左右儿子
     * 5. 递归重复以上步骤
     *
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        TreeNode root;
        root = rebuild(pre,0,pre.length-1,in,0,in.length-1);
        return root;


    }

    private TreeNode rebuild(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd) return null;

        // 根节点
        TreeNode root = new TreeNode(pre[preStart]);
        // 寻找根节点在中序序列的位置
        for (int i = inStart; i <= inEnd; i++) {

            if (in[i] == pre[preStart]) {

                root.left = rebuild(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = rebuild(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);


            }


        }

        return root;


    }


}
