package com.app.jz._86;

import java.util.ArrayList;

/**
 * 在二叉树中找到两个节点的最近公共祖先
 */
public class Solution {

    /**
     * 路径比较法
     * <p>
     * step 1：利用dfs求得根节点到两个目标节点的路径：每次选择二叉树的一棵子树往下找，同时路径数组增加这个遍历的节点值。
     * step 2：一旦遍历到了叶子节点也没有，则回溯到父节点，寻找其他路径，回溯时要去掉数组中刚刚加入的元素。
     * step 3：然后遍历两条路径数组，依次比较元素值。
     * step 4：找到两条路径第一个不相同的节点即是最近公共祖先。
     *
     * @param root
     * @param o1
     * @param o2
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {

        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();

        dfs(root, path1, o1);
        // 重置flag
        dfs(root, path2, o2);

        int res = 0;

        // 比较
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            int x = path1.get(i);
            int y = path2.get(i);

            if (x == y) res = x;
            else break;

        }
        return res;


    }

    private boolean flag = false;

    /**
     * 求根节点到目标节点的路径
     *
     * @param root
     * @param path
     * @param o
     */
    private void dfs(TreeNode root, ArrayList<Integer> path, int o) {

        if (flag || root == null) return;
        path.add(root.val);

        if (root.val == o) {
            flag = true;
            return;
        }
        dfs(root.left, path, o);
        dfs(root.right, path, o);

        if (flag) return;
        // 回溯
        path.remove(path.size() - 1);


    }

    /**
     * 二叉树递归
     *step 1：如果o1和o2中的任一个和root匹配，那么root就是最近公共祖先。
     * step 2：如果都不匹配，则分别递归左、右子树。
     * step 3：如果有一个节点出现在左子树，并且另一个节点出现在右子树，则root就是最近公共祖先.
     * step 4：如果两个节点都出现在左子树，则说明最低公共祖先在左子树中，否则在右子树。
     * step 5：继续递归左、右子树，直到遇到step1或者step3的情况。
     *
     */
    public int lowestCommonAncestorV2(TreeNode root, int o1,int o2){
        // 没有找到，返回-1
        if (root == null) return  -1;
        // 该结点是其中的某一个节点
        if (root.val == o1 || root.val == o2) return root.val;
        // 左子树寻找公共祖先
        int left = lowestCommonAncestorV2(root.left,o1,o2);
        // 右子树寻找公共祖先
        int right = lowestCommonAncestorV2(root.right,o1,o2);
        // 左子树没找到，则在右子树中
        if (left == -1) return right;
        // 右子树没找到，则在左子树中
        if (right == -1) return left;

        // 否则就是当前的节点
        return root.val;


    }


}
