package com.onlineinteract.dsa_java_udemy.dynamic_programming;

import com.onlineinteract.utility.Print;

public class Fibonacci {

    static int counter = 0;
    static Integer[] memo = new Integer[100];

    public static void main(String[] args) {
        counter = 0;
        for (int i = 0; i <= 10; i++) {
            System.out.println(fib(i));
        }
        System.out.println("counter: " + counter);
        Print.printSeparator();

        counter = 0;
        memo = new Integer[100];
        System.out.println(fib(10));
        System.out.println("counter: " + counter);
        Print.printSeparator();

        counter = 0;
        memo = new Integer[100];
        System.out.println(fib2(10));
        System.out.println("counter: " + counter);
        Print.printSeparator();

        counter = 0;
        memo = new Integer[100];
        System.out.println(fib3(10));
        System.out.println("counter: " + counter);
        Print.printSeparator();
    }

    public static int fib(int n) {
        counter++;

        if (memo[n] != null) {
            return memo[n];
        }

        if (n == 0 || n == 1) {
            return n;
        }

        memo[n] = fib(n - 1) + fib(n - 2);
        return memo[n];
    }

    public static int fib2(int n) {
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;

        for (int index = 2; index <= n; index++) {
            fibList[index] = fibList[index - 1] + fibList[index - 2];
        }

        return fibList[n];
    }

    public static int fib3(int n) {
        int prevValue = 0;
        int result = 1;

        for (int i = 2; i <= n; i++) {
            int tmp = result;
            result = result + prevValue;
            prevValue = tmp;
        }

        return result;
    }
}
