package com.liyuwen.sort;

import com.liyuwen.utils.GenerateRandom;

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
        int[] arr = GenerateRandom.getIntArrayFromTxt("D:\\学习\\Java\\Code\\Algorithms\\Sort\\data.txt");

        long start = System.currentTimeMillis();

        sort(arr);

        long end = System.currentTimeMillis();

        System.out.println("希尔排序所用时间为: " + (end - start) + "ms");
        GenerateRandom.saveResultToTxt("D:\\学习\\Java\\Code\\Algorithms\\Sort\\result.txt", arr);
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
