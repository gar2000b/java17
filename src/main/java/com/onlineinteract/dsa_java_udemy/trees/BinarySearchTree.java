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
            if (value == currentNode.value) {
                return false;
            }

            if (value < currentNode.value) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return true;
                } else {
                    currentNode = currentNode.left;
                    continue;
                }
            }

            if (value > currentNode.value) {
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

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }

        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }

        rInsert(root, value);
    }

    public boolean contains(int value) {

        if (root == null) {
            return false;
        }

        Node currentNode = root;

        while (currentNode != null) {
            if (value == currentNode.value) {
                return true;
            }

            if (value < currentNode.value) {
                currentNode = currentNode.left;
                continue;
            }

            if (value > currentNode.value) {
                currentNode = currentNode.right;
            }
        }

        return false;
    }

    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) {
            return false;
        }

        if (currentNode.value == value) {
            return true;
        }

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            return null;
        }

        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if (currentNode.left == null && currentNode.right == null) {
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, subTreeMin);
            }
        }

        return currentNode;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    public int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }

        return currentNode.value;
    }

    private Node sortedArrayToBST(int[] nums, int left, int right) {
        // Base case: if the left index exceeds the right index, there's no element to process
        if (left > right) {
            return null;
        }

        // Find the middle element of the current segment of the array
        int mid = left + (right - left) / 2;

        // Create a new node with the middle element as its value
        Node node = new Node(nums[mid]);

        // Recursively build the left subtree using the left half of the array
        node.left = sortedArrayToBST(nums, left, mid - 1);

        // Recursively build the right subtree using the right half of the array
        node.right = sortedArrayToBST(nums, mid + 1, right);

        // Return the node which is now the root of the BST for this segment
        return node;
    }

    public void sortedArrayToBST(int[] nums) {
        this.root = sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private Node invertTree(Node node) {
        if(node == null) {
            return null;
        }

        Node tmp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(tmp);

        return node;
    }

    public void invert() {
        root = invertTree(root);
    }
}

