package com.liyuwen.utils;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 * 用于测试排序算法的产生随机数的工具类
 *
 * @author Liyuwen
 * @create 2020/5/8 10:38
 */
public class GenerateRandom {

    /**
     * 在指定文件中生成一定数量的随机数
     * @param pathname 文件地址
     * @param n 随机数数量
     * @param bound 随机数的最大值
     */
    public static void generate(String pathname, int n, int bound) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File(pathname);
            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            Random random = new Random();

            for (int i = 1; i < n + 1; i++) {

                int ranInt = random.nextInt(bound);

                bw.write(ranInt + " ");
                bw.flush();

                if (i % 30 == 0) {
                    bw.newLine();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * 将 txt 文件中的数保存到数组
     * @param pathname 文件地址
     * @return
     */
    public static int[] getIntArrayFromTxt(String pathname) {

        FileReader fr = null;
        BufferedReader br = null;
        int[] arr = new int[0];
        try {
            fr = new FileReader(pathname);
            br = new BufferedReader(fr);

            String line = null;

            String s = "";


            while ((line = br.readLine()) != null) {
                s = s + line;
            }

            String[] data = s.split(" ");

            arr = new int[data.length];

            for (int i = 0; i < data.length; i++) {
                arr[i] = Integer.parseInt(data[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return arr;

    }

    /**
     * 保存结果到 txt 文件中
     * @param pathname 文件地址
     * @param arr 要保存的数组
     */
    public static void saveResultToText(String pathname, int[] arr) {

        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            File file = new File(pathname);

            if (!file.exists()) {
                file.createNewFile();
            }

            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            for (int i = 1; i < arr.length + 1; i++) {
                bw.write(arr[i - 1] + " ");
                bw.flush();

                if (i % 30 == 0) {
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
