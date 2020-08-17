package com.liyuwen.sort;

import java.util.Arrays;

/**
 * 归并排序：分治思想，
 *
 * 是否稳定：是
 *
 * 平均时间复杂度：O(nlogn)
 *
 * 最坏最好时间复杂度：O(nlogn)  O(nlogn)
 *
 * 空间复杂度：O(n)
 *
 * 适用：外排序
 *
 * @author Liyuwen
 * @create 2020/5/7 9:58
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {13, 5, 2, 9, 5, -1,  8, 10};
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr, left, mid, temp);
            sort(arr, mid + 1, right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * @param arr 排序数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;       // 左边有序序列的初始索引
        int j = mid + 1;    //  右边有序序列的初始索引
        int t = 0;          // temp数组的当前索引

        // 1. 把左右两边有序的数据按照规则填充到temp数组，直到左右两边的有序序列有一边处理完为止
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // 2. 有一边有剩余元素，就把剩余元素依次填充到temp中
        while (i <= mid) {      // 左边有剩余
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j <= right) {    // 右边有剩余
            temp[t] = arr[j];
            t++;
            j++;
        }

        // 3. 将temp数组拷贝到arr（不是每次都拷贝所有），tempLeft为子数组的遍历索引
        t = 0;
        for (int tempLeft = left; tempLeft <= right; tempLeft++) {
            arr[tempLeft] = temp[t];
            System.out.println(Arrays.toString(temp));
            t++;
        }
    }
}
