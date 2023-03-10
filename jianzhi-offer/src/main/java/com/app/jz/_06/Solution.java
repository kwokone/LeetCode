package com.app.jz._06;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入：
 * {1,2,3}
 * 返回值：
 * [3,2,1]
 */
public class Solution {

    @Test
    public void test(){

    }

    /**
     * 使用栈 先进后出
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHeadV3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode!= null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;

    }
        /**
         * 头插法
         * 修改后继关系，将当前节点插入新链表的头部
         * @param listNode
         * @return
         */
    public ArrayList<Integer> printListFromTailToHeadV2(ListNode listNode){

        ListNode head = new ListNode(-1);// 辅助节点
        while (listNode!=null){
            ListNode tmp = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = tmp;
        }
        ArrayList<Integer> res = new ArrayList<>();
         head = head.next;
         while (head!=null){
             res.add(head.val);
             head = head.next;
         }
         return res;


    }
    /**
     * 递归
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){

        ArrayList<Integer> res = new ArrayList<>();
        if (listNode !=null){
            res.addAll(printListFromTailToHead(listNode.next));
            res.add(listNode.val);
        }
        return res;



    }
}
