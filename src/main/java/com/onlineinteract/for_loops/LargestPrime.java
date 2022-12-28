package com.onlineinteract.for_loops;

public class LargestPrime {
    public static void main(String[] args) {
        System.out.println(getLargestPrime(21));
//        getLargestPrime(217);
//        getLargestPrime(0);
//        getLargestPrime(45);
//        getLargestPrime(-1);

    }

    public static int getLargestPrime(int number) {
        if (number < 2)
            return -1;

        boolean isDivisible = false;

        for (int j = 2; j < number; j++) {
            if (number % j == 0) {
                isDivisible = true;
                break;
            }
        }

        if (!isDivisible && number != 1)
            System.out.println("Prime Number: " + number);

        return number;
    }

}
