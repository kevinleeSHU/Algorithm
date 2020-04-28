package com.liyuwen.sort1;

import java.util.Arrays;

/**
 * @author Liyuwen
 * @create 2020/4/28 16:31
 */
public class SelectSort {

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
