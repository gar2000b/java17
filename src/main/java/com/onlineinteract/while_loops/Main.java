package com.onlineinteract.while_loops;

public class Main {
    public static void main(String[] args) {
        processWhile();
        processDoWhile();
    }

    private static void processDoWhile() {
        int counter = 0;

        do {
            counter++;
        } while (counter < 5);

        System.out.println("Counter is: " + counter);
    }

    private static void processWhile() {
        int counter = 0;

        while (true) {
            if (counter == 5)
                break;
            counter++;
        }

        System.out.println("Counter is: " + counter);
    }
}
