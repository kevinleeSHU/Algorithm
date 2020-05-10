package com.liyuwen.sort;

import com.liyuwen.utils.GenerateRandom;

/**
 * 选择排序：从第二个元素开始与前一个元素比较，比前一个小则交换，得到两个元素有序；再看第三个元素，依次与前两个元素比较
 *          直至比较到大于某个元素时停止，再把此元素插入到比它小的元素的后一个位置
 *
 * 时间复杂度：O(n^2)
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：是
 *
 * 适用：顺序存储和链式存储
 *
 * @author Liyuwen
 * @create 2020/4/29 11:41
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = GenerateRandom.getIntArrayFromTxt("D:\\学习\\Java\\Code\\Algorithms\\Sort\\data.txt");

        long start = System.currentTimeMillis();

        sort2(arr);

        long end = System.currentTimeMillis();

        System.out.println("插入排序所用时间为: " + (end - start) + "ms");

        GenerateRandom.saveResultToText("D:\\学习\\Java\\Code\\Algorithms\\Sort\\result.txt", arr);
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
            int temp = arr[i];  // 保存当前i位置元素
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {  // 将i位置元素与i位置之前元素比较
                    arr[j] = arr[j - 1];    // 如果前面有大于i位置的就往后挪
            }
            arr[j] = temp;
        }

    }

}
