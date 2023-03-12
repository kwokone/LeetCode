package com.app.jz._09;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 使用n个元素来完成 n 次在队列尾部插入整数(push)和n次在队列头部删除整数(pop)的功能
 * 输入：
 * ["PSH1","PSH2","POP","POP"]
 * 返回值：
 * 1,2
 * 说明：
 * "PSH1":代表将1插入队列尾部
 * "PSH2":代表将2插入队列尾部
 * "POP“:代表删除一个元素，先进先出=>返回1
 * "POP“:代表删除一个元素，先进先出=>返回2
 */
public class Solution {
    Stack stack1 = new Stack<Integer>();
    Stack stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        // 将第一个栈的内容弹出放入第二个栈
        while (!stack1.isEmpty()) stack2.push(stack1.pop());

        // 第二个栈栈顶就是最先进来的元素，作为队首
        int res = (int) stack2.pop();
        // 再将第二个栈的元素放回第一个栈
        while (!stack2.isEmpty()) stack1.push(stack2.pop());

        return res;


    }
}
