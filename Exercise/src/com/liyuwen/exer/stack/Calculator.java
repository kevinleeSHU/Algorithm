package com.liyuwen.exer.stack;

/**
 *
 * @author Liyuwen
 * @create 2020/7/26 15:58
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "770+2*6-4";
        int result = calculateResult(expression);
        System.out.println(result);
    }

    /**
     * 传入表达式字符串，计算结果
     * @param expression
     * @return
     */
    public static int calculateResult(String expression) {
        // 两个栈来保存数字和运算符
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";    // 用于拼接多位数

        while (true) {
            ch = expression.substring(index, index + 1).charAt(0);  // 遍历每个字符

            // 判断ch是否为运算符
            if (isOperator(ch)) {   // ch是运算符的情况
                if (!operStack.isEmpty()) {     // 运算符栈为空的情况
                    if (getPriority(ch) <= getPriority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = calculateTowNums(num1, num2, oper);

                        numStack.push(res); // 把运算结果入数栈

                        operStack.push(ch); // 把当前操作符入符号栈
                    } else {
                        operStack.push(ch);
                    }
                } else {    // 运算符栈为空的情况
                    operStack.push(ch);
                }
            } else {    // ch是数字的情况
                // 不能发现当前符号是一个数字就立即入栈，需要判断后面的数字是不是数字
                keepNum += ch;

                if (index == expression.length() - 1) { // 如果ch是最后一位，则直接入栈
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 当前字符的下一个字符如果是运算符，则入栈；如果既不是最后一位也不是运算符，跳到index++
                    if (isOperator(expression.substring(index + 1, index + 2).charAt(0))) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";   // 清空
                    }
                }
            }

            index++;

            if (index >= expression.length()) {
                break;
            }
        }

        // 当扫描表达式完毕，就顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true) {
            // 如果符号栈为空，则数栈中只有一个数字，即为计算结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = calculateTowNums(num1, num2, oper);
            numStack.push(res);
        }

        return numStack.pop();
    }

    /**
     * 返回运算符的优先级
     * @param oper 操作符
     * @return
     */
    private static int getPriority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断字符是否是运算符
     * @param ch
     * @return
     */
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int calculateTowNums(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}
