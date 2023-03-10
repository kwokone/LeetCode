package com.app.jz._24;

public class Solution {

    /**
     * 递归
     * 输入：
     * {1,2,3}
     * 返回值：
     * {3,2,1}
     *
     * 局部反转： 当前节点的下一个节点的next指向当前节点
     *          当前节点的next指针指向null
     *
     *           2 -> 1 -> null
     *           3 -> 2 -> null
     *
     * https://blog.algomooc.com/024.html#%E4%BA%8C%E3%80%81%E9%A2%98%E7%9B%AE%E8%A7%A3%E6%9E%90
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){


        // 递归终止条件
        if (head == null || head.next == null){
            return head;

        }

        ListNode cur = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return cur;





    }
}
