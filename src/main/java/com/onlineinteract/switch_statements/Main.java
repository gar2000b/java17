package com.onlineinteract.switch_statements;

public class Main {
    public static void main(String[] args) {
        String day = switch (4) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> {yield "Thursday"; }
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "Invalid Day";
        };

        System.out.println("Day selected is: " + day);
    }
}
