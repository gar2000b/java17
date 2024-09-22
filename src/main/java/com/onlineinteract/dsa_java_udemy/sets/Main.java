package com.onlineinteract.dsa_java_udemy.sets;

import com.onlineinteract.utility.Print;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = removeDuplicates(List.of(1, 2, 3, 4, 1, 2, 5, 6, 7, 3, 4, 8, 9, 5));
        System.out.println(list);
        Print.printSeparator();

        System.out.println(hasUniqueChars("abcdefg")); // should return true
        System.out.println(hasUniqueChars("hello")); // should return false
        System.out.println(hasUniqueChars("")); // should return true
        System.out.println(hasUniqueChars("a")); // should return true
        System.out.println(hasUniqueChars("0123456789")); // should return true
        System.out.println(hasUniqueChars("abacadaeaf")); // should return false
        Print.printSeparator();

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 4, 6, 8, 10};
        int target = 7;

        List<int[]> pairs = findPairs(arr1, arr2, target);
        for (int[] pair : pairs) {
            System.out.println(Arrays.toString(pair));
        }
        Print.printSeparator();

        testLongestConsecutiveSequence("Consecutive Integers", new int[] {1, 2, 3, 4, 5}, 5);
        testLongestConsecutiveSequence("No Sequence", new int[] {1, 3, 5, 7, 9}, 1);
        testLongestConsecutiveSequence("Duplicates", new int[] {1, 2, 2, 3, 4}, 4);
        testLongestConsecutiveSequence("Negative Numbers", new int[] {1, 0, -1, -2, -3}, 5);
        testLongestConsecutiveSequence("Empty Array", new int[] {}, 0);
        testLongestConsecutiveSequence("Multiple Sequences", new int[] {1, 2, 3, 10, 11, 12, 13}, 4);
        testLongestConsecutiveSequence("Unordered Elements", new int[] {5, 1, 3, 4, 2}, 5);
        testLongestConsecutiveSequence("Single Element", new int[] {1}, 1);
        testLongestConsecutiveSequence("All Identical Elements", new int[] {2, 2, 2, 2, 2}, 1);
        Print.printSeparator();
    }

    private static void testLongestConsecutiveSequence(String title, int[] nums, int expected) {
        System.out.println("Test: " + title);
        System.out.print("Testing array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int result = longestConsecutiveSequence(nums);
        System.out.println("Expected longest streak: " + expected);
        System.out.println("Actual longest streak: " + result);

        if (result == expected) {
            System.out.println("PASS\n");
        } else {
            System.out.println("FAIL\n");
        }
    }

    public static int longestConsecutiveSequence(int[] nums) {
        // If the array is empty, return 0 as there is no sequence
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Add all elements to the HashSet for O(1) lookup
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through each number in the array
        for (int num : numSet) {
            // Check if num is the start of a sequence (i.e., num - 1 is not in the set)
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Continue checking the next consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                // Update the longest streak found
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        if(arr1.length == 0 || arr2.length == 0) {
            new ArrayList<>();
        }

        Set<Integer> setArr1 = new HashSet<>();
        List<int[]> list = new ArrayList<>();

        for (Integer i : arr1)
            setArr1.add(i);

        for (int i = 0; i < arr2.length; i++) {
            int compliment = target - arr2[i];
            if(setArr1.contains(compliment)) {
                int[] arr = new int[]{compliment, arr2[i]};
                list.add(arr);
            }
        }

        return list;
    }

    public static boolean hasUniqueChars(String string) {
        if (string.length() == 0 || string.length() == 1) {
            return true;
        }

        Set<Integer> set = new HashSet<>();
        int length = string.length();

        for (Character c : string.toCharArray()) {
            set.add(Integer.valueOf(c));
        }

        if (length == set.size()) {
            return true;
        }

        return false;
    }

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        Set<Integer> set = new HashSet<>(myList);
        List<Integer> list = new ArrayList<>(set);
        return list;
    }
}
