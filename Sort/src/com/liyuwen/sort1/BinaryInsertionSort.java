package com.liyuwen.sort1;

import java.util.Arrays;

/**
 * 折半插入排序：对当前元素用二分查找的方法向前面排好序的元素序列中插入
 *
 * @author Liyuwen
 * @create 2020/5/5 21:57
 */
public class BinaryInsertionSort {

    public static void main(String[] args) {
        int[] arr1 = new int[] {4, 6, 0, 3, 9, 2, 1, 19, -3, 13, 34};
        sort(arr1);

        System.out.println(Arrays.toString(arr1));
    }

    public static void sort(int[] arr) {

        int low, high, mid;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];  // 保存当前i位置元素

            low = 0; high = i -1;
            mid = (low + high) / 2;
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[mid] > temp) {
                    high = mid - 1;
                } else low = mid + 1;
            }
            // 将 high+1 到 i-1 的元素往后移动
            for (int j = i - 1; j >= high + 1; j--) {
                arr[j + 1] = arr[j];    // 会把arr[i]覆盖掉，所以上面要保存arr[i]
            }
            arr[high + 1] = temp;   // 注意此处插入的位置为 high+1
        }
    }

}
