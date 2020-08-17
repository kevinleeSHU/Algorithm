package com.liyuwen.sort;

import java.util.Arrays;

/**
 * 基数排序：不好对存在负数的排序，如果有负数，可以将数组划分为一个正数数组和一个负数数组分别排序
 *
 * 平均时间复杂度：O(n*k)  k为桶的个数
 *
 * 最好最坏时间复杂度：O(n*k)  O(n*k)
 *
 * 空间复杂度：O(n+k)
 *
 * 是否稳定：是
 *
 * @author Liyuwen
 * @date 2020/8/1
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {2, 10, 5, 134, 43, 42, 434, 24};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        int[][] bucket = new int[10][arr.length];  // 10个桶，每个桶需要装arr.length个数
        int[] bucketElementsCount = new int[10];    // 每个桶中存在的数

        for (int k = 0, n = 1; k < maxLength(arr); k++, n *= 10) {
            for (int i = 0; i < arr.length; i++) {
                int digitOfElement = arr[i] / n % 10;
                bucket[digitOfElement][bucketElementsCount[digitOfElement]] = arr[i];   // 放到对应桶中
                bucketElementsCount[digitOfElement]++;
            }

            int index = 0;
            // 放回到原数组
            for (int i = 0; i < bucketElementsCount.length; i++) {
                if (bucketElementsCount[i] != 0) {  // 如果桶中有数据
                    for (int j = 0; j < bucketElementsCount[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketElementsCount[i] = 0;     // 清空桶中元素
            }
        }
    }

    /**
     * 返回数字中最大位数
     * @param arr
     * @return
     */
    private static int maxLength(int[] arr) {
        int max = Math.abs(arr[0]);
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > max) {
                max = Math.abs(arr[i]);
            }
        }
        return (max + "").length();
    }
}
