package com.liyuwen.sort;

import java.util.Arrays;

/**
 * 堆排序:
 *
 * 时间复杂度：O(nlog2(n))
 *
 * 空间复杂度：O(1)
 *
 * 是否稳定：否
 *
 * 适用范围：顺序存储 （链式存储也可）
 *
 * @author Liyuwen
 * @create 2020/5/6 20:12
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr1 = new int[] {0, 4, -6, 8, 13, 3, 9, 3, 2, 1, 6, 19, -3, 13, 34};

        sort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void heapify(int[] arr, int currentRootNode, int len) {
        if (currentRootNode < len) {
            // 左子树和右子树位置
            int left = 2 * currentRootNode + 1;
            int right = 2 * currentRootNode + 2;

            int max = currentRootNode;  // 最大元素的位置，先初始化为根结点位置

            // 找到根节点和左右孩子中最大元素的下标
            if (left < len) {
                if (arr[max] < arr[left]) {
                    max = left;
                }
            }
            if (right < len) {
                if (arr[max] < arr[right]) {
                    max = right;
                }
            }
            // 最大值不是根结点就交换，使根结点值最大
            if (max != currentRootNode) {
                swap(arr, max, currentRootNode);
            }
        }
    }

    private static void maxHeapify(int[] arr, int len) {
        for (int i = len - 1; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            maxHeapify(arr, arr.length - i);    // 每次建堆最大元素都在完全二叉树根结点，也是数组下标为 0 的位置
            swap(arr, 0, arr.length-1 - i);     // 将最大元素与数组最后一个元素交换
                                                        // 然后继续循环对除了交换后的最后一个位置（最大元素）建堆
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
