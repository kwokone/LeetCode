package com.app;

import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序（不稳定）
 * 时间复杂度： O(N*logN) 遍历次数介于log(N+1)与log2N之间
 * https://pdai.tech/md/algorithm/alg-sort-x-heap.html
 */
public class SelectSortHeap {

    @Test
    public void test() {

        int[] arr = new int[]{1, 3, 2, 6, 5, 4};
        sortAsc(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 堆排序，从小到大
     *
     * @param arr
     */
    public static void sortAsc(int[] arr) {

        int len = arr.length;
        // 从（n/2 -1）--> 0逐次遍历
        for (int i = len / 2 - 1; i >= 0; i--) maxHeapDown(arr, i, len - 1);
        // 从最后一个元素开始堆序列进行调整，不断缩小范围直到第一个元素
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i); // 交换a[0] a[i],交换后，a[i]是a[0...i]中最大的
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆
            maxHeapDown(arr, 0, i - 1);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }


    /**
     * 最大堆得向下调整算法
     * <p>
     * 注: 数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     * 其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void maxHeapDown(int[] arr, int start, int end) {

        int c = start; //当前（current）节点的位置
        int l = 2 * c + 1; // 左(left)孩子的位置
        int tmp = arr[c]; // 当前节点的大小(数值)

        for (; l <= end; c = l, l = 2 * l + 1) {
            // l是左孩子 l+1是右孩子
            if (l < end && arr[l] < arr[l + 1]) l++; // 左右孩子中选择较大者
            if (tmp >= arr[l]) break;
            else {
                arr[c] = arr[l];
                arr[l] = tmp;
            }


        }


    }


}
