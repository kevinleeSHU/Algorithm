package com.liyuwen.tree;

/**
 * @author Liyuwen
 * @create 2020/8/2 20:32
 */
public class TreeNode implements Comparable<TreeNode> {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val + '}';
    }

    @Override
    public int compareTo(TreeNode o) {
        return this.val - o.val;
    }


}
