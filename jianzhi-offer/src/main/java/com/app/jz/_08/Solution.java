package com.app.jz._08;

/**
 * 二叉树的下一个结点
 *
 给定一个二叉树其中的一个结点，请找出中序遍历顺序的下一个结点并且返回
 输入：
 {8,6,10,5,7,9,11},8
 返回值：
 9
 */
public class Solution {
    /**
     * 输入:{8,6,10,5,7,9,11},8
     * 返回:9
     *
     * 如果一个节点的右子树不为空，那么该结点的下一个节点是右子树的最左节点
     * 否则，向上找到第一个左联结指向的树包含该结点的祖先节点
     *
     * @param root
     * @return
     */
    public TreeLinkNode getNext(TreeLinkNode root){

        if (root.right != null){

            TreeLinkNode cur = root.right;
            while (cur.left!= null) cur = cur.left;
            return cur;
        } else {
            while (root.next != null){
                TreeLinkNode parent = root.next;
                if (parent.left == root) return parent;
                root = root.next;
            }
            return null;
        }



    }
}
