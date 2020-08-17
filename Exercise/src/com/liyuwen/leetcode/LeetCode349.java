package com.liyuwen.leetcode;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 *    1. 输出结果中的每个元素一定是唯一的
 *    2. 我们可以不考虑输出结果的顺序
 *
 * @author Liyuwen
 * @create 2020/7/6 22:21
 */
public class LeetCode349 {

    // 我的初次暴力解法
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> resSet = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    resSet.add(nums1[i]);
                }
            }
        }
        Integer[] temp = new Integer[resSet.size()];
        resSet.toArray(temp);

        int[] res = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            res[i] = temp[i].intValue();
        }
        return res;
    }

    //
    public int[] intersection2(int[] nums1, int[] nums2) {
        return null;
    }

}
