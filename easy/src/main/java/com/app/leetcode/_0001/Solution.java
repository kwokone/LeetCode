package com.app.leetcode._0001;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ðï¸ 2023/3/9
 * è¾å¥ï¼nums = [2,7,11,15], target = 9
 * è¾åºï¼[0,1]
 * è§£éï¼å ä¸º nums[0] + nums[1] == 9 ï¼è¿å [0, 1] ã
 * <p>
 * â TODO
 * â FIXME
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
