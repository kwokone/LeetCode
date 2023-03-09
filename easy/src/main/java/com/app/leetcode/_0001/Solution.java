package com.app.leetcode._0001;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 📆️ 2023/3/9
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
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

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] twoSum = new Solution().twoSum(nums, target);
        log.info("twoSum -> "+ twoSum);
       for (int e : twoSum){
           System.out.print(e +"\t");
       }


    }

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]),i};
            }else{
                map.put(nums[i],i);
            }


        }

        return result;

    }
}
