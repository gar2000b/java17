package com.onlineinteract.dsa_java_udemy.trees;

public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int value) {
        Node newNode = new Node(value);
        root = newNode;
    }

    public void printTree() {
        System.out.println();
        printTree(root, 0, "H");  // Start from the root with height 0 and position "H" for horizontal.
    }

    private void printTree(Node node, int depth, String position) {
        if (node == null) {
            return;
        }

        // Print the right subtree first (it goes to the right of the root).
        printTree(node.right, depth + 1, "R");

        // Print the current node value with leading spaces to create indentation.
        String indentation = "    ".repeat(depth);
        System.out.println(indentation + position + "----" + node.value);

        // Print the left subtree (it goes to the left of the root).
        printTree(node.left, depth + 1, "L");
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return true;
        }

        Node currentNode = root;

        while (currentNode != null) {
            if(value == currentNode.value) {
                return false;
            }

            if(value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return true;
                } else {
                    currentNode = currentNode.left;
                    continue;
                }
            }

            if(value > currentNode.value) {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return true;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
        return false;
    }

    public boolean contains(int value) {

        if (root == null) {
            return false;
        }

        Node currentNode = root;

        while (currentNode != null) {
            if(value == currentNode.value) {
                return true;
            }

            if(value < currentNode.value) {
                currentNode = currentNode.left;
                continue;
            }

            if(value > currentNode.value) {
                currentNode = currentNode.right;
            }
        }

        return false;
    }
}
