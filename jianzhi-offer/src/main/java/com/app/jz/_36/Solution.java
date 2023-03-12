package com.app.jz._36;


/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 *
 * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
 * 2.返回链表中的第一个节点的指针
 * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
 * 4.你不用输出双向链表，程序会根据你的返回值自动打印输出
 *
 * 输入：
 * {5,4,#,3,#,2,#,1}
 * 返回值：
 * From left to right are:1,2,3,4,5;From right to left are:5,4,3,2,1;
 * 说明：
 *                     5
 *                   /
 *                 4
 *               /
 *             3
 *           /
 *         2
 *       /
 *     1
 * 树的形状如上图
 */
public class Solution {

    private TreeNode pre = null; // 当前结点的前一个结点
    private TreeNode head = null; // 链表的头节点

    public TreeNode connvert(TreeNode root){

        if (root == null) return null;
        inOrder(root);
        return  head;

    }

    /**
     * 将树分成了三部分
     * https://www.jianshu.com/p/85874b9acb0d
     * @param root
     */
    private void inOrder(TreeNode root) {
        if (root == null) return;
        /**
         * //递归函数，就是中序遍历，维护pre指针和head指针，
         *     //head指针都是在左子树的最左的叶子节点，
         *     // 1.递归的宏观视角：先将左子树排序成双向链表，将右子树排序成双向链表，
         *     // 然后通过根节点来链接，使得最终成为一个双向链表。
         *
         * // 2.递归的微观视角：先判断Head指针，设定好头指针，然后判断pre指针，
         *     // 如果pre为空，则右移pre指向“下一个”节点，
         *     // 如果pre不为空，则将pre和pre的“下一个”节点通过指针联系起来
         */
        /* 遍历左子树 */
        inOrder(root.left);
        root.left = pre;
        if (pre!=null) pre.right = root;
        pre = root;
        /*遍历右子树*/
        if (head == null) head = root;
        inOrder(root.right);

    }
}
