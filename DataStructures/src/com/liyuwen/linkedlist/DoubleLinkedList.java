package com.liyuwen.linkedlist;

/**
 * 双向链表
 * @author Liyuwen
 * @create 2020/4/29 15:28
 */
public class DoubleLinkedList {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        Node node1 = new Node();
        node1.value = 1;
        Node node2 = new Node();
        node2.value = 2;
        Node node3 = new Node();
        node3.value = 3;
        Node node4 = new Node();
        node4.value = 4 ;

        Node node0 = new Node();
        node0.value = 0;

        list.addNodeAt(1, node0);
        list.addNodeAt(2, node1);
        list.addNodeAt(3, node2);
        list.addNodeAt(4, node3);
        list.addNodeAt(5, node4);

        list.listAll();
        System.out.println();

        list.remove(5);

        list.listAll();

    }

    private Node head;
    private int N;

    private static class Node {
        public int value;
        public Node prev;
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

    public boolean isEmpty() {
        return head == null;
    }

    // 尾插法
    public void add(Node node) {
        if (head == null) {
            head = new Node();
            head.next = node;
            node.prev = head;
            node.next = head;
            N++;
        } else {
            Node temp = head.next;
            for (int i = 1; i < N; i++) { // 得到最后一个(第N个)节点
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
            node.next = head;
            N++;
        }
    }

    public void addNodeAt(int index, Node node) {
        if (index < 1 || index > N + 1) {
            System.out.println("范围有误！");
            return;
        }

        if ((index == 1 && head == null) || index == N + 1) {
            add(node);
        } else  {
            Node temp = head.next;
            for (int i = 1; i < index; i++) { // 得到第 index 个节点
                temp = temp.next;
            }
            temp.prev.next = node;
            node.next = temp;
            node.prev = temp.prev;
            temp.prev = node;
            N++;
        }
    }

    public int remove(int index) {
        if (isEmpty()) {
            throw new RuntimeException("链表为空");
        }
        if (index < 1 || index > N) {
            throw new RuntimeException("索引有误");
        }

        if (index == 1 && N == 1) {
            int value = head.next.value;
            head = null;
            N--;
            return value;
        } else {
            Node temp = head.next;
            for (int i = 1; i < index; i++) { // 得到第 index 个节点
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            N--;
            return temp.value;
        }
    }

    public void update(int index, int value) {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        if (index < 1 || index > N) {
            System.out.println("索引有误！");
            return;
        }

        Node temp = head.next;
        for (int i = 1; i < index; i++) { // 得到第 index 个节点
            temp = temp.next;
        }
        temp.value = value;
    }

    public void listAt(int index) {
        Node temp = head.next;
        for (int i = 1; i < index; i++) { // 得到第 index 个节点
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
