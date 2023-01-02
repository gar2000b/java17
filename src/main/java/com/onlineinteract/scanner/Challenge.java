package com.onlineinteract.scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Challenge {

    private static Logger logger = LoggerFactory.getLogger(Challenge.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 1;
        double sum = 0;

        while (counter <= 5) {
            System.out.println("Enter number #" + counter + ":");
            String nextNumber = scanner.nextLine();
            try {
                double number = Double.parseDouble(nextNumber);
                counter++;
                sum += number;
            } catch (NumberFormatException e) {
                logger.error("Invalid number: " + e.getMessage(), e);
            }
        }

        System.out.println("The sum of the 5 numbers = " + sum);
    }
}
