package com.onlineinteract.leetcode.arrays.valid_mountain;

public class Solution {
    public boolean validMountainArray(int[] arr) {

        /**
         *
         * state = 0 (start state) => 1 (ascending state) => 2 (descending state)
         *
         * Notes:
         * In order to transition to state 1 (from state 0 only), we must ascend the mountain by 1 position.
         * In order to transition to state 2 (from state 1 only), we must descend the mountain by 1 position.
         * State 0 can only ascend once, triggering the next state transition to state 1.
         * State 1 can legally ascend or descend, although, descending will trigger the next state transition to state 2.
         * State 2 can only descend.
         * Any sidewards movement (in any state) will yield false.
         * Descending in state 0 will yield false.
         * Ascending in state 2 will yield false.
         */
        int state = 0;

        if (arr.length < 3)
            return false;

        for (int i = 0; i < arr.length - 1; i++) {
            if (state == 0) {
                if (arr[i] < arr[i + 1]) {
                    state = 1;
                    continue;
                } else
                    return false;
            }

            if (state == 1) {
                if (arr[i] < arr[i + 1]) {
                    continue;
                } else if (arr[i] == arr[i + 1]) {
                    return false;
                } else {
                    state = 2;
                    continue;
                }
            }

            if (state == 2) {
                if (arr[i] <= arr[i + 1]) {
                    return false;
                }
            }
        }

        if (state == 2)
            return true;

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,3,2,1};
        boolean result = new Solution().validMountainArray(arr);
        System.out.println(result);
    }
}
