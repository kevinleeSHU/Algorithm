package com.liyuwen.linkedlist;

import org.junit.Test;

/**
 * @author Liyuwen
 * @create 2020/4/29 13:54
 */
public class SingleLinkedList {

    @Test
    public void test() {
        SingleLinkedList list = new SingleLinkedList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);

        list.listAll();
        System.out.println();

        list.remove(4);
        list.remove(3);
        list.listAll();

    }

    private Node first;
    private int N;

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    // 没有头节点的头插法
    public void add(Node newNode) {
        if (first == null) {
            first = newNode;
            N++;
        } else {
            Node oldFirst = first;
            first = newNode;
            first.next = oldFirst;
            N++;
        }
    }

    // 删除任意节点，并返回值
    public int remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空，没有数据");
        }
        if (index < 0 || index >= N) {
            throw new RuntimeException("索引范围有误");
        }

        if (index == 0) {
            return first.value;
        }

        Node temp = first;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node temp1 =  temp.next;
        temp.next = temp1.next;

        N--;

        return temp1.value;

    }

    public void update(int index, int value) {

    }

    public void listAt(int index) {

    }

    public void listAll() {
        Node temp = first;
        for (int i = 0; i < N; i++) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

}
