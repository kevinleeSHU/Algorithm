package com.liyuwen.queue;

import org.junit.Test;

import java.util.Scanner;

/**
 * 数组实现循环队列
 *
 * @author Liyuwen
 * @create 2020/4/14 15:28
 */
public class CircularArrayQueue {

    // Test
    public static void main(String[] args) {

        CircularArrayQueue queue = new CircularArrayQueue(5);

        char key = ' ';     // accept the character you input
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show): print all elements of the queue\t" +
                    "a(add):add an element into the queue\ng(get): get the head element from the queue" +
                    "\th()head: print the head element of the queue\ne(exit): exit");
            System.out.print("Choose an action: ");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.print("Input an integer: ");
                    int value = scanner.nextInt();
                    queue.enQueue(value);;
                    break;
                case 'g':
                    try {
                        Integer res = queue.deQueue();
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

    private int maxSize;
    private int front;      // front指向队列第一个元素，初始值为 0
    private int rear;       // 队列尾，指向队列最后一个元素的下一位，初始值为 0
    private int[] arr;

    public CircularArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = rear = 0;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;   // 数组中还保留一个空单元，则认为队列已满
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void enQueue(int n) {
        if (isFull()) {
            System.out.println("The queue is full!");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int deQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue, no data!");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;

        return value;
    }

    /* Print all the data from a queue */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("Empty queue, no data!");
            return;
        }
        for (int i = 0; i < ((rear - front + maxSize) % maxSize); i++) {    // rear  - front + maxSize) % maxSize
                                                                            // means the number of elements the queue contains
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.println("arr[" + (front + i) % maxSize + "] = " + arr[(front + i) % maxSize] + "\t");
        }
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty queue, no data!");
        }
        return arr[front];
    }
}
