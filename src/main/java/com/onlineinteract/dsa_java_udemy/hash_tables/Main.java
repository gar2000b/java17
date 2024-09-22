package com.onlineinteract.dsa_java_udemy.hash_tables;

import com.onlineinteract.utility.Print;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashTable myHashTable = new HashTable();
        myHashTable.printTable();
        Print.printSeparator();

        myHashTable = new HashTable();
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        System.out.println("Lumber:");
        System.out.println(myHashTable.get("lumber"));
        System.out.println("\nBolts:");
        System.out.println(myHashTable.get("bolts"));
        Print.printSeparator();

        myHashTable = new HashTable();
        myHashTable.set("paint", 20);
        myHashTable.set("bolts", 40);
        myHashTable.set("nails", 100);
        myHashTable.set("tile", 50);
        myHashTable.set("lumber", 80);
        System.out.println(myHashTable.keys());
        Print.printSeparator();

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};
        System.out.println("Item in common (inefficient): " + itemInCommon(array1, array2));
        Print.printSeparator();

        System.out.println("Item in common (efficient): " + itemInCommon2(array1, array2));
        Print.printSeparator();

        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println("Duplicates: " + duplicates.toString());
        Print.printSeparator();

        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));
        Print.printSeparator();

        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));
        Print.printSeparator();

        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));
        Print.printSeparator();

        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");

        int[] nums5 = {5};
        int target5 = 5;
        int[] result5 = subarraySum(nums5, target5);
        System.out.println("[" + result5[0] + ", " + result5[1] + "]");
        Print.printSeparator();
    }

    public static int[] subarraySum(int[] sums, int target) {
        int diff = 0;
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < sums.length; i++) {
            total += sums[i];
            map.put(sums[i], i);

            if (total == target) {
                return new int[]{0, i};
            }

            if (total > target) {
                diff = total - target;
                if (map.get(diff) != null) {
                    int index = map.get(diff) + 1;
                    return new int[]{index, i};
                }
            }
        }

        return new int[0];
    }

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[0];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                Integer index = map.get(compliment);
                return new int[]{index, i};
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }

    public static List<List<String>> groupAnagrams(String[] strings) {
        // Create a HashMap where the key is the character frequency signature
        // and the value is a list of anagram strings
        Map<String, List<String>> map = new HashMap<>();

        // Iterate through each string in the input array
        for (String str : strings) {
            // Create a frequency array for the 26 lowercase English letters
            int[] charCount = new int[26];

            // Fill the frequency array based on the characters in the current string
            for (char c : str.toCharArray()) {
                charCount[c - 'a']++; // Increment the count for the corresponding character
            }

            // Convert the frequency array into a string as the key
            // We use Arrays.toString to ensure the frequency array is represented as a unique string
            String key = Arrays.toString(charCount);

            // If the key is not already in the map, add it with an empty list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the current string to the list associated with the frequency key
            map.get(key).add(str);
        }

        // Convert map of lists into list of lists.
        Set<String> keys = map.keySet();
        List<List<String>> list = new ArrayList<>();
        for (String key : keys) {
            list.add(map.get(key));
        }

        // Finally, return all the grouped anagrams as a list of lists
        return list;
    }

    public static Character firstNonRepeatingChar(String input) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            Integer count = hashMap.get(character);
            if (count != null) {
                hashMap.put(character, count + 1);
            } else {
                hashMap.put(character, 1);
            }
        }

        for (int i = 0; i < input.length(); i++) {
            Character character = input.charAt(i);
            Integer count = hashMap.get(character);
            if (count == 1) {
                return character;
            }
        }

        return null;
    }

    public static List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.get(nums[i]) != null) {
                set.add(nums[i]);
            }
            hashMap.put(nums[i], true);
        }

        ArrayList<Integer> list = new ArrayList<>(set);

        return list;
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        for (int i : array1) {
            for (int j : array2) {
                if (i == j) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean itemInCommon2(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> hashMap = new HashMap();

        for (int i : array1) {
            hashMap.put(i, true);
        }

        for (int i : array2) {
            if (hashMap.get(i) != null) {
                return true;
            }
        }

        return false;
    }
}
