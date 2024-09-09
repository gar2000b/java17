package com.onlineinteract.dsa_java_udemy.singly_linked_lists;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);

        Print.printSeparator();
        linkedList.printAll();
        Print.printSeparator();
        linkedList.append(2);
        linkedList.append(3);
        linkedList.printAll();

        Print.printSeparator();
        LinkedList.Node head = linkedList.getHead();
        System.out.println("head value: " + head.value);
        Print.printSeparator();
        LinkedList.Node tail = linkedList.getTail();
        System.out.println("tail value: " + tail.value);
        Print.printSeparator();

        LinkedList.Node node = linkedList.removeLast();
        System.out.println("Node value removed: " + node.value);
        linkedList.printAll();
        Print.printSeparator();
        node = linkedList.removeLast();
        System.out.println("Node value removed: " + node.value);
        linkedList.printAll();
        Print.printSeparator();
        node = linkedList.removeLast();
        System.out.println("Node value removed: " + node.value);
        linkedList.printAll();
        Print.printSeparator();
        node = linkedList.removeLast();
        System.out.println("Cannot remove from an empty list - just returns back null");
        linkedList.printAll();

        Print.printSeparator();
        linkedList.makeEmpty();
        Print.printSeparator();

        linkedList.prepend(3);
        linkedList.prepend(2);
        linkedList.prepend(1);
        linkedList.printAll();
        Print.printSeparator();

        linkedList.removeFirst();
        linkedList.printAll();
        Print.printSeparator();

        linkedList.removeFirst();
        linkedList.printAll();
        Print.printSeparator();

        linkedList.removeFirst();
        linkedList.printAll();
        Print.printSeparator();

        linkedList.prepend(3);
        linkedList.prepend(2);
        linkedList.prepend(1);
        linkedList.printAll();
        Print.printSeparator();

        node = linkedList.get(0);
        System.out.println("Node from get(0) has a value of: " + node.value);
        node = linkedList.get(1);
        System.out.println("Node from get(1) has a value of: " + node.value);
        node = linkedList.get(2);
        System.out.println("Node from get(2) has a value of: " + node.value);
        Print.printSeparator();

        linkedList.set(0, 7);
        linkedList.set(1, 8);
        linkedList.set(2, 9);
        linkedList.printAll();
        Print.printSeparator();

        linkedList.insert(1,5);
        linkedList.printAll();
        Print.printSeparator();
        linkedList.insert(4,4);
        linkedList.printAll();
        Print.printSeparator();

        linkedList.remove(1);
        linkedList.printAll();
        Print.printSeparator();
        linkedList.remove(0);
        linkedList.printAll();
        Print.printSeparator();
        linkedList.remove(2);
        linkedList.printAll();
        Print.printSeparator();

        linkedList.append(10);
        linkedList.append(11);
        linkedList.append(12);
        linkedList.printAll();
        Print.printSeparator();

//        linkedList.reverse();
//        linkedList.printAll();
//        Print.printSeparator();

        LinkedList.Node middleNode = linkedList.findMiddleNode();
        System.out.println("Middle node is: " + middleNode.value);
        linkedList.printAll();
        Print.printSeparator();

        linkedList.removeLast();

        middleNode = linkedList.findMiddleNode();
        System.out.println("Middle node is: " + middleNode.value);
        linkedList.printAll();
        Print.printSeparator();

        linkedList.makeEmpty();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        middleNode = linkedList.findMiddleNode();
        System.out.println("Middle node is: " + middleNode.value);
        linkedList.printAll();
        Print.printSeparator();

        linkedList.makeEmpty();
        linkedList.append(4);
        linkedList.append(11);
        linkedList.append(3);
        linkedList.append(23);
        linkedList.append(7);
        node = linkedList.get(4);
        node.next = linkedList.get(1);
        System.out.println("LinkedList contains loop: " + linkedList.hasLoop());
        Print.printSeparator();

        linkedList.makeEmpty();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.printAll();
        System.out.println("\nKth from end: " + linkedList.findKthFromEnd(2).value);
        Print.printSeparator();

        linkedList.makeEmpty();
        linkedList.append(3);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(2);
        linkedList.append(1);
        linkedList.partitionList(11);
        linkedList.printAll();
        Print.printSeparator();

        linkedList.makeEmpty();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(1);
        linkedList.append(4);
        linkedList.append(2);
        linkedList.append(5);
        linkedList.removeDuplicates();
        linkedList.printAll();
        Print.printSeparator();

        linkedList.makeEmpty();
        linkedList.append(1);
        linkedList.append(1);
        linkedList.append(1);
        linkedList.append(1);
        linkedList.append(1);
        linkedList.removeDuplicates();
        linkedList.printAll();
        Print.printSeparator();

        linkedList.makeEmpty();
        linkedList.append(1);
        linkedList.append(0);
        linkedList.append(1);
        System.out.println("Binary to Decimal: " + linkedList.binaryToDecimal());
        linkedList.printAll();
        Print.printSeparator();

        linkedList.makeEmpty();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.reverseBetween(0, 4);
        linkedList.printAll();
        Print.printSeparator();
    }
}
