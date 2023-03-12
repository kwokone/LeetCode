package com.app;

import org.junit.Test;

/**
 * 冒泡排序
 * 效率：稳定
 * 时间复杂度：O(n平方)
 * 空间复杂度：O(1) 因为只需要缓存temp变量s
 */
public class BubbleSort {


    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int len = arr.length;

        //外层
        for (int i = 0; i < len - 1; i++) {
            // 内层
            for (int j = 0; j < len - 1 - i; j++) {
                // 大的值在右侧
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);

            }

        }


    }

    /**
     * 临时变量法交换位置
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    /**
     * 算术法交换位置（有可能溢出）
     *
     * @param arr
     * @param i
     * @param j
     */
    private static void swapV2(int[] arr, int i, int j) {

        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];

    }

    @Test
    public void testSwapV2() {

        int[] arr = {9, 5};
        swapV2(arr, 0, 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }

    }

    /**
     * 位运算法交换位置
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swapV3(int[] arr, int i, int j) {

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    @Test
    public void testSwapV3() {

        int[] arr = {9, 5};
        swapV3(arr, 0, 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }

    }

}
