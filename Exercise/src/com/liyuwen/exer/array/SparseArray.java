package com.liyuwen.exer.array;

/**
 * 稀疏数组压缩
 *
 * @author Liyuwen
 * @create 2020/4/12 20:00
 */
public class SparseArray {

    public static void main(String[] args) {
        // 被压缩的数组
        int[][] arr = new int[11][11];
        arr[1][2] = 1;
        arr[2][3] = 2;

        SparseArray sparseArray = new SparseArray();
        int[][] sparseArr = sparseArray.sparseArray(arr);

        // 遍历压缩后的数组
        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[0].length; j++) {
                System.out.print(sparseArr[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static int[][] sparseArray(int[][] arr) {

        // 得到非零值总数
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 第一行分别为   行数  列数  非零值个数
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;

        // 第二行开始记录非零值信息，分别为：  所在行  所在列  此非零值
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }
}
