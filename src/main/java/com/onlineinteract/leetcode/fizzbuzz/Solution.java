package com.onlineinteract.leetcode.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> response = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                response.add("FizzBuzz");
                continue;
            }

            if(i % 3 == 0) {
                response.add("Fizz");
                continue;
            }

            if(i % 5 == 0) {
                response.add("Buzz");
                continue;
            }

            response.add(String.valueOf(i));
        }

        return response;
    }

    public static void main(String[] args) {
        List<String> response = new Solution().fizzBuzz(3);
        System.out.println(response);
    }
}