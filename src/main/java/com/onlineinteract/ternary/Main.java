package com.onlineinteract.ternary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String result = (1 == 1 ? "1 is equal to 1" : "1 is not equal to 1") + ".";
        logger.info(result);
    }

    private static int getNum(int a, int d, int e) {
        return 0;
    }

    private static int getNum(int b, int c) {
        return 0;
    }
}
