package com.app.jz._11;

/**
 * 旋转数组的最小数字
 * <p>
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，
 * 比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。请问，给定这样一个旋转数组，求数组中的最小值
 * 输入：
 * [3,4,5,1,2]
 * 返回值：
 * 1
 */
public class Solution {

    /**
     * step 1：双指针指向旋转后数组的首尾，作为区间端点。
     * step 2：若是区间中点值大于区间右界值，则最小的数字一定在中点右边。
     * step 3：若是区间中点值等于区间右界值，则是不容易分辨最小数字在哪半个区间，比如[1,1,1,0,1]，应该逐个缩减右界。
     * step 4：若是区间中点值小于区间右界值，则最小的数字一定在中点左边。
     * step 5：通过调整区间最后即可锁定最小值所在。
     *
     * @param arr
     * @return
     */
    public int minNumberInRotateArray(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            if (arr[mid] > arr[right]) left=mid+1;
            else if (arr[mid] == arr[right])
                // 无法判断，右指针逐步左移
                right --;
            else
                right = mid;
        }

        return arr[left];

    }
}
