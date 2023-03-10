package com.app.jz._23;

import java.util.HashMap;
import java.util.Map;

/**
 * 链表中环的入口节点
 * 输入：
 * {1,2},{3,4,5}
 * 返回值：
 * 3
 * 说明：
 * 返回环形链表入口结点，我们后台程序会打印该环形链表入口结点对应的结点值，即3
 */
public class Solution {


    /**
     * 快慢指针
     * 快指针路程 = a+(b+c)k+b
     * 慢指针路程 = a+b
     * <p>
     * (a+b)*2 = a+(b+c)k+b
     * ==> a=(k-1)(b+c)+c
     * 链表头到环入口的距离 = 相遇点到环入口的距离 + (k-1) 圈环长度。其中 k >= 1，所以 k-1 >= 0 圈。所以两个指针分别从链表头和相遇点出发，最后一定相遇于环入口
     *
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoopV2(ListNode pHead) {

        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = pHead;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;

    }

    /**
     * HashMap
     *
     * @param pHead
     * @return
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {

        Map<Integer, Object> map = new HashMap<>();

        if (pHead == null || pHead.next == null) {
            return null;
        }

        ListNode p = pHead;
        while (p != null) {
            if (map.containsKey(p.val)) {
                return p;
            }
            map.put(p.val, null);
            p = p.next;

        }
        return null;

    }
}
