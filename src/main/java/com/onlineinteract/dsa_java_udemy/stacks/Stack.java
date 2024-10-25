package com.onlineinteract.dsa_java_udemy.stacks;

public class Stack {
    private Node top;
    public int height;
    private String name;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack() {
        top = null;
        height = 0;
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node tmp = top;

        System.out.println(name + "\n");

        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }

        System.out.println();
    }

    public void printTower() {
        Node tmp = top;

        System.out.print(name + " - ");

        String tower = "";

        while (tmp != null) {
            tower = tmp.value + " " + tower;
            tmp = tmp.next;
        }

        System.out.println(tower);
    }

    public void getTop() {
        System.out.println("Top: " + top.value);
    }

    public void getHeight() {
        System.out.println("Height: " + height);
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if (height == 0) {
            top = newNode;
            height++;
            return;
        }

        if (height > 0) {
            newNode.next = top;
            top = newNode;
            height++;
        }
    }

    public Node pop() {
        if (height == 0) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int peek() {
        if (top == null)
            return 0;

        return top.value;
    }
}
