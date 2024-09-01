package com.onlineinteract.leetcode.arrays;

public class Arrays {
    public static void main(String[] args) {
        int[] squareNumbers = new int[10];

        for (int i = 0; i < 10; i++) {
            int square = (i + 1) * (i + 1);
            squareNumbers[i] = square;
        }

        for (int number: squareNumbers) {
            System.out.println(number);
        }
    }
}
