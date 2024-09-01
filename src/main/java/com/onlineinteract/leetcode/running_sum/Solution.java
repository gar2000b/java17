package com.onlineinteract.leetcode.running_sum;

import java.util.Arrays;

public class Solution {
    public int[] runningSum(int[] nums) {
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i-1]+nums[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        int[] sums = new Solution().runningSum(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(sums));
    }
}