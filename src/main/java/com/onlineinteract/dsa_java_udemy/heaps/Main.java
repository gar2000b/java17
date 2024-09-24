package com.onlineinteract.dsa_java_udemy.heaps;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        MaxHeap myMaxHeap = new MaxHeap();
        myMaxHeap.insert(99);
        myMaxHeap.insert(72);
        myMaxHeap.insert(61);
        myMaxHeap.insert(58);
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        myMaxHeap.insert(100);
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        myMaxHeap.insert(75);
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        // ----

        myMaxHeap = new MaxHeap();
        myMaxHeap.insert(95);
        myMaxHeap.insert(75);
        myMaxHeap.insert(80);
        myMaxHeap.insert(55);
        myMaxHeap.insert(60);
        myMaxHeap.insert(50);
        myMaxHeap.insert(65);
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        myMaxHeap.remove();
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        myMaxHeap.remove();
        System.out.println(myMaxHeap.getHeap());
        Print.printSeparator();

        MinHeap myMinHeap = new MinHeap();
        myMinHeap.insert(1);
        myMinHeap.insert(12);
        myMinHeap.insert(18);
        myMinHeap.insert(24);
        myMinHeap.insert(26);
        myMinHeap.insert(38);
        myMinHeap.insert(39);
        System.out.println(myMinHeap.getHeap());
        Print.printSeparator();

        myMinHeap.remove();
        System.out.println(myMinHeap.getHeap());
        Print.printSeparator();

        myMinHeap.insert(4);
        System.out.println(myMinHeap.getHeap());
        Print.printSeparator();
    }
}
