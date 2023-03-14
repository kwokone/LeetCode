package com.app.leetcode._0092;

/**
 * 反转链表 II
 * 给你单链表的头指针 head 和两个整left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表
 * <p>
 * 9 -> 2 -> 5 -> 4 -> 6    [2,4]
 * 9 -> 4 -> 5 -> 2 -> 6
 * prev  left    right succ
 */
public class Solution {

    /**
     * 穿针引线
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 虚拟节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy; // 链表的指针

        // left的前一个结点
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;

        }
        // right节点
        ListNode rightNode = prev;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 截断出一个子链表

        ListNode leftNode = prev.next;
        ListNode curr = rightNode.next;

        prev.next = null;
        rightNode.next = null;

        // 反转
        reverseLinkedList(leftNode);

        //   接回原来的链表中
        prev.next = rightNode;
        leftNode.next = curr;

        return dummy.next;


    }

    /**
     * 反转一个链表
     * * 2 -> 5 -> 4 -> null
     * * null <- 2 <-5 <-4
     *
     * @param head
     */
    private void reverseLinkedList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {

            // 单链表
            curr.next = prev; // 下一个节点 移动到prev

            // 循环遍历
            prev = curr;  //  prev移动到当前节点
            curr = curr.next; // curr移动到下一个节点

        }


    }


}
