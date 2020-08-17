package com.liyuwen.exer.linkedlist;

import org.junit.Test;

/**
 * @author Liyuwen
 * @create 2020/4/29 16:35
 */
public class SingleLinkedListWithFirstNode {
    public static void main(String[] args) {
        SingleLinkedListWithFirstNode list = new SingleLinkedListWithFirstNode();

        Node node1 = new Node();
        node1.value = 1;
        Node node2 = new Node();
        node2.value = 2;
        Node node3 = new Node();
        node3.value = 3;
        Node node4 = new Node();
        node4.value = 4 ;

        list.addNode(node1);
        list.addNode(node2);
        list.addNode(node3);
        list.addNode(node4);

        list.remove(3);
        list.listAll();
    }

    private Node head;
    private int N;

    private static class Node {
        public int value;
        public Node next;

        public Node() {
        }
    }

    public Node getNode() {
        return new Node();
    }

    public int size() {
        return N;
    }

    // 尾插法
    public void addNode(Node node) {
        if (head == null) {
            head = new Node();
            head.next = node;
            N++;
        } else {
            Node temp = head.next;
            while (temp.next != null) { // 得到最后一个节点
                temp = temp.next;
            }

            temp.next = node;
            N++;
        }
    }

    public void addNodeAt(int index) {

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void update(int index, int value) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空，没有数据");
        }
        if (index < 1 || index > N) {
            throw new RuntimeException("索引范围有误");
        }

        Node temp = head.next;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }
        temp.value = value;
    }

    public int remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空，没有数据");
        }
        if (index < 1 || index > N) {
            throw new RuntimeException("索引范围有误");
        }

        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node temp1 = temp.next;
        temp.next = temp1.next;
        N--;

        return temp1.value;
    }

    public void listAt(int index) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空，没有数据");
        }
        if (index < 1 || index > N) {
            throw new RuntimeException("索引范围有误");
        }

        Node temp = head.next;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        System.out.println(temp.value);
    }

    public void listAll() {
        Node temp = head.next;
        for (int i = 0; i < N; i++) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }
}
