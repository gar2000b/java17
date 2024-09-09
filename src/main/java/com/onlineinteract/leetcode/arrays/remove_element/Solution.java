package com.onlineinteract.leetcode.arrays.remove_element;

import java.util.Arrays;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        int k = 0;

        while (i < length) {
            if (nums[i] == val) {
                for (int j = length - 1; j > i; j--) {
                    if (nums[i] != nums[j]) {
                        int tmp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = tmp;
                        length = j;
                        k++;
                        break;
                    }
                }
            } else
                k++;

            i++;
        }

        return k;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,2,2,3,0,4,2};
        int k = new Solution().removeElement(nums, 2);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
