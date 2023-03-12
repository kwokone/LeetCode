package com.app.leetcode._0206;

/**
 * 反转链表
 * 假设链表为
 * 1→2→3→∅
 * 我们想要把它改成
 * ∅←1←2←3
 */
public class Solution {

    /**
     * 方法二：递归
     * <p>
     * 希望Nk+1的下一个节点指向Nk:
     * N1 → … → Nk−1 → Nk → Nk+1 ← … ← Nm
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next); // 每次递归结束都会得到一个新的链表

        head.next.next = head; // 后节点指向前节点
        head.next = null;  // 前节点断开原来的引用关系
        return newHead; // 返回新的头节点


    }


    /**
     * 方法一：迭代
     * 将当前链表的指针指向前一个结点
     *
     * @param head
     * @return
     */
    public ListNode reverseListV2(ListNode head) {

        ListNode prev = null; // 只保存指针，不保存数据
        ListNode curr = head; // 操作的节点

        // 循环移动
        while (curr != null) {

            ListNode next = curr.next; // 下一个节点

            curr.next = prev; //将当前节点的下一个指针指向prev
            prev = curr; // prev指针 来到当前节点
            curr = next; // 当前节点指针 来到下一个节点

        }

        return prev;


    }
}
