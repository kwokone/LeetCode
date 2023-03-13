package com.app.leetcode._0086;

/**
 * 分隔链表
 * <p>
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
 * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 */
public class Solution {
    /**
     * 1 -> 2 -> 2
     * 4 -> 3 -> 5
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {


        ListNode aHead = new ListNode(-1); // 节点,带有数据（虚拟的）
        ListNode bHead = new ListNode(-1); //节点

        ListNode a = aHead; // 指针（不带数据）
        ListNode b = bHead; // 指针

        while (head != null) {

            // 处理逻辑
            if (head.val < x) {
                // 加入左边的链表
                a.next = head;
                // 指针移动到该节点下一个的位置
                a = a.next;
            } else {
                b.next = head;
                b = b.next;
            }
            // 进入下一个循环
            head = head.next;
        }

        // 全部添加完毕后，右边的链表最后一个节点指向null
        b.next = null;

        a.next = bHead.next; // a链表的指针移动到b链表

        return aHead.next;// 返回链接后的a链表


    }
}
