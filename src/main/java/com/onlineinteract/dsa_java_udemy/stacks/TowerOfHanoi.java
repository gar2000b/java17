package com.onlineinteract.dsa_java_udemy.stacks;

import com.onlineinteract.utility.Print;

import java.util.HashMap;
import java.util.Map;

/**
 * The TowerOfHanoi class provides a solution to the Tower of Hanoi puzzle,
 * which involves moving a stack of disks from one tower to another while
 * following certain rules.
 * <br><br>
 * The puzzle demonstrates recursion and uses
 * three stacks (towers) to represent the disks and their movement.
 * <br><br>
 * Time complexity = O(2^n) exponential. Space complexity = O(n) linear.
 *
 * @author: Gary Black
 */
public class TowerOfHanoi {

    /**
     * A Map representing the three towers. Each tower is assigned a unique key (1, 2, 3)
     * and stores a Stack object that holds the disks.
     */
    static Map<Integer, Stack> towers = new HashMap();
    static int moveNo = 0;

    /**
     * The main method initializes the towers, places disks in the first tower,
     * and invokes the recursive algorithm to solve the puzzle.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        // Initialize Tower 1 with disks (largest disk first).
        Stack tower1 = new Stack();
        tower1.setName("Tower 1");
//        tower1.push(5);
//        tower1.push(4);
//        tower1.push(3);
        tower1.push(2);
        tower1.push(1);
        towers.put(1, tower1);

        // Initialize Tower 2 (empty).
        Stack tower2 = new Stack();
        tower2.setName("Tower 2");
        towers.put(2, tower2);

        // Initialize Tower 3 (empty).
        Stack tower3 = new Stack();
        tower3.setName("Tower 3");
        towers.put(3, tower3);

        System.out.println("Towers prior to algo:\n");
        printTowers();

        // Start the Tower of Hanoi algorithm to move all disks from Tower 1 to Tower 3.
        System.out.println("Algo commencing:");
        Print.printSeparator();
        hanoiRecursive(tower1.height, 1, 3);
//        hanoiIteration(tower1.height, 1, 3);
        System.out.println("Algo Complete");
        Print.printSeparator();
    }

    /**
     * Prints the current state of all three towers and the iteration number.
     * This method provides a snapshot of the puzzle's progress after each move,
     * displaying the contents of each tower in their current state.
     * <br><br>
     * Each tower is accessed from the global {@code towers} map using its key
     * (1, 2, or 3) and is printed by calling its {@code printTower} method.
     * After printing the state of the towers, a separator is printed to
     * visually divide the output between moves.
     */
    private static void printTowers() {
        System.out.println("Move Iteration Number: " + moveNo);
        towers.get(1).printTower();
        towers.get(2).printTower();
        towers.get(3).printTower();
        Print.printSeparator();
    }

    /**
     * Iteratively solves the Tower of Hanoi puzzle by moving disks between three towers.
     * On even-numbered iterations (starting from 0), the smallest disk is moved between towers
     * according to the determined direction. On odd-numbered iterations, a remaining disk is
     * moved between the other two towers. The method respects the rules of the puzzle while
     * efficiently tracking the current position of the smallest disk.
     * <br><br>
     * The direction of movement is determined based on the number of disks.
     * If the number of disks is odd, the smallest disk moves right-to-left.<br>
     * If the number of disks is even, the smallest disk moves left-to-right.<br>
     * If the destination tower is 2, the direction is reversed.
     *
     * @param n     The number of disks to move.
     * @param start The starting tower (1, 2, or 3).
     * @param end   The destination tower (1, 2, or 3).
     */
    private static void hanoiIteration(int n, int start, int end) {
        int noOfMoves = (int) Math.pow(2, n) - 1;  // Total number of moves for n disks.
        int smallestDiskPos = start;               // Track the position of the smallest disk.
        int direction = (n % 2);                   // Determine the initial direction.
        if (end == 2) direction = 1 - direction;   // Adjust/flip direction if the end tower is 2.

        // Loop through all moves.
        for (int i = 0; i < noOfMoves; i++) {
            if (i % 2 == 0)
                smallestDiskPos = moveSmallestPiece(smallestDiskPos, direction); // Move the smallest disk.
            else
                moveRemainingPiece(smallestDiskPos); // Move a remaining disk between the other two towers.
        }
    }

    /**
     * Moves the smallest disk to the next position based on the given direction.
     * The method calculates the new position using the {@code cyclePosition} method,
     * moves the disk from its current position to the new position, and returns the
     * updated position of the smallest disk.
     * <br><br>
     * The direction determines whether the smallest disk moves left-to-right (increment)
     * or right-to-left (decrement). Each call to this method handles the movement for
     * a single iteration of the Tower of Hanoi algorithm.
     *
     * @param smallestDiskPos The current position of the smallest disk (1, 2, or 3).
     * @param direction       The direction of movement:
     *                        0 for left-to-right (increment),
     *                        1 for right-to-left (decrement).
     * @return The new position of the smallest disk after the move.
     */
    private static int moveSmallestPiece(int smallestDiskPos, int direction) {
        // Move the smallest piece
        int newPos = cyclePosition(smallestDiskPos, 1, direction);
        moveDisk(smallestDiskPos, newPos);
        smallestDiskPos = newPos;
        return smallestDiskPos;
    }

    /**
     * Moves one of the remaining disks between two towers, ensuring the smallest disk
     * is always placed on top of a larger disk. This method determines the two towers
     * not currently occupied by the smallest disk and selects the appropriate disk to move.
     * <br><br>
     * If one of the two remaining towers is empty, the disk from the non-empty tower
     * is moved to the empty tower. If both towers contain disks, the smaller top disk
     * is moved to the other tower to maintain the correct order.
     *
     * @param smallestDiskPos The current position of the smallest disk (1, 2, or 3).
     */
    private static void moveRemainingPiece(int smallestDiskPos) {
        // Move the remaining disk (smallest on top of largest)
        // Determine the two remaining tower identities.
        int leftTower = (smallestDiskPos == 1) ? 2 : 1;
        int rightTower = (smallestDiskPos == 3) ? 2 : 3;

        if (towers.get(leftTower).peek() == 0) {
            moveDisk(rightTower, leftTower);
            return;
        }

        if (towers.get(rightTower).peek() == 0) {
            moveDisk(leftTower, rightTower);
            return;
        }

        if (towers.get(leftTower).peek() < towers.get(rightTower).peek()) {
            moveDisk(leftTower, rightTower);
        } else {
            moveDisk(rightTower, leftTower);
        }
    }

    /**
     * Cycles through a fixed range of numbers (1 to 3) based on the given
     * step quantity and direction. This method ensures the value wraps
     * around correctly when exceeding the boundaries of the range.
     * <br><br>
     * If the direction is 0, the position is incremented (left-to-right).<br>
     * If the direction is 1, the position is decremented (right-to-left).
     * <br><br>
     * The calculation handles both positive and negative wrapping.
     *
     * @param currentPos The current position within the range (1, 2, or 3).
     * @param stepQty    The number of steps to shift the position.
     * @param direction  The direction to shift:
     *                   0 for left-to-right (increment),
     *                   1 for right-to-left (decrement).
     * @return The new position after applying the shift, within the range of 1 to 3.
     */
    private static int cyclePosition(int currentPos, int stepQty, int direction) {
        int lowerBound = 1;
        int upperBound = 3;
        int rangeSize = upperBound - lowerBound + 1;

        if (direction == 0) {
            return ((currentPos - lowerBound + stepQty) % rangeSize) + lowerBound;
        }

        return ((currentPos - lowerBound - stepQty + rangeSize) % rangeSize) + lowerBound;
    }

    /**
     * The moveDisk utility method moves the top disk from the starting tower to the
     * destination tower and prints the movement.
     *
     * @param start The key representing the starting tower.
     * @param end   The key representing the destination tower.
     */
    private static void moveDisk(int start, int end) {
        Stack startTower = towers.get(start);
        Stack endTower = towers.get(end);
        Stack.Node disk = startTower.pop();
        if (disk != null)
            endTower.push(disk.value);
        moveNo++;
        printTowers(start, end);
    }

    private static void printTowers(int start, int end) {
        System.out.println("Move Iteration Number: " + moveNo + " - start: " + start + " - end: " + end);
        towers.get(1).printTower();
        towers.get(2).printTower();
        towers.get(3).printTower();
        Print.printSeparator();
    }

    /**
     * Recursively solves the Tower of Hanoi puzzle by moving disks between three towers.
     * The method follows the rules of the puzzle, ensuring that only one disk is moved
     * at a time and no larger disk is placed on top of a smaller disk.
     * <br><br>
     * The recursive process involves:
     * <ul>
     *   <li>Moving (n-1) disks from the source tower to the auxiliary tower.</li>
     *   <li>Moving the largest disk directly from the source tower to the destination tower.</li>
     *   <li>Finally, moving the (n-1) disks from the auxiliary tower to the destination tower.</li>
     * </ul>
     * <br>
     * This recursive strategy continues until the base case is reached (n = 1), where only one
     * disk is moved directly from the source to the destination.
     *
     * @param n     The number of disks to move.
     * @param start The starting tower (1, 2, or 3).
     * @param end   The destination tower (1, 2, or 3).
     */
    private static void hanoiRecursive(int n, int start, int end) {
        // Base case: Move the smallest disk.
        if (n == 1) {
            System.out.println("SMALLEST DISK - n: " + n);
            moveDisk(start, end);  // Move the smallest disk directly.
        } else {
            int other = 6 - (start + end);  // Find the auxiliary tower.

            // Step 1: Move (n-1) disks from start to auxiliary.
            hanoiRecursive(n - 1, start, other);

            // Step 2: Move the largest disk from start to end.
            System.out.println("LARGEST DISK - n: " + n);
            moveDisk(start, end);

            // Step 3: Move (n-1) disks from auxiliary to end.
            hanoiRecursive(n - 1, other, end);
        }
    }

    /**
     * The moveDisk utility method moves the top disk from the starting tower to the
     * destination tower and prints the movement.
     *
     * @param start The key representing the starting tower.
     * @param end   The key representing the destination tower.
     */
    private static void moveDisk(int start, int end, int n) {
        Stack startTower = towers.get(start);
        Stack endTower = towers.get(end);
        endTower.push(startTower.pop().value);
        moveNo++;
        printTowers(start, end, n);
    }

    private static void printTowers(int start, int end, int n) {
        System.out.println("Move Iteration Number: " + moveNo + " - n: " + n + " - start: " + start + " - end: " + end);
        towers.get(1).printTower();
        towers.get(2).printTower();
        towers.get(3).printTower();
        Print.printSeparator();
    }
}
