package com.app.leetcode._0005;

import org.junit.Test;

/**
 * 📆️ 2023/3/10
 * 最长回文子串
 * ✅ 动态规划是为了减少重复计算的问题
 * 动态规划的关键是找到初始状态和状态转移方程
 * ❎ FIXME
 *
 * @author Allen
 * @version 0.0.1
 */
public class Solution {

    @Test
    public void test() {
        String s = "1dabad2";
        String res = new Solution().longestPalindrome(s);
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        int len = s.length(); // 字符串的长度
        int maxStart = 0; // 最长回文串的起点
        int maxEnd = 0; // ..终点
        int maxLen = 1; // ..长度

        boolean[][] dp = new boolean[len][len];
        /**
         * 左指针右移 右指针左移 （左 <= 右）
         * 矩阵 行表示右指针 列表示左指针
         * true 表示是回文字符串
         */

        for (int r = 1; r < len; r++) {

            for (int l = 0; l < r; l++) {
                /**
                 * 右指针和左指针始终执行同样的字符（前提）
                 * 如果索引相差=2，证明中间只有一个字符，true
                 * 索引差=1或0，表示执行同样的两个或则一个字符，true
                 *
                 * 或者左右指针能继续移动，表明仍然是true
                 *
                 * 每次移动后，更新最大回文字符串的长度，起始位置和结束位置
                 *
                 */
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;

                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }

        return s.substring(maxStart, maxEnd + 1);
    }
}
