package com.liyuwen.sort1;

import java.util.Arrays;

/**
 * 希尔排序：
 *
 * 增量选取：
 *
 * 最坏情况时间复杂度：O(n^2)
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：否
 *
 * 适用：顺序存储
 *
 * @author Liyuwen
 * @create 2020/4/29 13:34
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr1 = new int[] {4, 6, 0, 3, 9, 2, 1, 19, -3, 13, 34};
        sort(arr1);

        System.out.println(Arrays.toString(arr1));
    }

    public static void sort(int[] arr) {
        for (int d = arr.length / 2; d >= 1; d /= 2) {  // 增量选取为序列长度的一半取下界（）
            for (int p = d; p < arr.length; p++) {
                int temp = arr[p];
                int j;
                for (j = p; j >= d && arr[j - d] > temp; j -= d) {
                    arr[j] = arr[j - d];
                }
                arr[j] = temp;
            }
        }
    }

}
