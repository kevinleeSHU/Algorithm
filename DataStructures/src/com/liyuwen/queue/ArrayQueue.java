package com.liyuwen.queue;

import org.omg.CORBA.Object;

import java.util.Scanner;

/**
 * 用数组实现队列
 *
 * @author Liyuwen
 * @create 2020/4/13 23:19
 */
public class ArrayQueue<T> {

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<Integer>(3);
        char key = ' ';     // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列\te(exit):退出程序\t" +
                    "a(add):添加数据到队列\tg(get):从队列中取出数据\th()head:查看队列头的数据");
            key = scanner.nextLine().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个整数: ");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        Integer res = queue.getQueue();
                        System.out.println("取出对列头的数据为" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        Integer res = queue.headQueue();
                        System.out.println("队列头的数据为" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

    }

    private int maxSize;    // 数组最大容量
    private int front;      // 队列头
    private int rear;       // 队列尾
    private T arr[];      // 存放数据的数组，模拟队列

    // 创建队列的构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = (T[]) new Object[maxSize];
        front = -1;         // 指向队列头部，front是指向队列头的前一个位置
        rear = -1;          // 指向队列尾，指向队列最后一个数据
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(T t) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列已满，不能添加数据");
            return;
        }
        rear++;
        arr[rear] = t;
    }

    // 获取队列头数据并出队列
    public T getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法取数据");
        }
        front++;
        return arr[front];
    }

    // 显示队列所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (T t : arr) {
            System.out.println(t);
        }
    }

    // 显示队列头数据，不出队列
    public T headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }
}

