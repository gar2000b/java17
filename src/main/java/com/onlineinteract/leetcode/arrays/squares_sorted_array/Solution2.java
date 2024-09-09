package com.onlineinteract.leetcode.arrays.squares_sorted_array;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in
 * non-decreasing order.
 *
 * This solution basically takes in the originally sorted array, creates a result array (same length), creates x2
 * pointers (initially set at the boundaries).
 *
 * It then traverses the nums array from the end backwards and places the largest value (squared, from each boundary
 * of nums - p1 and p2) into the end of the new result array (++ or -- the appropriate pointer along the way).
 * The result array is then returned in squared sorted order.
 */
public class Solution2 {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int p1 = 0;
        int p2 = nums.length - 1;

        for(int i = nums.length - 1; i >= 0; i--) {
            if(Math.abs(nums[p1]) >= Math.abs(nums[p2])) {
                result[i] = nums[p1] * nums[p1];
                p1++;
            } else {
                result[i] = nums[p2] * nums[p2];
                p2--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] response = new Solution2().sortedSquares(nums);
        System.out.println(Arrays.toString(response));
    }
}
