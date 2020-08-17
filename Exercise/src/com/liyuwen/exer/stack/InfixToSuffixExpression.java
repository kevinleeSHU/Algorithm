package com.liyuwen.exer.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 中缀表达式转后缀表达式
 * 1. 初始化两个栈：运算符栈s1和存放中间结果的栈s2
 * 2. 从左至右扫描中缀表达式
 * 3. 遇到数，将其压入s2
 * 4. 遇到运算符，比较其与s1栈顶运算符的优先级：
 *      （1）若s1为空，或栈顶运算符为左括号"("，则直接将此运算符入栈
 *      （2）否则，若优先级比栈顶运算符高，将运算符压入s1
 *      （3）否则，将s1栈顶运算符弹出并压入s2，跳转回（1）
 * 5. 遇到括号时：
 *      （1）若是左括号"("，则直接压入s1
 *      （2）若是右括号")"，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
 * 6. 重复 2~5，直到表达式的最右边
 * 7. 将s1中剩余的运算符一次弹出并压入栈
 * 8. 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
 * @author Liyuwen
 * @create 2020/7/27 20:36
 */
public class InfixToSuffixExpression {
    public static void main(String[] args) {
        String expression = "10+((2+3)*4)-5";
        List<String> list = strToInfixExpressionList(expression);
        System.out.println(list);

    }

    public String convert(String expression) {
        // 1. 将expression转换为List
        
        return "";
    }

    private static List<String> strToInfixExpressionList(String expression) {
        List<String> list = new ArrayList();
        int index = 0;
        String str; // 对多位数的拼接
        char c;

        do {
            if ((c = expression.charAt(index)) < 48 || (c = expression.charAt(index)) > 57) {   // 如果c不是数字
                list.add("" + c);
                index++;
            } else {    // c是数字，考虑多位数
                str = "";
                while (index < expression.length()
                        && (c = expression.charAt(index)) >= 48
                        && (c = expression.charAt(index)) <= 57) {
                    str += c;   // 拼接数字
                    index++;
                }
                list.add(str);
            }
        } while (index < expression.length());

        return list;
    }
}
