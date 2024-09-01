package com.onlineinteract.leetcode.ransom_note;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineLetters = new HashMap<>();

        for(int i = 0; i < magazine.length(); i++) {
            char letter = magazine.charAt(i);
            magazineLetters.put(letter, magazineLetters.getOrDefault(letter, 0) + 1);
        }

        for(int j = 0; j < ransomNote.length(); j++) {
            char letter = ransomNote.charAt(j);
            Integer count = magazineLetters.getOrDefault(letter, 0);

            if(count == 0) {
                return false;
            }

            magazineLetters.put(letter, count - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        boolean result = new Solution().canConstruct("aa", "aab");

        if(result)
            System.out.println("Yes, you can construct the ransomNote from the magazine");
        else
            System.out.println("No, you cannot construct the ransomNote from the magazine");
    }
}