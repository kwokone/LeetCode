package com.app;

import org.junit.Test;

import java.util.Arrays;

/**
 * 桶排序（用空间换时间的排序）
 * 分好桶后，右侧桶的数比左侧的大，但桶内部还是无序
 *
 * 平均时间复杂度: O(n + k)
 * 最佳时间复杂度: O(n + k)
 * 最差时间复杂度: O(n ^ 2)
 * 空间复杂度: O(n * k)
 * <p>
 * 桶排序最好情况下使用线性时间O(n)，桶排序的时间复杂度，取决与对各个桶之间数据进行排序的时间复杂度，
 * 因为其它部分的时间复杂度都为O(n)。
 * <p>
 * 很显然，桶划分的越小，各个桶之间的数据越少，排序所用的时间也会越少。但相应的空间消耗就会增大。
 */
public class BucketSort {

    @Test
    public void test() {
        int[] arr = new int[]{2, 3, 4, 9};

        sort(arr, 100);

        System.out.println(Arrays.toString(arr));

    }

    /**
     * @param arr 数组arr中数据的范围[0, MAX)
     * @param max 数组最大值得范围 --> 这里指定分桶规则，刚好比数组的元素多一个，这样避免了再对桶内部的数据排序
     * FIXME 这里其实本质使用的是计数排序（每个元素放一个桶） 也可以指定其他分桶规则让每个桶的数据分布得更均匀
     *
     *
     */
    public static void sort(int[] arr, int max) {

        if (arr == null || max < 1) return;
        int[] buckets;

        buckets = new int[max];

        // 1. 计数
        for (int i = 0; i < arr.length; i++) {
            buckets[arr[i]]++; // 表示将a[i]添加到桶中
        }
        // 2. 排序
        for (int i = 0, j = 0; i < max; i++) {

            while ((buckets[i]--) > 0) {
                arr[j++] = i;
            }

        }

        buckets = null;


    }

}
