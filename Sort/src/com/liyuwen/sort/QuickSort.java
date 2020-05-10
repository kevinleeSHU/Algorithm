package com.liyuwen.sort;

import com.liyuwen.utils.GenerateRandom;

/**
 * 快速排序：
 *
 * 最好情况时间复杂度：O(nlog2(n))
 *
 * 平均时间复杂度：O(nlog2(n))
 *
 * 最坏情况时间复杂度：O(n^2)  逆序时退化为冒泡排序
 *
 * 最好、平均空间复杂度：O(log2(n))
 *
 * 最坏情况空间复杂度：O(n)
 *
 * 是否稳定：否
 *
 * 适用范围：顺序存储
 *
 *
 * @author Liyuwen
 * @create 2020/5/5 21:59
 */
public class QuickSort {

    public static void main(String[] args) {

        GenerateRandom.generate("D:\\学习\\Java\\Code\\Algorithms\\Sort\\data.txt", 100000, 10000);

        int[] arr = GenerateRandom.getIntArrayFromTxt("D:\\学习\\Java\\Code\\Algorithms\\Sort\\data.txt");

        long start = System.currentTimeMillis();

        sort(arr, 0, arr.length - 1);

        long end = System.currentTimeMillis();

        System.out.println("快速排序所用时间为: " + (end - start) + "ms");

        GenerateRandom.saveResultToText("D:\\学习\\Java\\Code\\Algorithms\\Sort\\result.txt", arr);
    }

    public static void sort(int[] arr, int left, int right) {
        int l = left, h = right;
        int pivot = l;      // 选择第一个元素为 pivot（选择不同的 pivot，代码可能不一样）

        while (l < h) {
            while (arr[h] >= arr[pivot] && l < h) {
                h--;
            }
            while (arr[l] <= arr[pivot] && l < h) {
                l++;
            }

            if (l < h) {
                swap(arr, l, h);
            }
        }

        swap(arr, l, pivot);

        if (l > left) sort(arr, left, l - 1);
        if (h < right) sort(arr, l + 1, right);

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
