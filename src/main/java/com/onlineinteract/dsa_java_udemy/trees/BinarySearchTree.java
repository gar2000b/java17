package com.onlineinteract.dsa_java_udemy.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

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
        if (node == null) {
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

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);

            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }

        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);

        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }

        new Traverse(root);

        return results;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                results.add(currentNode.value);

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);

        return results;
    }

    public ArrayList<Integer> DFSInOrderIterative() {
        ArrayList<Integer> results = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;

        // Traverse the tree iteratively using the stack
        while (current != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (current != null) {
                stack.push(current);  // Push current node onto the stack
                current = current.left;  // Move to the left child
            }

            // Current must be null at this point, pop the top node from the stack
            current = stack.pop();
            results.add(current.value);  // Add the node's value to the results list

            // Move to the right subtree
            current = current.right;
        }

        return results;
    }

    public boolean isValidBST() {
        ArrayList<Integer> results = DFSInOrder();

        for (int i = 1; i < results.size(); i++) {
            if (results.get(i) <= results.get(i - 1)) {
                return false;
            }
        }

        return true;
    }

    public Integer kthSmallest(int k) {
        if (root == null || k <= 0) return null;

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            // Go to the leftmost node and push all nodes along the path
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            // Pop the top node from the stack and process it
            current = stack.pop();
            k--;  // Decrement k as we process each node in sorted order

            // If k is 0, we found the kth smallest element
            if (k == 0) {
                return current.value;
            }

            // Move to the right subtree
            current = current.right;
        }

        // If k is greater than the number of nodes in the BST
        return null;
    }

    public Integer kthSmallestRecursion(int k) {
        AtomicInteger K = new AtomicInteger(k);
        AtomicInteger result = new AtomicInteger();

        if (root == null || k <= 0) return null;

        class Traverse {
            Traverse(Node currentNode) {
                if(K.get() == 0) {
                    return;
                }

                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }

                K.set(K.get() - 1);

                if(K.get() == 0) {
                    result.set(currentNode.value);
                    return;
                }

                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);

        return result.get();
    }
}

