package com.app.jz._53;

/**
 * 数字在升序数组中出现的次数
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 * <p>
 * 输入：
 * [1,2,3,3,3,3,4,5],3
 * 返回值：
 * 4
 */
public class Solution {

    /**
     * 要查找的并非常规二分法中k出现的位置，而是k出现的左界和k出现的右界。
     * 要是能刚好找到恰好小于k的数字位置和恰好大于k的数字的位置就好了。
     * <p>
     * 再有因为数组中全是整数，因此我们可以考虑，用二分查找找到
     * k+0.5应该出现的位置和
     * k−0.5应该出现的位置，二者相减就是k出现的次数。
     *
     * @param arr
     * @param k
     * @return
     */
    public int GetNumberOfK(int[] arr, int k) {

        return bisearch(arr, k + 0.5) - bisearch(arr, k - 0.5);

    }

    private int bisearch(int[] arr, double k) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (arr[mid] < k) left = mid + 1;
            if (arr[mid] > k) right = mid - 1;

        }

        return left;


    }
}
