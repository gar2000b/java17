package com.onlineinteract.dsa_java_udemy.trees;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(100);
        System.out.println("Root = " + bst.root.value);
        bst.insert(50);
        System.out.println("Value inserted: " + bst.root.left.value);
        bst.insert(150);
        System.out.println("Value inserted: " + bst.root.right.value);
        bst.insert(25);
        System.out.println("Value inserted: " + bst.root.left.left.value);
        bst.insert(75);
        System.out.println("Value inserted: " + bst.root.left.right.value);
        bst.insert(125);
        System.out.println("Value inserted: " + bst.root.right.left.value);
        bst.insert(175);
        System.out.println("Value inserted: " + bst.root.right.right.value);
        bst.printTree();
        Print.printSeparator();

        boolean contains = bst.contains(175);
        System.out.println("Contains: " + contains);
    }
}
