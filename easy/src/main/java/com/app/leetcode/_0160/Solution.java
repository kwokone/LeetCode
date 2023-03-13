package com.app.leetcode._0160;

import java.util.HashMap;
import java.util.Map;

/**
 * 相交链表
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null
 * <p>
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
 * (skipA = 2, skipB = 3)
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA] == listB[skipB]
 * <p>
 * <p>
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8
 */
public class Solution {

    /**
     * 解法二：HashMap
     * <p>
     * 将一个链表中的所有节点信息存入到HashMap
     * key: 当前节点的地址
     * value:当前节点的父节点（头节点的父节点为null）
     * <p>
     * 然后依次遍历另一个链表：
     * 1. 如果hashMap中包含当前节点的key.同时value不等于当前节点的父节点，则为起始节点
     * 2. 遍历到最后不存在，则直接返回null
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeBV2(ListNode headA, ListNode headB) {
        if (headA == headB) return headA;
        Map<ListNode, ListNode> map = new HashMap<>(); // 保存headA
        ListNode p = headA, prev = null, res = null;
        // 全部放入map
        while (p != null) {
            map.put(p, prev);
            // 当前节点的指针(prev)后移
            prev = p;
            p = p.next; // p来到p的下一个节点
        }
        // 重新初始化变量
        p = headB;
        prev = null; // B的prev指针

        // 依次取出headB的节点与map中的比较
        while (p != null) {
            // 逻辑处理
            if (map.containsKey(p) && map.get(p) != prev) {
                res = p;
                break;// 结束循环
            }
            // 没找到时，B的指针继续后移
            prev = p;
            p = p.next;

        }
        return res;
    }

    /**
     * 解法一： 双指针
     * 如果两个链表相交，那么相交点之后的长度是相同的
     * <p>
     * https://leetcode.cn/problems/intersection-of-two-linked-lists/solution/tu-jie-xiang-jiao-lian-biao-by-user7208t/
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;

    }

}
