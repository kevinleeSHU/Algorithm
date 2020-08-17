package com.liyuwen.stack;

/**
 * @author Liyuwen
 * @create 2020/4/29 16:09
 */
public class LinkedListStack<T> {

    private Node top;
    private int count;

    private class Node {
        T value;
        Node next;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void push(T value) {
        Node oldTop = top;
        top = new Node();
        top.value = value;
        top.next = oldTop;
        count++;
    }

    public T pop() {
        if (count == 0) {
            new RuntimeException("栈中没有元素");
        }

        T value = top.value;
        top = top.next;
        count--;
        return value;
    }

    public T getTop() {
        return top.value;
    }

}
