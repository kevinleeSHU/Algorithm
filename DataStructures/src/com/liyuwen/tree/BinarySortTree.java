package com.liyuwen.tree;

/**
 * @author Liyuwen
 * @create 2020/8/15 13:37
 */
public class BinarySortTree {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        Tree1 tree = new Tree1();
        for (int i = 0; i < arr.length; i++) {
            tree.add(new Node1(arr[i]));
        }

        // 中序遍历（排序）
        tree.infixOrder();
    }
}

class Tree1 {
    private Node1 root;
    public void add(Node1 node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("空树");
        }
    }

    public Node1 search(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
    }

    public Node1 searchParent(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
    }

    /**
     * 删除结点
     * @param val
     */
    public void deleteNode(int val) {
        if (root == null) {
            return;
        } else {
            Node1 target = search(val);
            if (target == null) {
                return;
            }
        }
    }
}

class Node1 {
    int val;
    Node1 left;
    Node1 right;

    public Node1(int val) {
        this.val = val;
    }

    /**
     * 递归添加结点
     * @param node
     */
    public void add(Node1 node) {
        if (node == null) {
            return;
        }

        if (node.val < this.val) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }

    /**
     * 查找要删除的结点
     * @param val
     * @return
     */
    public Node1 search(int val) {
        if (val == this.val) {
            return this;
        } else if (val < this.val) {
            if (this.left == null) {
                return null;
            }
            return this.left.search(val);
        } else {
            if (this.right == null) {
                return null;
            }
            return this.right.search(val);
        }
    }

    /**
     * 查找要删除结点的父节点
     * @param val
     * @return
     */
    public Node1 searchParent(int val) {
        if ((this.left != null && this.left.val == val) // 如果当前结点就是要删除结点的父结点，就返回
                || (this.right != null && this.right.val == val)) {
            return this;
        } else {
            if (val < this.val && this.left != null) {  // 如果查找的值小于当前结点的值，且当前结点的左孩子不为空
                return this.left.searchParent(val);     // 向左子树递归查找
            } else if (val > this.val && this.right != null) {
                return this.right.searchParent(val);
            } else {
                return null;
            }
        }
    }

    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    @Override
    public String toString() {
        return "Node1{" +
                "val=" + val +
                '}';
    }
}
