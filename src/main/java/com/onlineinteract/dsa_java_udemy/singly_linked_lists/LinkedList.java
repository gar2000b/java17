package com.onlineinteract.dsa_java_udemy.singly_linked_lists;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
        System.out.println("LinkedList now emptied!");
    }

    public void append(int value) {
        Node node = new Node(value);

        if (length == 0) {
            head = node;
            tail = node;
            length++;

            return;
        }

        tail.next = node;
        tail = node;
        length++;
    }

    public Node removeLast() {
        if (length == 0)
            return null;

        if (length == 1) {
            Node tmp = head;
            head = null;
            tail = null;
            length--;
            return tmp;
        }

        if (length == 2) {
            Node tmp = tail;
            tail = head;
            head.next = null;
            length--;
            return tmp;
        }

        if (length > 2) {
            Node tmp = head;
            while (tmp.next.next != null) {
                tmp = tmp.next;
            }
            Node returnNode = tmp.next;
            tmp.next = null;
            tail = tmp;
            length--;
            return returnNode;
        }

        return null;
    }

    public void prepend(int value) {
        Node node = new Node(value);

        if (length == 0) {
            head = node;
            tail = node;
            length++;
            return;
        }

        node.next = head;
        head = node;
        length++;
    }

    public Node removeFirst() {
        if (length == 0)
            return null;

        if (length == 1) {
            Node tmp = head;
            head = null;
            tail = null;
            length--;
            return tmp;
        }

        Node tmp = head;
        head = head.next;
        tmp.next = null;
        length--;

        return tmp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length)
            return null;

        Node temp = head;

        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp;
    }

    public boolean set(int index, int value) {
        if (index < 0 || index >= length)
            return false;

        Node temp = head;

        for (int i = 0; i < index; i++)
            temp = temp.next;

        temp.value = value;

        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length)
            return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node temp = get(index - 1);
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length || length == 0)
            return null;

        if (length == 1 || index == 0)
            return removeFirst();

        if (index == length - 1)
            return removeLast();

        Node previousNode = get(index - 1);
        Node removeNode = previousNode.next;
        previousNode.next = removeNode.next;
        removeNode.next = null;
        length--;

        return removeNode;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = temp.next;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            return head.next;
        }

        Node middle = head;
        Node tmp = head;

        while (true) {
            if (tmp.next != null) {
                if (tmp.next.next != null) {
                    middle = middle.next;
                    tmp = tmp.next.next;
                    continue;
                }

                middle = middle.next;
                break;
            }

            return middle;
        }

        return middle;
    }

    public boolean hasLoop() {
        if (head == null) {
            return false;
        }

        if (head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (true) {
            if (fast.next != null) {
                if (fast.next.next != null) {
                    slow = slow.next;
                    fast = fast.next.next;

                    if (fast.value == slow.value) {
                        return true;
                    }

                    continue;
                }

                return false;
            }

            return false;
        }
    }

    public Node findKthFromEnd(int k) {
        if(head == null)
            return null;

        Node p1 = head;
        Node p2 = head;
        int p1Index = 1;
        int p2Index = 1;

        while(p1.next != null) {
            if (p2Index == k) {
                p2 = p2.next;
            } else {
                p2Index++;
            }

            p1 = p1.next;
            p1Index++;
        }

        if(p1Index < k)
            return null;

        return p2;
    }

    public void partitionList(int x) {
        if(head == null)
            return;

        if(head.next == null) {
            return;
        }

        Node h1 = null;
        Node t1 = null;
        Node h2 = null;
        Node t2 = null;
        Node tmp = head;

        while(tmp != null) {
            if(tmp.value < x) {
                if(h1 == null) {
                    h1 = tmp;
                    t1 = tmp;
                    tmp = tmp.next;
                    continue;
                }

                t1.next = tmp;
                t1 = tmp;
                tmp = tmp.next;
            } else {
                if(h2 == null) {
                    h2 = tmp;
                    t2 = tmp;
                    tmp = tmp.next;
                    continue;
                }

                t2.next = tmp;
                t2 = tmp;
                tmp = tmp.next;
            }
        }

        if(t1 == null || t2 == null) {
            return;
        }

        t1.next = h2;
        head = h1;
        t2.next = null;
    }

    public void removeDuplicates() {
        if(head == null) {
            return;
        }

        if(head.next == null) {
            return;
        }

        Set<Integer> memory = new HashSet<>();
        Node tmp = head;
        Node previous = null;

        while(tmp != null) {
            if(memory.contains(tmp.value)) {
                Node remove = tmp;
                tmp = tmp.next;
                remove.next = null;
                previous.next = tmp;
                length--;
            } else {
                memory.add(tmp.value);
                previous = tmp;
                tmp = tmp.next;
            }
        }
    }

    public int binaryToDecimal() {
        if(head == null) {
            return 0;
        }

        int num = 0;
        Node tmp = head;

        while(tmp != null) {
            num = (num * 2) + tmp.value;
            tmp = tmp.next;
        }

        return num;
    }

    public void reverseBetween(int m, int n) {
        if(head == null) {
            return;
        }

        if(head.next == null) {
            return;
        }

        if(m < 0 || n >= length) {
            return;
        }

        int i = 0;
        Node p1 = null;
        Node p2 = null;
        Node prev = null;
        Node tmp = head;
        Node next = tmp.next;

        while (i <= n) {
            if(i == m - 1) {
                p1 = tmp;
            }

            if(i == m) {
                p2 = tmp;
                tmp.next = null;
            }

            if(i > m && i <= n) {
                tmp.next = prev;
            }

            if(i == n) {
                if(p1 != null) {
                    p1.next = tmp;
                } else {
                    head = tmp;
                }

                p2.next = next;
            }

            if(next == null) {
                break;
            }

            prev = tmp;
            tmp = next;
            next = tmp.next;
            i++;
        }
    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 2, 3, 4, and 5
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("Original linked list: ");
        myLinkedList.printList();

        // Reverse a sublist within the linked list
        myLinkedList.reverseBetween(1, 3);
        System.out.println("\nReversed sublist (1, 3): ");
        myLinkedList.printList();

        // Reverse another sublist within the linked list
        myLinkedList.reverseBetween(0, 4);
        System.out.println("\nReversed entire linked list: ");
        myLinkedList.printList();

        // Reverse a sublist of length 1 within the linked list
        myLinkedList.reverseBetween(2, 2);
        System.out.println("\nReversed sublist of length 1 (2, 2): ");
        myLinkedList.printList();

        // Reverse an empty linked list
        LinkedList emptyList = new LinkedList(0);
        emptyList.makeEmpty();
        emptyList.reverseBetween(0, 0);
        System.out.println("\nReversed empty linked list: ");
        emptyList.printList();

        /*
            EXPECTED OUTPUT:
            ----------------
            Original linked list:
            1
            2
            3
            4
            5

            Reversed sublist (1, 3):
            1
            4
            3
            2
            5

            Reversed entire linked list:
            5
            2
            3
            4
            1

            Reversed sublist of length 1 (2, 2):
            5
            2
            3
            4
            1

            Reversed empty linked list:

        */
    }
}