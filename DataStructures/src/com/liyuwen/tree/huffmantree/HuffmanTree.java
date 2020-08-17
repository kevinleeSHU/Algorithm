package com.liyuwen.tree.huffmantree;

import com.liyuwen.tree.TreeNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Liyuwen
 * @create 2020/8/14 14:28
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {3, 9, 23, 13, 8};
        TreeNode root = createHuffmanTree(arr);

        // 前序遍历树
        preOrder(root);

    }

    public static TreeNode createHuffmanTree(int[] arr) {
        ArrayList<TreeNode> nodes = new ArrayList<>();
        for (int val : arr) {
            nodes.add(new TreeNode(val));
        }

        while (nodes.size() > 1) {
            Collections.sort(nodes);

            TreeNode leftNode = nodes.get(0);
            TreeNode rightNode = nodes.get(1);

            TreeNode parent = new TreeNode(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;

            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    public static void preOrder(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        System.out.println(root);
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }
}

