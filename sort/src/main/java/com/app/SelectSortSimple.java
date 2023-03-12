package com.app;

import org.junit.Test;

import java.util.Arrays;

/**
 * 选择排序
 * 单路选择排序：不稳定，时间复杂度O(n平方) 空间复杂度O(1)
 * 双路选择排序：https://juejin.cn/post/6868969987860594696
 *
 */
public class SelectSortSimple {

    @Test
    public void test() {
        int[] arr = new int[]{2, 3, 6, 5, 1};
        sortV2(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 双路选择排序
     * 查找最小值的同时，找到一个最大值，然后将两者放在他们应该出现的位置
     * 同时添加哨兵，如果没有找到最值，则不发生交换
     *
     * @param arr
     */
    public static void sortV2(int[] arr) {


        //left指针指向无序边界起点，right指针指向终点，temp用作临时变量交换值
        int left, right, temp;
        //默认指向无序列表起点
        left = 0;
        //默认指向无序列表终点
        right = arr.length - 1;
        //记录每轮找到的最小值的下标
        int min = left;
        //记录每轮找到的最大值的下标
        int max = right;
        //当right >= left时，列表已经有序
        //记录循环的次数
        int index = 0;
        while (left < right) {
            min = left;     //每轮开始前，默认无序列表起点为最小值
            max = right;    //每轮开始前，默认无序列表终点为最大值
            //指针i从左往右扫描，找出最小值，最大值
            for (int i = left; i <= right; i++) {
                if (arr[i] < arr[min]) {
                    min = i;    //通过比较，记录最小值的下标
                }
                if (arr[i] > arr[max]) {
                    max = i;    //通过比较，记录最大值的下标
                }
            }
            index++;
            if (min == left && max == right) {
                System.out.println("第" + index + "轮循环没有找到最值，无需交换");
            } else if (min == right && max == left) {
                //交换一次即可，交换两次的话，序列翻转，相当于没有交换
                temp = arr[left];
                arr[left] = arr[min];
                arr[min] = temp;
            } else {
                //找到最小值，交换
                temp = arr[left];
                arr[left] = arr[min];
                arr[min] = temp;

                //找到最大值，交换
                temp = arr[right];
                arr[right] = arr[max];
                arr[max] = temp;
            }
            //确定最小/大值，指针向中间移动
            left++;
            right--;
        }


    }


    /**
     * 单路选择而排序
     *
     * @param arr
     */
    public static void sort(int[] arr) {

        int len = arr.length;

        for (int i = 0; i < len; i++) {

            // 存储最小值的索引
            int min = i;
            // 从剩下的元素中选择最小值
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            // min这个索引一定对应了当前无序区间中找到的最小值索引
            // 如果最小的数和当前遍历的数的下标不一致，说明下标为min的数比当前遍历的数更小
            if (i != min)
                swap(arr, min, i);

        }


    }

    private static void swap(int[] arr, int i, int j) {

        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];

    }
}
