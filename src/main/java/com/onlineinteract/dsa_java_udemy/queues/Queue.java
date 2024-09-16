package com.onlineinteract.dsa_java_udemy.queues;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public void printQueue() {
        Node tmp = first;

        System.out.println("Queue:\n");

        while (tmp != null) {
            System.out.println(tmp.value);
            tmp = tmp.next;
        }
    }

    public void getFirst() {
        System.out.println("First: " + first.value);
    }

    public void getLast() {
        System.out.println("Last: " + last.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void enQueue(int value) {
        if (length == 0) {
            Node newNode = new Node(value);
            first = newNode;
            last = newNode;
            length++;
            return;
        }

        Node newNode = new Node(value);
        last.next = newNode;
        last = newNode;
        length++;
    }

    public Node deQueue() {
        if (length == 0) {
            return null;
        }

        Node tmp = first;
        first = first.next;
        tmp.next = null;
        length--;

        return tmp;
    }
}
