package com.app.leetcode._0142;


import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 */
public class Solution {


    /**
     * 快慢指针：
     * slow与fast相遇时，再额外维护一个指针pre;
     * 起始，它指向链表头部；
     * 随后，它和slow每次向后移动一个位置，最终他们会在入环点相遇；
     *
     * @param head
     * @return
     */
    public ListNode detectCycleV2(ListNode head) {

        if (head == null) return null;
        ListNode slow = head, fast = head;

        while (fast != null) {
            slow = slow.next;
            // 快指针的 下下 个节点存在
            if (fast.next != null) fast = fast.next.next;
            else return null;
            // 快慢指针相遇
            if (fast == slow) {
                // 定义一个位于头结点的索引
                ListNode index = head;
                // 每次index和慢指针移动同样的步长
                while (index != slow) {
                    index = index.next;
                    slow = slow.next;
                }
                // 两个指针相遇，说明就是环的入口
                return index;

            }
        }

        // 其他情况是没有环的链表
        return null;
    }

    /**
     * 方法一：哈希表
     * 遍历链表中的每个节点，并将它记录下来；
     * 一旦遇到此前遍历的节点，就可以判定链表中存在环。
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        ListNode curr = head;

        Set<ListNode> set = new HashSet<>();

        while (curr != null) {

            // 逻辑处理
            if (set.contains(curr)) {
                return curr;
            } else {
                set.add(curr);
            }

            // 循环
            curr = curr.next;

        }
        return null;
    }
}
