package com.liyuwen.sort1;

import java.util.Arrays;

/**
 * @author Liyuwen
 * @create 2020/4/29 11:41
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr1 = new int[] {4, 6, 0, 3, 9, 2, 1};
        int[] arr2 = new int[] {4, 6, 0, 3, 9, 2, 1};
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));

        sort2(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void sort1(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }

    // 改进后的排序
    public static void sort2(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                    arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }

    }

}
