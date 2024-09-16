package com.onlineinteract.dsa_java_udemy.queues;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        Queue myQueue = new Queue(7);
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.printQueue();
        Print.printSeparator();

        myQueue = new Queue(1);
        myQueue.enQueue(2);
        myQueue.enQueue(3);
        myQueue.enQueue(4);
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.printQueue();
        Print.printSeparator();

        myQueue.deQueue();
//        myQueue.deQueue();
//        myQueue.deQueue();
//        myQueue.deQueue();
        myQueue.getFirst();
        myQueue.getLast();
        myQueue.getLength();
        myQueue.printQueue();
        Print.printSeparator();
    }
}
