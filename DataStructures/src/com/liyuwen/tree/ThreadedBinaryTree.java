package com.liyuwen.tree;

/**
 * @author Liyuwen
 * @create 2020/8/6 20:34
 */
public class ThreadedBinaryTree {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(8);
        Node node5 = new Node(10);
        Node node6 = new Node(14);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        Tree tree = new Tree();
        tree.root = node1;

        tree.infixThreadedNodes();   // 线索化

        Node leftNode = node5.left;
        Node rightNode = node5.right;
        System.out.println("10号结点的前驱结点为：" + leftNode);
        System.out.println("10号结点的后继结点为：" + rightNode);

        System.out.println("中序线索化遍历二叉树：");
        tree.infixThreadedList();
    }
}

class Tree {
    Node root;
    private Node prev = null;   // 指向当前结点的前驱结点的指针

    public void infixThreadedNodes() {
        this.infixThreadedNodes(root);
    }

    /**
     * 遍历线索化二叉树
     */
    public void infixThreadedList() {
        Node node = root;

        while (node != null) {
            while (node.lTag == 0) {    // 循环一直到lTag == 1的结点
                node = node.left;
            }

            System.out.println(node);

            while (node.rTag == 1) {    // 如果当前结点的右指针指向的是后继结点，就一直输出
                node = node.right;
                System.out.println(node);
            }

            node = node.right;
        }
    }

    /**
     * 中序线索化结点
     * @param node
     */
    public void infixThreadedNodes(Node node) {
        if (node == null) {
            return;
        }

        // 线索化左子树
        infixThreadedNodes(node.left);

        // 线索化操作
        if (node.left == null) {
            node.left = prev;   // 当前结点的左指针指向前驱结点
            node.lTag = 1;
        }
        if (prev != null && prev.right == null) {
            prev.right = node;
            prev.rTag = 1;
        }
        prev = node;

        // 线索化右子树
        infixThreadedNodes(node.right);
    }

    /**
     * 前序线索化结点
     * @param node
     */
    public void prefixThreadedNodes(Node node) {
        if (node == null) {
            return;
        }

        // 线索化操作
        if (node.left == null) {
            node.left = prev;   // 当前结点的左指针指向前驱结点
            node.lTag = 1;
        }
        if (prev != null && prev.right == null) {
            prev.right = node;
            prev.rTag = 1;
        }
        prev = node;

        // 线索化左子树
        infixThreadedNodes(node.left);

        // 线索化右子树
        infixThreadedNodes(node.right);
    }

    /**
     * 后续线索化结点
     * @param node
     */
    public void postfixThreadedNodes(Node node) {
        
    }
}

class Node {
    int val;
    Node left;
    Node right;

    int lTag;   // 0表示指向左子树，1表示指向前驱结点
    int rTag;   // 0表示指向右子树，1表示指向后继结点

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val + '}';
    }
}