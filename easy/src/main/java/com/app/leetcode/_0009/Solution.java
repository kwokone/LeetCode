package com.app.leetcode._0009;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * 。
 */
public class Solution {

    public boolean isPalindrom(int x) {

        if (x < 0) return false;
        char[] s = String.valueOf(x).toCharArray();
        int right = s.length - 1;
        if (right == 0) return true;
        boolean flag = false;
        for (int i = 0; i < s.length / 2; i++) {
            if (s[i] == s[right]) {
                right = right - 1;
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;


    }
}
