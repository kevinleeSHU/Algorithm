package com.liyuwen.exer.recursion;

/**
 * @author Liyuwen
 * @create 2020/7/31 19:55
 */
public class EightQueens {

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.check(0);
        System.out.println("一共有" + count + "种解法");
    }


    private static final int MAX = 8;   // 一个有MAX个皇后

    int[] arr = new int[MAX];   // 数组保存皇后位置，如arr = {0, 4, 7, 5, 2, 6, 1, 3}，数组下标为行号，值为列号
    static int count = 0;       // 解法的个数

    /**
     * 放置第 n 个皇后
     * @param n
     */
    private void check(int n) {
        if (n == MAX) {
            printLocation();
            return;
        }

        for (int i = 0; i < MAX; i++) { // 依次放入皇后，并判断是否冲突
            arr[n] = i;                 // 尝试把第 n 个皇后从第0列开始摆放

            if (judge(n)) {             // 不冲突，则摆放下一个
                check(n + 1);
            }
            // 冲突则 i++，尝试摆放到下一列
        }
    }

    /**
     * 查看当放置第 n 个皇后，就检查该皇后是否和之前的冲突
     * @param n
     * @return
     */
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            // 检查第 n 个是否和之前的在同一列或同一斜线
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[n] - arr[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * 输出摆放的位置
     */
    private void printLocation() {
        count++;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
