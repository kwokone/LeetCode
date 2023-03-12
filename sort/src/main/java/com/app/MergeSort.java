package com.app;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序（稳定的算法）
 * 表现比选择排序好的多，代价是需要额外的内存空间；
 * 时间复杂度：O(N*logN)
 * 自下而上的归并：
 * 将待排序的数列分成若干个长度为1的子数列。
 * 然后将这些数列两两合并，得到若干个长度为2的有序数列，再将这些数列两两合并，得到若干个长度为4的有序数列
 * 直到合并成一个数列为止。
 * <p>
 * 自上而下的归并：
 * 1. 分解: 将当前的区间一分为二，即求分裂点
 * 2. 求解： 递归地对两个子区间进行归并排序，递归的终结条件是子区间长度为1.
 * 3. 合并：将已排序的两个子区间归并为一个有序的区间。
 */
public class MergeSort {

    @Test
    public void test() {
        int[] arr = new int[]{2, 3, 1, 5, 4};

//        mergeSortUp2Down(arr, 0, 4);
        mergeSortDown2Up(arr);
        System.out.println(Arrays.toString(arr));


    }

    /**
     * @param arr
     */
    public static void mergeSortDown2Up(int[] arr) {

        if (arr == null) return;

        for (int n = 1; n < arr.length; n *= 2) {
            mergeGroups(arr, arr.length, n);

        }


    }

    /**
     * 对数组arr做若干次合并: 数组arr的总长度为len，将它分为若干个长度为gap的子数组；
     * 将"每2个相邻的子数组" 进行合并排序。
     *
     * @param arr
     * @param len 数组的长度
     * @param gap 子数组的长度
     */
    private static void mergeGroups(int[] arr, int len, int gap) {

        int i;
        int twolen = 2 * gap;

        // 将每两个相邻的子数组进行合并排序
        for (i = 0; i + twolen - 1 < len; i += twolen) {
            merge(arr, i, i + gap - 1, i + twolen - 1);
        }
        // 若 i+gap-1 < len-1，则剩余一个子数组没有配对。
        // 将该子数组合并到已排序的数组中。
        if (i + gap - 1 < len - 1)
            merge(arr, i, i + gap - 1, len - 1);

    }


    /**
     * 归并排序：从下往上
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSortUp2Down(int[] arr, int start, int end) {

        if (arr == null || start >= end) return;

        int mid = (start + end) / 2;

        mergeSortUp2Down(arr, start, mid);
        mergeSortUp2Down(arr, mid + 1, end);

        // a[start...mid] 和 a[mid...end]是两个有序空间，
        // 将它们排序成一个有序空间a[start...end]

        merge(arr, start, mid, end);

    }

    /**
     * 将一个数组中的两个相邻有序区间合并成一个
     *
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1]; // 汇总两个有序区间的临时区域
        int i = start; // 第一个有序区的索引
        int j = mid + 1; // 第二个有序区的索引
        int k = 0; // 临时区域的索引

        while (i <= mid && j <= end) {

            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];

        }

        while (i <= mid)
            tmp[k++] = arr[i++];
        while (j <= end)
            tmp[k++] = arr[j++];

        // 将排序后的元素，全部都整合到数组arr中
        for (i = 0; i < k; i++) {
            arr[start + i] = tmp[i];
        }
        tmp = null;


    }


}
