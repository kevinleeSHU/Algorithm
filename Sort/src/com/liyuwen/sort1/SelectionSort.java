package com.liyuwen.sort1;

import java.util.Arrays;

/**
 * 选择排序：
 *
 * 时间复杂度：O(n^2)  时间复杂度与初始序列无关
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：否
 *
 * 适用范围：顺序存储
 *
 * @author Liyuwen
 * @create 2020/4/28 16:31
 */
public class SelectionSort {

    public static void main(String[] args) {
        // 测试
        int[] arr = new int[] {3, 5, 6, 2, 20, 12, 9};

        sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int minIndex = i;   // 最小元素的下标
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // 交换当前值和最小值
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;

        }

    }

}
