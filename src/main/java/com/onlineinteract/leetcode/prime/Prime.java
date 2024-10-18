package com.onlineinteract.leetcode.prime;

import java.util.ArrayList;
import java.util.List;

public class Prime {

    public static void main(String[] args) {
        List<Integer> primes = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            if (isPrime(i))
                primes.add(i);
        }

        System.out.println("The list of primes are:\n" + primes.toString());
    }

    public static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }
}
