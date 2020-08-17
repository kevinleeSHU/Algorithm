package com.liyuwen.exer.stack;

/**
 * @author Liyuwen
 * @create 2020/4/29 16:11
 */
public class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;   // 栈顶初始化 -1，表示栈中没有数据

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("The stack is full!");
            return;
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty!");
        }
        int value = stack[top--];
        return value;
    }

    public int peek() {
        return stack[top];
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("The stack is empty!");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d", i, stack[i]);
        }
    }
}
