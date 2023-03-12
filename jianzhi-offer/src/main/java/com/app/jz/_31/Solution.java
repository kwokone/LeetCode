package com.app.jz._31;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序
 * 输入：
 * [1,2,3,4,5],[4,5,3,2,1]
 * 返回值：
 * true
 */
public class Solution {

    /**
     * 给定两个序列，第一个表示入栈顺序，第二个表示出栈顺序
     * 序列中没有重复的数字
     * 判定第一个入栈顺序能否得到第二个出栈顺序
     *
     * 方法一：辅助栈
     *
     * step1: 准备一个辅助栈。两个下标分别访问两个序列
     * step2: 辅助栈为空或者栈顶不等于出栈数组当前元素，就继续将入栈数组加入到栈中
     * step3: 栈顶等于出栈数组就是当前元素出栈
     * step4： 当入栈数组访问完，出栈数组无法依次弹出，就是不配的，否则两个序列都访问完就是匹配的。
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int[] pushA, int[] popA) {

        int n = pushA.length;

        // 辅助栈
        Stack<Integer> s = new Stack<>();

        // 遍历入栈的下标
        int j = 0;

        // 遍历出栈的数组
        for(int i =0; i<n; i++){
            while (j<n && (s.isEmpty() || s.peek()!=popA[i] )){
                s.push(pushA[j]);
                j++;
            }
            // 栈顶等于出栈数组
            if (s.peek() == popA[i])
                s.pop(); // 依次弹出
            else return false; //不能弹出则说明是不匹配的

        }
        return true;




    }


}
