package com.liyuwen.stack;

/**
 * @author Liyuwen
 * @create 2020/5/12 9:59
 */
public class StackTest {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        System.out.println(stack.isEmpty());
        stack.pop();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack.getTop());

        stack.pop();
        System.out.println(stack.getTop());
    }

}
