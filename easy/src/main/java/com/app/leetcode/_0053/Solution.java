package com.app.leetcode._0053;

/**
 * 最大子数组之和
 */
public class Solution {

    /**
     * 动态规划
     * <p>
     * 「状态定义」「状态转移方程」「初始化」「输出」「是否可以空间优化」
     * <p>
     * 状态转移方程： dp[i]=max{nums[i],dp[i−1]+nums[i]}
     * 1. dp[i - 1] > 0  dp[i] = dp[i - 1] + nums[i]
     * 2. dp[i - 1] <= 0 dp[i] = nums[i]
     * <p>
     * <p>
     * <p>
     * 动态规划的思想通过解决了一个一个简单的问题，
     * 进而把简单的问题的解组成了复杂的问题的解。
     * <p>
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int len = nums.length;
        // dp[i] 表示以Nums[i]结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {

            if (dp[i - 1] > 0) dp[i] = dp[i - 1] + nums[i];
            else dp[i] = nums[i];
        }
        int res = dp[0];
        for (int i = 1; i < len; i++) {

            res = Math.max(res, dp[i]);

        }
        return res;

    }

    /**
     * 动态规划v2
     *
     * @param nums
     * @return
     */
    public int v2(int[] nums) {
        int pre = 0;
        int res = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }

    /**
     * 分治法
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;
        return max3(
                maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right)
        );
    }

    /**
     * 方法二：分治法 求左右区间中值的最大和
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {

        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid;  i>=left; i--) {
            int num = nums[i];
            sum += nums[i];
            if (sum > leftSum) leftSum =sum;
        }

        sum =0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid+1; i <= right; i++) {
            if (sum > rightSum) rightSum = sum;

        }
        return leftSum + rightSum;


    }

    private int max3(int x, int y, int z) {

        return Math.max(x, Math.max(y, z));
    }


}
