package com.app.jz._76;

/**
 * 删除链表中的重复元素
 * 输入：
 * {1,2,3,3,4,4,5}
 * 返回值：
 * {1,2,5}
 */
public class Solution {

    /**
     * 判断cur的后两个相邻节点是否相等
     * 相等：记录需要删除节点的值
     * 不等： 继续遍历
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplicatetion(ListNode pHead) {

        if (pHead.next == null || pHead == null) {
            return pHead;
        }
        ListNode pre = new ListNode(-1); // 避免删除头结点时，需要特殊处理
        pre.next = pHead;

        ListNode cur = pre;

        while (cur.next != null && cur.next.next != null) {

            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;

                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }


            } else {
                cur = cur.next;
            }

        }

        return pre.next;


    }

}
