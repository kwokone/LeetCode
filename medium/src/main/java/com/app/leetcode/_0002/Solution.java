package com.app.leetcode._0002;

import org.junit.Test;

/**
 * 📆️ 2023/3/10
 * Add Two Number
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * ✅ 直接相加节点上的值，然后判断是否需要进位。
 * ❎ FIXME
 *
 * @author Allen
 * @version 0.0.1
 */


public class Solution {

    @Test
    public void test(){
        ListNode l1 = new ListNode();
        l1.val = 2;
        l1.next= new ListNode(4);
        l1.next.next = new ListNode(3);
        System.out.println(l1);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){

        if(l1 == null && l2 ==null) return null;

        if(l1 == null) l1 = new ListNode(0);
        if (l2 == null) l2 = new ListNode(0);

        int sum = l1.val + l2.val;
        if(sum > 9){
            if(l1.next == null) l1.next = new ListNode(0);
            l1.next.val ++;
            return new ListNode(sum %10, addTwoNumbers(l1.next,l2.next));
        }

        return new ListNode(sum, addTwoNumbers(l1.next, l2.next));

    }

}
