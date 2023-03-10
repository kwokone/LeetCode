package com.app.leetcode._0003;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 📆️ 2023/3/10
 * 无重复字符的最长子串
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * ✅ TODO
 * ❎ FIXME
 *
 * @author Allen
 * @version 0.0.1
 */
@Slf4j
public class Solution {

    @Test
    public void test(){
        int res = new Solution().lengthOfLongestSubString("abcdab");
        log.info("res --> "+ res);

    }

    public  int lengthOfLongestSubString(String s){

        if(s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();

        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++){

            if(map.containsKey(s.charAt(i))){

                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-left+1);

        }

        return max;

    }

}
