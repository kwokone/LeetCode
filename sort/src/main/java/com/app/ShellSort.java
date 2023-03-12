package com.app;

import org.junit.Test;

import java.util.Arrays;

/**
 * 希尔排序(不稳定)
 * 时间复杂度：大于O(n平方)
 * 与直接插入排序不同的是，它会优先比较距离较远的元素。直接插入排序是稳定的
 * 时间复杂度与步长的选择有关，常用的是Shell增量排序，也就是N/2的序列
 * Shell增量序列不是最好的增量序列，其他还有Hibard增量序列、Sedgewick增量序列等
 */
public class ShellSort {

    @Test
    public void test() {
        int[] arr = new int[]{3, 2, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        ;
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        for (; gap > 0; gap = gap / 2) {
            // 不断缩小gap,直到1为止
            for (int j = 0; (j + gap) < len; j++) {
                // 使用当前的gap进行组内插入排序
                for (int k = 0; k + gap < len; k += gap) {
                    if (arr[k] > arr[k + gap]) swap(arr, k, k + gap);
                }
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }
}
