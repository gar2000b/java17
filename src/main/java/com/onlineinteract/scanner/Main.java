package com.onlineinteract.scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        int currentYear = 2022;
        try {
            throw new NullPointerException("Cannot read input from console in IDE");
        } catch (NullPointerException e) {
            logger.error(e.getMessage(), e);
            logger.info("Attempting to use Scanner");
            System.out.println(getInputFromScanner(currentYear));
        }
    }

    public static String getInputFromScanner(int currentYear) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hi, what's your name? ");
        String name = sc.nextLine();

        System.out.println("Hi " + name + ", thanks for taking the course!");
        System.out.println("");
        System.out.println("What year were you born?");
        String dateOfBirth = sc.nextLine();

        int age = currentYear - Integer.parseInt(dateOfBirth);

        return "So you are " + age + " years old";
    }

}
