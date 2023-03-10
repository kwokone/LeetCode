package com.app.jz._52;

import com.app.jz._25.ListNode;

/**
 * 输入：
 * {1,2,3},{4,5},{6,7}
 * 返回值：
 * {6,7}
 * 说明：
 * 第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表的公共部分
 * 这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
 */
public class Solution {

    /**
     * 无论链表是否有相交点，最终都会指向一个相同的节点（公共尾部、或者null）
     *
     * 是在第一链表和第二链表中都存在一个节点，该节点往后的子链表在两个链表中是相同
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2){

        // 边界判断
        if (pHead1 == null || pHead2 == null) {return null;}

        // 设置一个指针，指向链表l1的头结点
        ListNode p1 = pHead1;
        // 设置一个指针，指向链表l2的头结点
        ListNode p2 = pHead2;

        while(p1 != p2){

            p1 = (p1 == null ? pHead2:p1.next);

            p2 = (p2 ==null ? pHead1:p2.next);
        }

        // 相交时会指向相交的节点
        // 不相交则均为null
        return p1;






    }

}
