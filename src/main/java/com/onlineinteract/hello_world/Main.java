package com.onlineinteract.hello_world;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Java 17 world!");

        boolean flag = true;
        if(flag == true)
            System.out.println("True, Let us proceed...");

        boolean result = (true) ? true : false;
        System.out.println("Ternary result: " + result);
    }
}