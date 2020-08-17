package com.liyuwen.tree;

/**
 * 完全二叉树的顺序存储
 *   1. 第 n 个结点的左孩子为 2*n + 1
 *   2. 第 n 个结点的右孩子为 2*n + 2
 *   3. 第 n 个结点的双亲结点为 (n-1) / 2
 *
 *         1
 *        / \
 *      /    \
 *     2      3
 *    / \    / \
 *   4   5  6   7
 *
 *  [1, 2, 3, 4, 5, 6, 7]
 *
 * @author Liyuwen
 * @create 2020/8/4 22:02
 */
public class ArrayBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree tree = new ArrayBinaryTree(arr);
        tree.postOrder(0);
    }
}

class ArrayBinaryTree {
    private int[] arr;  // 存储结点的数组

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder() {
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.print(arr[index] + " ");

        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }

        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    public void inOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }

        if ((index * 2 + 1) < arr.length) {
            inOrder(index * 2 + 1);
        }

        System.out.print(arr[index] + " ");

        if ((index * 2 + 2) < arr.length) {
            inOrder(index * 2 + 2);
        }
    }

    public void postOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
            return;
        }

        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }

        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }

        System.out.print(arr[index] + " ");
    }
}