package com.liyuwen.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * LeetCode 20. 有效的括号
 *
 * @author Liyuwen
 * @create 2020/5/12 22:50
 */
public class LeetCode20 {
    @Test
    public void test() {

        String s = "";
        System.out.println(isValid(s));

    }

    public boolean isValid(String s) {
        if (s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (isMatch(stack.peek(), c)) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatch(char char1, char char2) {
        return (char1 == '{' && char2 == '}') || (char1 == '[' && char2 == ']')
                || (char1 == '(' && char2 == ')');
    }

}
