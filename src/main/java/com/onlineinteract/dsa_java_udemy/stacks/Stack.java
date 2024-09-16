package com.onlineinteract.dsa_java_udemy.stacks;

public class Stack {
    private Node top;
    private int height;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node tmp = top;

        System.out.println("Stack:\n");

        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public void getTop() {
        System.out.println("Top: " + top.value);
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if(height == 0) {
            top = newNode;
            height++;
            return;
        }

        if(height > 0) {
            newNode.next = top;
            top = newNode;
            height++;
        }
    }

    public Node pop() {
        if(height == 0) {
            return null;
        }

        if (height == 1) {
            Node tmp = top;
            top = null;
            height--;
            return tmp;
        }

        Node tmp = top;
        top = top.next;
        tmp.next = null;
        height--;

        return tmp;
    }
}
