package com.liyuwen.search;

/**
 * 插值查找：比较适用于分布均匀的情况
 *  mid = left + (right - left)*(value - arr[left])/(arr[right]-arr[left])
 * @author Liyuwen
 * @create 2020/8/2 15:19
 */
public class InsertValueSearch {
    /**
     *
     * @param arr
     * @param value
     * @param left
     * @param right
     * @return
     */
    public static int search(int[] arr, int value, int left, int right) {
        // 不加value < arr[0] || value > arr[arr.length - 1]可能回产生越界！！！
        if (left > right || value < arr[0] || value > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left)*(value - arr[left])/(arr[right]-arr[left]);
        int midValue = arr[mid];
        if (value > midValue) {
            return search(arr, value, mid + 1, right);
        } else if (value < midValue) {
            return search(arr, value, left, mid - 1);
        } else {
            return mid;
        }
    }
}
