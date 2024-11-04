package com.onlineinteract.recursion;

public class Main {
    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.head(5));
        System.out.println(factorial.tail(5, 1));
    }
}
