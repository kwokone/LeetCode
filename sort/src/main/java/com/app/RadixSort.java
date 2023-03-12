package com.app;

import org.junit.Test;

import java.util.Arrays;

/**
 * 基数排序 （稳定，没有比较操作）
 * 时间复杂度：O(d*(n+r))
 * 空间复杂度：O(n+r)
 * d -- 位数
 * r -- 基数
 * 基数排序 vs 计数排序 vs 桶排序
 * 基数排序：根据键值的每位数字来分配桶
 * 计数排序：每个桶只存储单一键值
 * 桶排序：每个桶存储一定范围的数值
 */
public class RadixSort {

    @Test
    public void test() {

        int[] arr = new int[]{2, 3, 5, 4, 8, 7};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        int exp; //指数， 个位 exp=1 十位 exp=10
        int max = getMax(arr); //数组arr中的最大值

        // 从个位开始，对数组按照"指数"进行排序
        for (exp = 1; max / exp > 0; exp *= 10) {

            countSort(arr, exp);

        }


    }

    /**
     * 对数组按照"某个位数"进行排序(桶排序)
     * <p>
     * 参数说明:
     * a -- 数组
     * exp -- 指数。对数组a按照该指数进行排序。
     * <p>
     * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
     * (01) 当exp=1表示按照"个位"对数组a进行排序
     * (02) 当exp=10表示按照"十位"对数组a进行排序
     * (03) 当exp=100表示按照"百位"对数组a进行排序
     * ...
     *
     * @param arr
     * @param exp
     */
    private static void countSort(int[] arr, int exp) {

        int[] output = new int[arr.length]; // 存储"被排序数组"的临时数组
        int[] buckets = new int[10];

        // 将数据出现的次数存储在buckets[]中
        for (int i = 0; i < arr.length; i++)
            buckets[(arr[i] / exp) % 10]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
        for (int i = 1; i < 10; i++)
            buckets[i] += buckets[i - 1];

        // 将数据存储到临时数组output[]中
        for (int i = arr.length - 1; i >= 0; i--) {
            output[buckets[(arr[i] / exp) % 10] - 1] = arr[i];
            buckets[(arr[i] / exp) % 10]--;
        }

        // 将排序好的数据赋值给a[]
        for (int i = 0; i < arr.length; i++)
            arr[i] = output[i];

        output = null;
        buckets = null;


    }

    private static int getMax(int[] arr) {

        int max;
        max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;


    }


}
