package com.onlineinteract.for_loops;

/**
 * Main class for calculating interest.
 */
public class Main {
    /**
     * Main method - main entry point to the application.
     *
     * @param args Command line args passed in on execution.
     */
    public static void main(String[] args) {
        for (double rate = 7.5; rate <= 10; rate += 0.25) {
            if (rate > 8.5)
                break;

            double interest = calculateInterest(100, rate);
            System.out.println("For $100, the interest for a rate of: " + rate + "% is: $" + interest);
        }
    }

    /**
     * Method to calculate interest.
     *
     * @param amount Denominated currency amount.
     * @param rate   The interest rate as a percentage.
     * @return The interest calculated.
     */
    public static double calculateInterest(double amount, double rate) {
        return (amount * (rate / 100));
    }
}
