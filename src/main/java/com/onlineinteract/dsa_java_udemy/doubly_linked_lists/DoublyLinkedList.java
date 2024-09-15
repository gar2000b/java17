package com.onlineinteract.dsa_java_udemy.doubly_linked_lists;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
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
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;

        length++;
    }

    public Node removeLast() {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            Node tmp = tail;
            head = null;
            tail = null;
            length--;

            return tmp;
        }

        tail.prev.next = null;
        Node tmp = tail;
        tail = tail.prev;
        tmp.prev = null;
        length--;

        return tmp;
    }

    public void prepend(int value) {
        Node tmp = new Node(value);

        if (length == 0) {
            head = tmp;
            tail = tmp;
            length++;

            return;
        }

        tmp.next = head;
        head.prev = tmp;
        head = tmp;
        length++;
    }

    public Node removeFirst() {
        if (length == 0) {
            return null;
        }

        if (length == 1) {
            Node tmp = head;
            head = null;
            tail = null;
            length--;

            return tmp;
        }

        Node tmp = head;
        head = head.next;
        head.prev = null;
        tmp.next = null;
        length--;

        return tmp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        int mid = length - 2;

        if (index >= mid) {
            Node tmp = tail;
            for (int i = length - 1; i > index; i--) {
                tmp = tmp.prev;
            }

            return tmp;
        }

        if (index < mid) {
            Node tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }

            return tmp;
        }

        return null;
    }

    public boolean set(int index, int value) {
        Node tmp = get(index);

        if (tmp != null) {
            tmp.value = value;
            return true;
        }

        return false;
    }

//    public boolean insert(int index, int value) {
//        if (index < 0 || index > length && length != 0) {
//            return false;
//        }
//
//        if (length == 0) {
//            prepend(value);
//            return true;
//        }
//
//        if(index == length) {
//            append(value);
//            return true;
//        }
//
//        int mid = length - 2;
//
//        Node tmp = null;
//        if (index >= mid) {
//            tmp = tail;
//            for (int i = length - 1; i > index; i--) {
//                tmp = tmp.prev;
//            }
//        }
//
//        if (index < mid) {
//            tmp = head;
//            for (int i = 0; i < index; i++) {
//                tmp = tmp.next;
//            }
//        }
//
//        Node nn = new Node(value);
//        Node prev = tmp.prev;
//
//        if(prev != null) {
//            prev.next = nn;
//            nn.prev = prev;
//        } else {
//            head = nn;
//        }
//
//        nn.next = tmp;
//        tmp.prev = nn;
//        length++;
//
//        return true;
//    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        }

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;
        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node tmp = get(index);
        Node before = tmp.prev;
        Node after = tmp.next;
        tmp.prev = null;
        tmp.next = null;
        before.next = after;
        after.prev = before;
        length--;

        return tmp;
    }

    public void swapFirstLast() {
        if (length == 0 || length == 1) {
            return;
        }

        if (length == 2) {
            head.next = null;
            tail.prev = null;

            Node tmp = head;
            head = tail;
            tail = tmp;

            head.next = tail;
            tail.prev = head;

            return;
        }

        Node next = head.next;
        Node prev = tail.prev;
        head.next = null;
        next.prev = null;
        tail.prev = null;
        prev.next = null;

        Node tmp = head;
        head = tail;
        tail = tmp;

        head.next = next;
        next.prev = head;
        tail.prev = prev;
        prev.next = tail;
    }

    public void reverse() {
        if (length == 0 || length == 1) {
            return;
        }

        if (length == 2) {
            head.next = null;
            tail.prev = null;

            Node tmp = head;
            head = tail;
            tail = tmp;

            head.next = tail;
            tail.prev = head;

            return;
        }

        Node prev = null;
        Node tmp = head;
        Node next = tmp.next;

        while (tmp != null) {
            tmp.next = prev;

            if (prev != null) {
                prev.prev = tmp;
            }

            prev = tmp;
            tmp = next;

            if (next != null) {
                next = next.next;
            }
        }

        prev.prev = null;
        tmp = head;
        head = tail;
        tail = tmp;
    }

    public boolean isPalindrome() {
        if (length == 0) {
            return true;
        }

        if (length == 1) {
            return true;
        }

        if (length == 2) {
            if (head.value == tail.value) {
                return true;
            }
        }

        Node tmp = head;
        Node tmp2 = tail;
        int mid = length / 2;

        for (int i = 0; i < mid; i++) {
            if (tmp.value == tmp2.value) {
                tmp = tmp.next;
                tmp2 = tmp2.prev;
            } else {
                return false;
            }
        }

        return true;
    }

    public void swapPairs() {
        if (length == 0) {
            return;
        }

        if (length == 1) {
            return;
        }

        if (length == 2) {
            /**
             * Assign left and right nodes.
             */
            Node l = head;
            Node r = head.next;

            /**
             * Null out next and prev references prior to swap.
             */
            l.next = null;
            r.prev = null;

            /**
             * Swap left and right;
             */
            Node tmp = l;
            l = r;
            r = tmp;

            /**
             * Put references back in now that swap has happened.
             */
            l.next = r;
            r.prev = l;

            /**
             * Update head to new left.
             */
            head = l;
            return;
        }

        /**
         * x4 pointer references (left, right, left neighbour, right neighbour)
         */
        Node l = head;
        Node r = l.next;
        Node ln = l.prev;
        Node rn = r.next;

        /**
         * Loop from 0 to length - 1 and increment by 2.
         * This ensures it will not land on the last node if there are an odd umber of nodes in the DLL.
         */
        for (int i = 0; i < length - 1; i = i + 2) {
            /**
             * Null all x4 pointer references next and prev references prior to swapping the pairs.
             */
            if (ln != null) {
                ln.next = null;
            }
            l.prev = null;
            l.next = null;
            r.prev = null;
            r.next = null;
            if (rn != null) {
                rn.prev = null;
            }

            /**
             * Swap the pairs
             */
            Node tmp = l;
            l = r;
            r = tmp;

            /**
             * Set all the pointer reference next and prev references to correct places since pair has been swapped.
             */
            if (ln != null) {
                ln.next = l;
            }
            l.prev = ln;
            l.next = r;
            r.prev = l;
            r.next = rn;
            if (rn != null) {
                rn.prev = r;
            }

            /**
             * If we are at the beginning, then set head to new left node.
             */
            if (i == 0) {
                head = l;
            }

            /**
             * Set the x4 pointer references (left, right, left neighbour, right neighbour) to new position for next
             * iteration (taking care to guard against null pointer exceptions).
             */
            l = rn;
            ln = r;
            if (l != null) {
                r = l.next;
            }
            if (r != null) {
                rn = r.next;
            }
        }
    }
}


