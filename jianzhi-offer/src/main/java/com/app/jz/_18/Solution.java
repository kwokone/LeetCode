package com.app.jz._18;


/**
 * 删除链表的节点
 * 输入：
 * {2,5,1,9},5
 * 返回值：
 * {2,1,9}
 * 说明：
 * 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 2 -> 1 -> 9
 */
public class Solution {
    public ListNode deleteNode(ListNode head, int val){

       if (head.val == val) return head.next;

       // 设置两个指针，分别指向当前节点和下一个节点
        ListNode pre = head;
        ListNode cur = head.next;

        // cur为空或者cur节点值等于目标值时跳出循环
        while (cur != null && cur.val != val){

            pre = cur; // pre 来到cur的位置
            cur = cur.next; // cur来到下一个位置

        }

        pre.next = cur.next; // 遇到了删除的元素，将前一个节点的引用指向当前节点的下一个节点

        return head; // 返回链表头节点即可








    }
}
