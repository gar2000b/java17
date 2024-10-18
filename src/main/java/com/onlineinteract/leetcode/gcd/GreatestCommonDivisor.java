package com.onlineinteract.leetcode.gcd;

public class GreatestCommonDivisor {
    static int counter = 0;

    public static void main(String[] args) {
//        int num1 = 6;
//        int num2 = 3;
//        int num1 = 12;
//        int num2 = 9;
//        int num1 = 36;
//        int num2 = 27;
        int num1 = 97;
        int num2 = 56;
        int gcd = gcd(num1, num2);
        System.out.println("\nCount: " + counter + " - GCD of " + num1 + " and " + num2 + " is: " + gcd);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
