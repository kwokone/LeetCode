package com.app.jz._22;

/**
 * 链表中倒数的最后k个节点
 * 输入：
 * {1,2,3,4,5},2
 * 返回值：
 * {4,5}
 * 说明：
 * 返回倒数第2个节点4，系统会打印后面所有的节点来比较
 */
public class Solution {


    /**
     * 初始化两个指针，一开始都指向链表的头节点
     * 前指针先向前走k步
     * 两个指针同时向前移动，知道前指针指向null
     * 最后返回latter
     *
     * @param pHead
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode pHead, int k) {

        ListNode former = pHead;
        ListNode latter = pHead;

        if (pHead == null || k <= 0) {
            return null;
        }

        int len = 0;
        while (pHead != null) {
            pHead = pHead.next;
            len = len + 1;
        }
        if (len < k) {
            return null;
        }

        for (int i = 0; i < k; i++) {
            former = former.next;
        }

        while (former != null) {
            former = former.next;
            latter = latter.next;
        }
        return latter;

    }

}
