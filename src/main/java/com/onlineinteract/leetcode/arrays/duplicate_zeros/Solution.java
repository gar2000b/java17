package com.onlineinteract.leetcode.arrays.duplicate_zeros;

import java.util.Arrays;

public class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                for (int j = arr.length - 1; j > i; j--) {
                    arr[j] = arr[j - 1];
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        new Solution().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
