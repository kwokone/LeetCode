package com.app.jz._68;

/**
 * 二叉搜索树的最近公共祖先
 * 对于该题的最近的公共祖先定义：对于有根树T的两个节点p、q，最近公共祖先LCA(T,p,q)表示一个节点x，满足x是p和q的祖先且x的深度尽可能大
 * 一个节点也可以是它自己的祖先
 * 二叉搜索树是若它的左子树不空，则左子树上所有节点的值均小于它的根节点的值；若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值
 * 所有节点的值都是唯一的，可以通过节点值直接比较
 * p、q 为不同节点且均存在于给定的二叉搜索树中
 */
public class Solution {

    /**
     * step 1：首先检查空节点，空树没有公共祖先。
     * step 2：对于某个节点，比较与p、q的大小，若p、q在该节点两边说明这就是最近公共祖先。
     * step 3：如果p、q都在该节点的左边，则递归进入左子树。
     * step 4：如果p、q都在该节点的右边，则递归进入右子树。
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null) return -1;

        if((p>=root.val && q<= root.val) ||(p<=root.val &&q >= root.val)) return root.val;
        // pq都在该结点的左边
        else if (p<=root.val && q<= root.val)
            return lowestCommonAncestor(root.left,p,q);
        else
            return lowestCommonAncestor(root.right,p,q);

    }


}
