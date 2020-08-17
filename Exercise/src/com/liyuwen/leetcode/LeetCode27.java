package com.liyuwen.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Liyuwen
 * @create 2020/5/14 23:43
 */
public class LeetCode27 {

    @Test
    public void test() {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int res = removeElement(nums, 2);

        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }

}
