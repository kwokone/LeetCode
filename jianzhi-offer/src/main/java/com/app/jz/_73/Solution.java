package com.app.jz._73;

import java.util.Stack;

/**
 * 翻转单词序列
 *
 * step 1：遍历字符串，将整个字符串按照空格分割然后入栈。
 * step 2：遍历栈，将栈中内容弹出拼接成字符串。
 *
 */
public class Solution {

    public String ReverseSentence(String str){

        Stack<String> s = new Stack<>();
        String[] arr = str.split(" ");

        // 单词加入栈
        for(int i=0;i<arr.length;i++){
            s.push(arr[i]);
            s.push(" ");
        }
        StringBuilder res = new StringBuilder();

        // 去掉栈的最后一个空格
        if (!s.isEmpty()){
            s.pop();
        }
        // 栈遵循先进后出
        while (!s.isEmpty()){

            res.append(s.pop());

        }

        return res.toString();


    }
}
