package com.liyuwen.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * LeetCode 102. 二叉树层序遍历
 *
 * 思想：利用队列
 *
 * @author Liyuwen
 * @create 2020/5/13 22:24
 */
public class LeetCode102 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            int count = queue.size();
            List<Integer> list = new ArrayList<>();

            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                count--;

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(list);
        }

        return res;
    }

}
