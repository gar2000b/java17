package com.onlineinteract.leetcode.arrays.remove_duplicates;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int[] array = new int[nums.length];
        int arrayLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (arrayLength != 0) {
                if (nums[i] != array[arrayLength - 1]) {
                    array[arrayLength] = nums[i];
                    arrayLength++;
                }
            } else {
                array[0] = nums[i];
                arrayLength++;
            }
        }

        for (int i = 0; i < nums.length; i++)
            nums[i] = array[i];

        return arrayLength;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k = new Solution().removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
