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
        Print.printSeparator();

        BinarySearchTree myBST = new BinarySearchTree();
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);
        System.out.println("\nRecursive BST Contains 27:");
        System.out.println(myBST.rContains(27));
        System.out.println("\nRecursive BST Contains 17:");
        System.out.println(myBST.rContains(17));
        Print.printSeparator();

        /**
         * The following creates this tree:
         *         2
         *       /   \
         *     1      3
         */
        myBST = new BinarySearchTree();
        myBST.rInsert(2);
        myBST.rInsert(1);
        myBST.rInsert(3);
        System.out.println("\nRoot: " + myBST.root.value);
        System.out.println("\nRoot->Left: " + myBST.root.left.value);
        System.out.println("\nRoot->Right: " + myBST.root.right.value);
        myBST.printTree();
        Print.printSeparator();

        myBST = new BinarySearchTree();
        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(27);
        myBST.insert(52);
        myBST.insert(82);
        System.out.println(myBST.minValue(myBST.root));
        System.out.println(myBST.minValue(myBST.root.right));
        Print.printSeparator();

        /**
         * The following creates this tree:
         *         2
         *       /   \
         *     1      3
         */
        myBST = new BinarySearchTree();
        myBST.rInsert(2);
        myBST.rInsert(1);
        myBST.rInsert(3);
        myBST.deleteNode(2);

        /**
         * The following leaves this tree:
         *         3
         *       /   \
         *     1      null
         */
        myBST.printTree();
        Print.printSeparator();

        myBST = new BinarySearchTree();
        myBST.rInsert(47);
        myBST.rInsert(21);
        myBST.rInsert(20);
        myBST.rInsert(22);
        myBST.deleteNode(21);
        myBST.printTree();
        Print.printSeparator();

        myBST = new BinarySearchTree();
        myBST.rInsert(3);
        myBST.rInsert(2);
        myBST.rInsert(1);
        myBST.rInsert(4);
        myBST.rInsert(5);
        myBST.printTree();
        Print.printSeparator();

        System.out.println("Sorted Array: {1, 2, 3, 4, 5}");
        myBST = new BinarySearchTree();
        myBST.sortedArrayToBST(new int[]{1, 2, 3, 4, 5});
        myBST.printTree();
        Print.printSeparator();

        System.out.println("Sorted Array: {1, 2, 3, 4}");
        myBST = new BinarySearchTree();
        myBST.sortedArrayToBST(new int[]{1, 2, 3, 4});
        myBST.printTree();
        Print.printSeparator();

        System.out.println("Sorted Array: {1, 2, 3, 4, 5, 6, 7}");
        myBST = new BinarySearchTree();
        myBST.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7});
        myBST.printTree();
        Print.printSeparator();

        System.out.println("Sorted Array: {1, 2, 3}");
        myBST = new BinarySearchTree();
        myBST.sortedArrayToBST(new int[]{1, 2, 3});
        myBST.printTree();
        Print.printSeparator();

        myBST = new BinarySearchTree();
        myBST.rInsert(3);
        myBST.rInsert(2);
        myBST.rInsert(1);
        myBST.rInsert(4);
        myBST.rInsert(5);
        myBST.printTree();
        myBST.invert();
        myBST.printTree();
        Print.printSeparator();
    }
}
