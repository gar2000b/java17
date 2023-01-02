package com.onlineinteract.scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class MinMaxChallenge {
    private static Logger logger = LoggerFactory.getLogger(MinMaxChallenge.class);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double max = 0;
        double min = 0;
        int loopCount = 0;

        while (true) {
            System.out.println("Enter a number, or character to exit:");
            String nextEntry = scanner.nextLine();
            try {
                double validNum = Double.parseDouble(nextEntry);

                if (loopCount == 0 || validNum < min)
                    min = validNum;
                if (loopCount == 0 || validNum > max)
                    max = validNum;

                loopCount++;
            } catch (NumberFormatException e) {
                if (!nextEntry.equals("q"))
                    logger.error(e.getMessage(), e);
                else
                    break;
            }
        }

        if (loopCount > 0)
            System.out.println("min = " + min + ", max = " + max);
        else
            System.out.println("No valid data entered");

    }
}
