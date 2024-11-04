package com.onlineinteract.dsa_java_udemy.dynamic_programming;

import com.onlineinteract.utility.Print;

/**
 * Notes:
 * <br><br>
 * Head recursion is used rather loosely here as we check the base cases first.
 */
public class Fibonacci {

    static int counter = 0;
    static Integer[] memo = new Integer[100];

    public static void main(String[] args) {
        counter = 0;
        for (int i = 0; i <= 5; i++) {
            System.out.println(head(i));
        }
        System.out.println("counter: " + counter);
        Print.printSeparator();

        counter = 0;
        memo = new Integer[100];
        System.out.println(head(5));
        System.out.println("Fibonacci head recursion - counter: " + counter);
        Print.printSeparator();

        counter = 0;
        memo = new Integer[100];
        System.out.println(tail(5, 0, 1));
        System.out.println("Fibonacci tail recursion - counter: " + counter);
        Print.printSeparator();

        counter = 0;
        memo = new Integer[100];
        System.out.println(head2(5));
        System.out.println("Fibonacci head recursion with memoization - counter: " + counter);
        Print.printSeparator();

        counter = 0;
        memo = new Integer[100];
        System.out.println(iteration(5));
        System.out.println("Fibonacci iteration with dynamic programming - counter: " + counter);
        Print.printSeparator();

        counter = 0;
        memo = new Integer[100];
        System.out.println(iteration2(5));
        System.out.println("Fibonacci iteration with intermediate variable - counter: " + counter);
        Print.printSeparator();
    }

    /**
     * Fibonacci head recursion
     *
     * @param n
     * @return
     */
    public static int head(int n) {
        counter++;

        if (n == 0 || n == 1) {
            return n;
        }

        int fib1 = head(n - 1);
        int fib2 = head(n - 2);

        int result = fib1 + fib2;

        return result;
    }

    /**
     * Fibonacci tail recursion
     * <br><br>
     * Notes:
     * <br><br>
     * The hardest part to get right in our mind is the shifting of a and b during the recursive call.
     * <br><br>
     * What's really happening is that subsequent calls to tail are shifting b to become the new a,
     * and the new b becomes (a + b), thereby adding the previous two numbers together.
     * <br><br>
     * It helps to visualise it if you draw a table with (a, b and n) columns.
     * <br><br>
     * So in the last iteration, a and b are going to be the last 2 numbers in the sequence.
     * <br><br>
     * We only need a though.
     *
     * @param n
     * @param a
     * @param b
     * @return
     */
    public static int tail(int n, int a, int b) {
        counter++;

        // Base case: when n reaches 0, return the current accumulator
        if (n == 0) {
            return a;
        }

        // Tail-recursive call: pass the current values down, shifting a and b
        return tail(n - 1, b, a + b);
    }

    /**
     * Fibonacci head recursion with memoization
     *
     * @param n
     * @return
     */
    public static int head2(int n) {
        counter++;

        if (memo[n] != null) {
            return memo[n];
        }

        if (n == 0 || n == 1) {
            return n;
        }

        int fib1 = head2(n - 1);
        int fib2 = head2(n - 2);

        memo[n] = fib1 + fib2;

        return memo[n];
    }

    /**
     * Fibonacci iteration with dynamic programming
     *
     * @param n
     * @return
     */
    public static int iteration(int n) {
        int[] fibList = new int[n + 1];
        fibList[0] = 0;
        fibList[1] = 1;

        for (int index = 2; index <= n; index++) {
            fibList[index] = fibList[index - 1] + fibList[index - 2];
        }

        return fibList[n];
    }

    /**
     * Fibonacci iteration with intermediate variable
     *
     * @param n
     * @return
     */
    public static int iteration2(int n) {
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
