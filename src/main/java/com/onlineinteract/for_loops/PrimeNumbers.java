package com.onlineinteract.for_loops;

/**
 * Prime numbers are only divisible by itself and 1.
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        generatePrimeNumbers(100);
        generatePrimeNumbers(200);
    }

    /**
     * Method generating prime numbers up to an upper limit.
     *
     * @param upperLimit implicitly defining a range of prime numbers up to this upper limit.
     */
    private static void generatePrimeNumbers(int upperLimit) {
        int counter = 0;

        /**
         * Bootstrap by echoing out the first prime number in order to realise the efficiency gain.
         */
        if (upperLimit > 1) {
            System.out.println("\nPrime Number: " + 2);
            counter++;
        }

        /**
         * Note: efficiency gain by starting at odd number of 3 and incrementing by 2.
         */
        for (int i = 3; i <= upperLimit; i += 2) {
            boolean isDivisible = false;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isDivisible = true;
                    break;
                }
            }

            if (!isDivisible && i != 1) {
                System.out.println("Prime Number: " + i);
                counter++;
            }
        }

        System.out.println("\nThere are: " + counter + " prime numbers from a total of: " + upperLimit);
    }
}
