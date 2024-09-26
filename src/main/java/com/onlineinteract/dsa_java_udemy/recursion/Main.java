package com.onlineinteract.dsa_java_udemy.recursion;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nfactorial(4): " + factorial(4));
        System.out.println("factorial(5): " + factorial(5));
        System.out.println("factorial(6): " + factorial(6));
    }

    public static int factorial(int num) {
        if (num == 1)
            return 1;

        return num * factorial(num - 1);
    }
}
