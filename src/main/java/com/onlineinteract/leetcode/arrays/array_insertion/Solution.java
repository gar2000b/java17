package com.onlineinteract.leetcode.arrays.array_insertion;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[10];

        for(int i = 0; i < 6; i++)
            nums[i] = i;

        print(nums);

        insertAtPosition(nums, 9, 2);

        print(nums);

        insertAtPosition(nums, 8, 0);

        print(nums);

        insertAtPosition(nums, 9, 9);

        print(nums);

        nums = insertAtPosition(nums, 9, 15);

        print(nums);
    }

    /**
     * Print Array
     * @param nums array
     */
    private static void print(int[] nums) {
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Insert value at index position
     */
    private static int[] insertAtPosition(int[] nums, int value, int indexPosition) {
        if(indexPosition >= nums.length)
            nums = increaseArrayCapacity(nums, indexPosition);

        for(int i = nums.length - 1; i > indexPosition; i--)
            nums[i] = nums[i - 1];

        nums[indexPosition] = value;

        return nums;
    }

    /**
     * This method increases the capacity of the array by doubling it each time until the new size is > the position
     * passed in. Once the new capacity has been determined, we then clone all the values from the old array to the new.
     * @param array
     * @param indexPosition
     */
    private static int[] increaseArrayCapacity(int[] array, int indexPosition) {
        System.out.println("Increasing Array Capacity");
        int currentCapacity = array.length;
        int newCapacity = currentCapacity;

        while (newCapacity <= indexPosition)
            newCapacity *= 2;

        int[] newArray = new int[newCapacity];

        for(int i = 0; i < array.length; i++)
            newArray[i] = array[i];

        return newArray;
    }
}
