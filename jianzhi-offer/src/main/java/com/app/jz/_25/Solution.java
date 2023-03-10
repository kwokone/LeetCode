package com.app.jz._25;

/**
 * 合并两个排序链表
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){

        // 设置虚拟节点 dummy
        ListNode dummy = new ListNode(-1);

        // 设置一个指针，指向虚拟节点
        ListNode pre = dummy;

        // 循环比较l1 l2中当前节点的值的大小
        while (l1 != null && l2 !=null){

            if (l1.val <= l2.val){

                pre.next = l1;
                l1 = l1.next;


            }else {
                pre.next = l2;
                l2 = l2.next;
            }

            pre = pre.next;


        }
        // 跳出循环后，l1或者l2中可能还有节点
        if (l1 != null){
            pre.next = l1;
        }
        if (l2 != null){
            pre.next = l2;
        }

        // 最后返回虚拟节点的next指针
        return dummy.next;

    }
}
