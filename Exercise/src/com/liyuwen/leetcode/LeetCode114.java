package com.liyuwen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode114：给定一个二叉树，原地将它展开为一个单链表
 *  输入：[1,2,5,3,4,null,6]
 *        1
 *       / \
 *      2   5
 *     / \   \
 *    3   4   6
 *  输出：[1,null,2,null,3,null,4,null,5,null,6]
 *      1
 *       \
 *        2
 *         \
 *          3
 *           \
 *            4
 *             \
 *              5
 *               \
 *                6
 * @author Liyuwen
 * @create 2020/8/2 19:14
 */
public class LeetCode114 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        flatten(node1);

        TreeNode root = node1;
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preOrderTraversal(root, list);
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            TreeNode prev = list.get(i);
            TreeNode curr = list.get(i + 1);
            prev.left = null;
            prev.right = curr;
        }
    }
    // 前序遍历
    private static void preOrderTraversal(TreeNode root, List<TreeNode> list){
        if (root != null) {
            list.add(root);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
