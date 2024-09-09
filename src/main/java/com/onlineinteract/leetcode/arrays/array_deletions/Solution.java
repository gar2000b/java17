package com.onlineinteract.leetcode.arrays.array_deletions;

import java.util.Arrays;

public class Solution {
    static int[] intArray = new int[10];

    // The array currently contains 0 elements
    static int length = 0;

    public static void main(String[] args) {
        // Declare an integer array of 10 elements.

        // Add elements at the first 6 indexes of the Array.
        for (int i = 0; i < 6; i++) {
            intArray[length] = i;
            length++;
        }

        System.out.println(Arrays.toString(intArray));
        System.out.println(length + "\n");

        printArray();

        deleteLastElement();

        printArray();

        delete(1);

        printArray();
    }

    private static void delete(int position) {
        for(int i = position + 1; i < length; i++)
            intArray[i - 1] = intArray[i];

        length--;
    }

    /**
     * Logical Deletion - deletes the last element from our array.
     */
    private static void deleteLastElement() {
        length--;
    }

    private static void printArray() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(intArray, 0, length)));
    }
}
