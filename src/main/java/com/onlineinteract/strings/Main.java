package com.onlineinteract.strings;

public class Main {
    public static void main(String[] args) {
        stringInspectionMethods();
    }

    public static void stringInspectionMethods() {
        String helloWorld = "Hello World";
        System.out.println(String.format("index of l is %d", helloWorld.indexOf("l")));
        System.out.println(String.format("index of l is %d", helloWorld.indexOf("l", 4)));
        System.out.println(String.format("last index of l is %d", helloWorld.lastIndexOf("l")));
        System.out.println(String.format("last index of l is %d", helloWorld.lastIndexOf("l", 8)));
    }

    public static void stringComparisonMethods() {

    }

}
