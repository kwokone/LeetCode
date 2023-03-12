package com.app.jz._59;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * 滑动窗口的最大值
 * 给定一个长度为 n 的数组 num 和滑动窗口的大小 size ，找出所有滑动窗口里数值的最大值
 * <p>
 * 输入：
 * [2,3,4,2,6,2,5,1],3
 * 返回值：
 * [4,4,6,6,6,5]
 */
public class Solution {

    /**
     * 要寻找每个滑动窗口的最大值，每次只滑一位
     * size等于0或者大于数组长度，都返回空值
     * <p>
     * 双向队列
     * <p>
     * step 1：维护一个双向队列，用来存储数列的下标。
     * step 2：首先检查窗口大小与数组大小。
     * step 3：先遍历第一个窗口，如果即将进入队列的下标的值大于队列后方的值，依次将小于的值拿出来去掉，再加入，保证队列是递增序。
     * step 4：遍历后续窗口，每次取出队首就是最大值，如果某个下标已经过了窗口，则从队列前方将其弹出。
     * step 5：对于之后的窗口，重复step 3，直到数组结束。
     *
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> ret = new ArrayList<>();

        // 窗口大于数组长度的时候，返回空
        if (size <= num.length && size != 0) {

            // 双向队列
            Deque<Integer> dq = new ArrayDeque<>();

            // 先遍历一个窗口
            for (int i = 0; i < size; i++) {
                // 去掉比自己先进队列的小于自己的值
                while (!dq.isEmpty() && num[dq.peekLast()] < num[i]) {
                    dq.pollLast();
                }
                dq.add(i);
            }
            // 遍历后序数组的元素
            for (int i = size; i < num.length; i++) {

                // 取出窗口内的最大值
                ret.add(num[dq.peekFirst()]);
                while (!dq.isEmpty() && dq.peekFirst() < i - size + 1) {
                    // 弹出窗口后走的值
                    dq.pollFirst();
                }
                // 加入新值之前，去掉比自己先进队列的小于自己的值
                while (!dq.isEmpty() && num[dq.peekLast()] < num[i]) {
                    dq.pollLast();
                }
                dq.add(i);

            }

            ret.add(num[dq.pollFirst()]);


        }
        return ret;

    }


    /**
     * 最大堆方法
     *
     */

    public ArrayList<Integer> maxInWindowsV2(int[] num, int size){

        ArrayList<Integer> ret = new ArrayList<>();

        if (size > num.length || size < 1) return ret;

        // 构建最大堆，即堆顶元素是堆的最大值
        PriorityQueue<Integer> heap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for(int i=0;i<size;i++) heap.add(num[i]);

        ret.add(heap.peek());

        for (int i=1;i+size -1 <num.length; i++){
            heap.remove(num[i-1]);
            heap.add(num[i+size-1]);
            ret.add(heap.peek());

        }

        return ret;



    }



}
