package com.onlineinteract.leetcode.no_of_steps;

class Solution {
    public int numberOfSteps(int num) {
        if(num == 0)
            return 0;

        int noOfSteps = 0;

        while(num != 0) {
            /**
             * Bitwise version (directly equivalent)
             * if((num & 1) == 0)
             *     num >>= 1;
             */
            if(num % 2 == 0)
                num /= 2;
            else
                num --;

            noOfSteps++;
        }

        return noOfSteps;
    }

    public static void main(String[] args) {
        int numberOfSteps = new Solution().numberOfSteps(15);
        System.out.println(numberOfSteps);
    }
}
