package com.liyuwen.tree.huffmantree;

/**
 * @author Liyuwen
 * @create 2020/8/15 9:50
 */
public class HuffmanCoding {
    public static void main(String[] args) {

    }

    private static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("空树");
            return;
        }
    }


}

class Node implements Comparable<Node> {
    Byte data;  // 存放数据。如 'a' => 97
    int weight;  // 某个字符的个数
    Node left;
    Node right;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    public void preOrder() {
        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }
}
