package com.liyuwen.sort1;

import java.util.Arrays;

/**
 * 冒泡排序：从第二个元素开始，跟前一个元素比较，若比前一个元素小则交换位置，所有元素两两比较之后会找出一个最大值放到最后。
 *          下一轮在除最后一个元素（即最大元素）以外的元素中再找出最大值放到最后。
 *
 * 改进后的最好情况时间复杂度：O(n)
 *
 * 最坏情况时间复杂度：O(n^2)
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：是
 *
 * 适用范围：顺序存储、链式存储
 *
 * @author Liyuwen
 * @create 2020/5/5 21:43
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr1 = new int[] {4, 6, 0, 3, 9, 2, 1};
        int[] arr2 = new int[] {4, 6, 0, 3, 9, 2, 1};
        sort(arr1);
        sort1(arr2);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j -1);
                }

            }

        }

    }

    /**
     * 利用 flag 改进的冒泡排序
     * @param arr
     */
    public static void sort1(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            boolean flag = false;

            for (int j = 1; j < arr.length - i; j++) {

                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j -1 );
                    flag = true;    // 如果有逆序的元素，则将 flag 设为 true
                }
            }

            if (flag == false) {    // 如果当前循环 flag 为 false，则说明没有元素交换，即已经排好序
                return;
            }

        }

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
