package com.onlineinteract.leetcode.arrays.merge_sorted_array;

import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mn = m + n;
        int nums1Pos = 0;
        int nums2Pos = 0;
        int[] result = new int[mn];

        for (int i = 0; i < mn; i++) {
            if (nums1Pos < m) {
                if (nums2Pos >= n || nums1[nums1Pos] <= nums2[nums2Pos]) {
                    result[i] = nums1[nums1Pos];
                    nums1Pos++;
                    continue;
                }
            }

            if (nums2Pos < n) {
                if (nums1Pos >= m || nums2[nums2Pos] < nums1[nums1Pos]) {
                    result[i] = nums2[nums2Pos];
                    nums2Pos++;
                }
            }
        }

        for (int i = 0; i < result.length; i++)
            nums1[i] = result[i];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;

        new Solution().merge(nums1, m, nums2, n);

        System.out.println(Arrays.toString(nums1));
    }
}