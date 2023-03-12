package com.app;

import org.junit.Test;

/**
 * 直接插入排序（稳定）
 * 移位法：
 * 时间复杂度：O(n平方)
 * 如果一个列表中大部分分是已经排序的，那么用插入排序就可以获取到惊人的O(n),这是很多算法都难以企及的。
 * 在一些标准库中，插入算法也是快速排序的替补，足见其在特定场景下的用处。
 */
public class DirectInsertSort {

    @Test
    public void test() {
        int[] arr = new int[]{5,4,3};

        sort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }

    }




    /**
     * 移位法
     *
     * @param arr
     */
    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int j = i - 1;

            int temp = arr[i]; // 取出待插入数据保存

            while (j >= 0 && arr[j] > temp) {
                // 比插入的数大，则后移
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp; // 找到比待插入数据小的位置，将待插入数据插入


        }


    }
}
