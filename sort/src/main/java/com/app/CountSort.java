package com.app;

import org.junit.Test;

import java.util.Arrays;

/**
 * 计数排序
 * 它的核心思想在于将输入的数据值转化为键存储在额外开辟的数组空间中。
 * 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数，
 * 主要是因为需要开一个长度为 maxValue-minValue+1 的数组
 * <p>
 * 计数排序本质上是一种特殊的桶排序，当桶的个数最大的时候，就是计数排序
 */
public class CountSort {

    @Test
    public void test() {

        int[] arr = new int[]{2, 1, 3, 6, 5, 4};
        sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        int min = arr[0];
        int max = arr[0];
        // 1. 求出待排序数组的最大值和最小值
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        //  2.实例化辅助数组，记录每个元素出现的次数
        int[] buckets = new int[max - min + 1];

        // 3. 计算arr中的每个元素 在辅助数组中的位置
        for (int i = 0; i < arr.length; i++) {
            buckets[arr[i] - min]++;
        }

        // 4. 根据辅助数组求排序后的数组
//        int index = 0;
//        for (int i = 0; i < buckets.length; i++) {
//
//            while (buckets[i]-- > 0) {
//                arr[index++] = i + min;
//            }
//
//        }
        for (int i = 0, j = 0; i < buckets.length; i++) {

            while (buckets[i]-- > 0) {
                arr[j++] = i + min;
            }

        }

        return arr;

    }
}
