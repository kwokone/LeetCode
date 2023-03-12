package com.app.jz._37;

/**
 * 序列化二叉树
 * <p>
 * 二叉树的序列化(Serialize)是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树等遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#）
 * <p>
 * 二叉树的反序列化(Deserialize)是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * <p>
 * 序列化二叉树即找一种顺序存储二叉树的节点，并以相同的方式能够读取序列重新构建。
 * 换种说法，就是遍历二叉树，记录每个节点，再以同样的方式遍历就可以还原二叉树。
 * 遍历的方法有四种：前序遍历、中序遍历、后序遍历、层次遍历，理论上只要以相同的方式序列化或者反序列化，都可以解题。
 */
public class Solution {

    String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder res = new StringBuilder();
        serializeFunction(root, res);
        return res.toString();
    }

    private void serializeFunction(TreeNode root, StringBuilder str) {
        if (root == null) {
            str.append('#');
            return;
        }
        str.append(root.val).append('!');
        serializeFunction(root.left, str);
        serializeFunction(root.right, str);


    }



    TreeNode deserialize(String str) {
        if (str =="#") return null;
        TreeNode res = deserializeFunction(str);
        return res;

    }

    public int index = 0; // 序列的下标
    private TreeNode deserializeFunction(String str) {
        if (str.charAt(index) == '#'){
            index ++;
            return null;
        }
        int val = 0; // 数字转换
        while (str.charAt(index) != '!' && index != str.length()){
            val = val * 10 + (str.charAt(index) - '0');
            index ++;
        }
        TreeNode root = new TreeNode(val);

        // 序列到底时，构建完成
        if (index == str.length()) return root;
        else index ++;

        root.left = deserializeFunction(str);
        root.right =deserializeFunction(str);

        return root;


    }
}
