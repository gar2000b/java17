package com.onlineinteract.recursion;

public class Factorial {

    public int head(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Cannot accept negative numbers for Factorial head() where n == " + n);
        }

        if (n == 1 || n == 0) {
            return 1;
        }

        int res1 = head(n - 1);

        int result = n * res1;

        return result;
    }

    public int tail (int n, int accumulator) {
        if (n == 0) {
            return accumulator;
        }

        return tail(n - 1, n * accumulator);
    }
}
