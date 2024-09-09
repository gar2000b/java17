package com.onlineinteract.dsa_java_udemy.doubly_linked_lists;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.printAll();
        Print.printSeparator();
    }
}
