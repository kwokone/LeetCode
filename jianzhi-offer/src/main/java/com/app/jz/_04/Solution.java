package com.app.jz._04;

/**
 * 二维数组中的查找
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * <p>
 * 输入：
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值：
 * true
 * 说明：
 * 存在7，返回true
 */
public class Solution {

    /**
     * 矩阵的行元素和列元素都是有序的，从左到右递增，从上到下递增，完全递增元素不会有重复
     * 找到矩阵中有没有给定元素即可
     * <p>
     * 左下元素大于它上方的元素，小于它右方的元素，右上元素与之相反。
     * 既然左下角元素有这么一种规律，相当于将要查找的部分分成了一个大区间和小区间，
     * 每次与左下角元素比较，我们就知道目标值应该在哪部分中，于是可以利用分治思维来做。
     * <p>
     * 1 2 5 9
     * 3 6 7 11
     * 4 8 10 12
     * <p>
     * target = 7
     *
     * @param target
     * @param arr
     * @return
     */
    public boolean Find(int target, int[][] arr) {

        if (arr.length == 0) return false;

        int n = arr.length; // n行
        int m = arr[0].length; // m列
        if (m == 0) return false;

        // 从最左下角的元素开始

        for (int i = n - 1, j = 0; i >= 0 && j < m; ) {

            if (arr[i][j] > target) i--; //
            else if (arr[i][j] < target) j++;
            else return true; // 不需要移动元素，说明存在这个值
        }

        return false;

    }
}
