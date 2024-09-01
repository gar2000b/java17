package com.onlineinteract.formatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        format();
    }

    /**
     * Java Formatter with printf:
     * <p>
     * %s - General String
     * %d - Decimal Integer
     * %f - Floating Point
     * %n - Newline
     * <p>
     * MessageFormat.format()"
     * <p>
     * Argument placeholders in message: {0}, {1}..{n} - followed by the respective arguments
     * <p>
     * Logger:
     * <p>
     * Argument placeholders in message: {}, {}..{} - followed by the respective arguments
     */
    public static void format() {
        System.out.printf("%s, your age is %d, and before, it was %d%n", "Gary", 43, 42);
        System.out.println(String.format("%s, your age is %d, and before, it was %d", "Gary", 43, 42));
        System.out.println(MessageFormat.format("{0}, your age is {1}, and before, it was {2}", "Gary", 43, 42));
        logger.info("{}, your age is {}, and before, it was {}", "Gary", 43, 42);
    }

}
