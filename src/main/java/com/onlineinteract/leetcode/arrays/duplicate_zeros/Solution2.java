package com.onlineinteract.leetcode.arrays.duplicate_zeros;

import java.util.Arrays;

public class Solution2 {
    public void duplicateZeros(int[] arr) {
        int[] newArr = new int[arr.length];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0)
                newArr[count] = arr[i];
            else {
                newArr[count] = 0;
                count++;

                if (count == arr.length)
                    break;

                newArr[count] = 0;
            }

            count++;

            if (count == arr.length)
                break;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 0, 0, 0, 0, 0};
        new Solution2().duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;
    }
}
