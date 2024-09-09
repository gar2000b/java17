package com.onlineinteract.leetcode.arrays.n_and_double_exists;

import java.util.HashSet;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> memory = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (memory.contains(arr[i] * 2) || (memory.contains(arr[i] / 2) && arr[i] % 2 == 0))
                return true;
            else
                memory.add(arr[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 2, 5, 3};
        boolean result = new Solution().checkIfExist(arr);
        System.out.println(result);
    }
}