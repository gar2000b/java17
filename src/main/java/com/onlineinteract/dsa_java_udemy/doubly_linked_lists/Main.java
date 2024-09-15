package com.onlineinteract.dsa_java_udemy.doubly_linked_lists;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.printAll();
        Print.printSeparator();

        myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        System.out.println("Node removed: " + myDLL.removeLast().value);
        myDLL.removeLast();
        myDLL.printAll();
        Print.printSeparator();

        myDLL = new DoublyLinkedList(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.prepend(1);
        myDLL.printAll();
        Print.printSeparator();

        myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        System.out.println("Node with value: " + myDLL.removeFirst().value + " removed");
        myDLL.printAll();
        Print.printSeparator();

        myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        DoublyLinkedList.Node node = myDLL.get(1);
        System.out.println("Value at index pos 1: " + node.value);
        myDLL.printAll();
        Print.printSeparator();

        myDLL = new DoublyLinkedList(1);
//        myDLL.removeLast();
        myDLL.append(2);
        myDLL.append(3);
        myDLL.insert(2, 9);
        myDLL.printAll();
        Print.printSeparator();

        myDLL = new DoublyLinkedList(1);
        myDLL.append(3);

        System.out.println("DLL before insert():");
        myDLL.printList();

        myDLL.insert(1, 2);

        System.out.println("\nDLL after insert(2) in middle:");
        myDLL.printList();

        myDLL.insert(0, 0);

        System.out.println("\nDLL after insert(0) at beginning:");
        myDLL.printList();

        myDLL.insert(4, 4);

        System.out.println("\nDLL after insert(4) at end:");
        myDLL.printList();

        myDLL = new DoublyLinkedList(1);
        myDLL.append(2);
        myDLL.append(3);
        myDLL.remove(0);
//        myDLL.remove(0);
        myDLL.printAll();
        Print.printSeparator();

        myDLL = new DoublyLinkedList(1);
//        myDLL.removeFirst();
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);

        System.out.println("DLL before swap:");
        myDLL.printList();

        myDLL.swapFirstLast();

        System.out.println("\nDLL after swap:");
        myDLL.printList();

        myDLL = new DoublyLinkedList(1);
//        myDLL.removeFirst();
        myDLL.append(2);
        myDLL.append(3);
        myDLL.append(4);
        myDLL.append(5);

        System.out.println("DLL before reverse:");
        myDLL.printList();

        myDLL.reverse();

        System.out.println("\nDLL after reverse:");
        myDLL.printList();

        DoublyLinkedList myDLL1 = new DoublyLinkedList(1);
        myDLL1.append(2);
        myDLL1.append(3);
        myDLL1.append(2);
        myDLL1.append(1);
        System.out.println("myDLL1 isPalindrome:");
        System.out.println( myDLL1.isPalindrome() );

        DoublyLinkedList myDLL2 = new DoublyLinkedList(1);
        myDLL2.append(2);
        myDLL2.append(3);
        System.out.println("\nmyDLL2 isPalindrome:");
        System.out.println( myDLL2.isPalindrome() );

        myDLL2 = new DoublyLinkedList(1);
        System.out.println("\nmyDLL2 isPalindrome:");
        System.out.println( myDLL2.isPalindrome() );

        myDLL2 = new DoublyLinkedList(1);
        myDLL2.removeFirst();
        System.out.println("\nmyDLL2 isPalindrome:");
        System.out.println( myDLL2.isPalindrome() );

        DoublyLinkedList myDll = new DoublyLinkedList(1);
//        myDll.removeFirst();
        myDll.append(2);
        myDll.append(3);
        myDll.append(4);

        System.out.println("myDll before swapPairs:");
        myDll.printList();

        myDll.swapPairs();

        System.out.println("\nmyDll after swapPairs:");
        myDll.printList();
    }
}
