package com.app.leetcode._0092;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 */
public class Solution {

    public boolean containsDuplicate(int[] arr){
        /**
         * add()
         * 已经添加过的元素，返回值为false
         */
        Set<Integer> set = new HashSet<>();

        for (int x : arr) {
            if (!set.add(x)) return true;
        }
        return false;
    }
}
