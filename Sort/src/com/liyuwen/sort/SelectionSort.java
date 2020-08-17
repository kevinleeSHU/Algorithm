package com.liyuwen.sort;

import com.liyuwen.utils.GenerateRandom;

import java.util.Arrays;

/**
 * 选择排序：
 *
 * 时间复杂度：O(n^2)  时间复杂度与初始序列无关
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：否
 *
 * 适用范围：顺序存储
 *
 * @author Liyuwen
 * @create 2020/4/28 16:31
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = GenerateRandom.getIntArrayFromTxt("D:\\学习\\Java\\Code\\Algorithms\\Sort\\data.txt");

        long start = System.currentTimeMillis();

        sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("选择排序所用时间为: " + (end - start) + "ms");

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
