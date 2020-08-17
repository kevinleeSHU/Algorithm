package com.liyuwen.tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 *         1
 *        / \
 *       2   5
 *      / \   \
 *     3   4   6
 * @author Liyuwen
 * @create 2020/8/2 21:16
 */
public class Traversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        String s = new String("a");


        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        System.out.println("非递归前序遍历为：");
        iterationPreOrder(node1);

        System.out.println("非递归中序遍历为：");
        iterationInOrder(node1);

        System.out.println("非递归后序遍历为：");
        iterationPostOrder(node1);

        System.out.println("层序遍历为：");
        levelOrder(node1);

    }

    public static void recursionPreOrder(TreeNode root) {
        if (root == null) {
            System.out.println("根节点为空");
            return;
        }
        System.out.println(root);
        if (root.left != null) {
            recursionPreOrder(root.left);
        }

        if (root.right != null) {
            recursionPreOrder(root.right);
        }
    }

    public static void recursionInOrder(TreeNode root) {
        if (root == null) {
            System.out.println("根节点为空");
            return;
        }
        if (root.left != null) {
            recursionInOrder(root.left);
        }
        System.out.println(root);
        if (root.right != null) {
            recursionInOrder(root.right);
        }
    }

    public static void recursionPostOrder(TreeNode root) {
        if (root == null) {
            System.out.println("根节点为空");
            return;
        }
        if (root.left != null) {
            recursionPostOrder(root.left);
        }
        if (root.right != null) {
            recursionPostOrder(root.right);
        }
        System.out.println(root);
    }

    /**
     * 1.先将根节点入栈
     * 2.访问根节点
     * 3.如果根节点存在右孩子，则将右孩子入栈
     * 4.如果根节点存在左孩子，则将左孩子入栈（注意：一定是右孩子先入栈，然后左孩子入栈）
     * 5.重复2-4
     *
     * @param root
     */
    public static void iterationPreOrder(TreeNode root) {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode curr = stack.pop();
            System.out.println(curr);

            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }

    /**
     * 1.先将根节点入栈
     * 2.将当前节点的所有左孩子入栈，直到左孩子为空
     * 3.访问栈顶元素，如果栈顶元素存在右孩子，则继续第2步
     * 4.重复第2、3步，直到栈为空并且所有的节点都被访问
     * @param root
     */
    public static void iterationInOrder(TreeNode root) {
        if (root == null) {
            System.out.println("树为空");
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (curr != null || !stack.empty()) {
            // 1.先将根节点入栈
            // 2.将当前节点的所有左孩子入栈，直到左孩子为空
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // 3.访问栈顶元素
            curr = stack.pop();
            System.out.println(curr);

            if (curr.right != null) {   // 4.如果栈顶元素存在右孩子，则将右孩子赋值给tmp，也就是将右孩子入栈
                curr = curr.right;
            } else {                    // 否则，将tmp置为null，表示下次要访问的是栈顶元素
                curr = null;
            }
        }
    }

    /**
     * 1.根节点入栈
     * 2.将根节点的左子树入栈，直到最左，没有左孩子为止
     * 3.得到栈顶元素的值，先不访问，判断栈顶元素是否存在右孩子，如果存在并且没有被访问，则将右孩子入栈，否则，就访问栈顶元素
     * @param root
     */
    public static void iterationPostOrder(TreeNode root) {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        TreeNode curr = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();

        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            if (!stack.empty()) {
                curr = stack.peek();

                if (curr.right == null || curr.right == prev) {
                    curr = stack.pop();
                    System.out.println(curr);

                    prev = curr;
                    curr = null;
                } else {
                    curr = curr.right;
                }
            }
        }
    }

    /**
     * 层序遍历
     * @param root
     */
    public static void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.println(front);
            if (front.left != null) {
                queue.offer(front.left);
            }
            if (front.right != null) {
                queue.offer(front.right);
            }
        }
    }

    public static TreeNode deleteNode(TreeNode root, TreeNode node) {
        if (root == null) {
            System.out.println("树为空，无法删除");
            return null;
        }

        if (node == root) {
            TreeNode curr = root;
            root = null;
            return curr;
        }
        // TODO
        return null;
    }
}
