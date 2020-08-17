package com.liyuwen.exer.dp;

import java.util.Scanner;

/**
 * ClassName: com.liyuwen.exer.dp.FactorialTest <br/>
 * Description:  <br/>
 * date: 2020/2/26 13:51<br/>
 *
 * @author LiYuwen Email: 2548836183@qq.com
 * @version 1.0
 */
public class FactorialTest {
    public static double lnFactorialOf(int n) {
        if (n == 0 || n == 1) {
            return 0;
        } else {
            return Math.log(n) + lnFactorialOf(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        System.out.println(FactorialTest.lnFactorialOf(input));
    }
}
