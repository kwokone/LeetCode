package com.app.leetcode._0021;


import java.awt.desktop.AppForegroundEvent;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 */
public class Solution {

    /**
     * 迭代
     * 循环终止的时候，l1 l2至多由有一个是非空的
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {

        ListNode prevHead = new ListNode(-1);
        ListNode prev = prevHead;
        while (l1 != null && l2 != null) {

            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;

        }

        // 至多有一个链表是非空的
        prev.next = l1 == null ? l2 : l1;

        return prevHead.next;

    }

    /**
     * 解法一：递归
     * 两个链表的头部较小的一个节点与剩下元素merge
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;

        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
