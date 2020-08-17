package com.liyuwen.leetcode;

/**
 * 字符串相加
 * @author Liyuwen
 * @create 2020/8/3 10:25
 */
public class LeetCode415 {
    public static void main(String[] args) {
        String s = addStrings("11983", "539");
        System.out.println(s);
    }

    public static String addStrings(String num1, String num2) {
        int maxLength;
        String[] arr1;
        String[] arr2;
        String res = "";

        if (num1.length() >= num2.length()) {
        } else {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        maxLength = num1.length();
        arr1 = new String[maxLength + 1];
        arr2 = new String[maxLength + 1];

        for (int i = 1; i < arr1.length; i++) {
            arr1[i] = String.valueOf(num1.charAt(i - 1));
        }
        arr1[0] = "0";

        for (int i = 0; i < arr2.length - num2.length(); i++) {
            arr2[i] = "0";
        }

        for (int i = arr2.length - 1; i >= arr2.length - num2.length(); i--) {
            arr2[i] = String.valueOf(num2.charAt(i - (arr2.length - num2.length())));
        }

        System.out.println(arr1);
        System.out.println(arr2);

        for (int j = arr1.length - 1; j > 0; j--) {
            int sum = Integer.parseInt(String.valueOf(arr1[j]))
                    + Integer.parseInt(String.valueOf(arr2[j]));
            if (sum < 10) {
                arr1[j] = Integer.toString(sum);
            } else {
                arr1[j] = String.valueOf(sum % 10);
                arr1[j - 1] = String.valueOf(Integer.parseInt(arr1[j - 1]) + 1);
            }
        }
        if (arr1[0] == "0") {
            for (int i = 1; i < arr1.length; i++) {
                res += arr1[i];
            }
        } else {
            for (int i = 0; i < arr1.length; i++) {
                res += arr1[i];
            }
        }
        return res;
    }
}
