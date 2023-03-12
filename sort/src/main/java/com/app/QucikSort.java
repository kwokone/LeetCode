package com.app;

import org.junit.Test;

/**
 * 快速排序(不稳定)
 * 时间复杂度： 最坏 O(n平方)
 * 平均复杂度：O(n * logN): 遍历一次需要O(N) 需要遍历O(log(N+1))  (看做完全二叉树,最小深度log(N+1) 最大深度 N)
 *
 * 1. 挖坑法：
 * 2. 左右指针法：
 */
public class QucikSort {

    @Test
    public void testSortV2(){

        int[] arr = new int[]{5,4,6,3,1,2};

        int len = arr.length;
        sortV2(arr,0,len-1);
        for (int i : arr) {
            System.out.print(i+",");
        }
    }

    @Test
    public void testSort(){

        int[] arr = new int[]{5,4,6,3,1,2};

        int len = arr.length;
        sort(arr,0,len-1);
        for (int i : arr) {
            System.out.print(i+",");
        }
    }

    /**
     * 左右指针法
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void sortV2(int[] arr, int low, int high) {

        if (arr == null || arr.length <= 0 || low >= high) return;
        int left = low;
        int right = high;

        int key = arr[left];

        while (left < right) {

            while (left < right && arr[right] >= key) right--;
            while (left < right && arr[left] <= key) left++;

            if (left < right) swap(arr, left, right);
        }
        swap(arr, low, left);

        sortV2(arr, low, left - 1);
        sortV2(arr, left + 1, high);

    }

    public static void swap(int[] arr, int i, int j) {

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }


    /**
     * 挖坑法
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void sort(int arr[], int low, int high) {

        if (arr == null || arr.length <= 0 || (low >= high)) return;

        int left = low;
        int right = high;
        int temp = arr[left]; // 坑1：保存基准的值

        while (left < right) {

            while (left < right && arr[right] >= temp) right--;

            arr[left] = arr[right]; // 坑2：从后向前找比基准小的元素，放入坑1
            while (left < right && arr[left] <= temp) left++;
            arr[right] = arr[left]; // 坑3：从前往后找比基准大的元素，放入坑2

        }
        arr[left] = temp; // 基准值填补到坑3, 准备分治递归快排

        sort(arr, low, left - 1);
        sort(arr, left + 1, high);
    }


}
