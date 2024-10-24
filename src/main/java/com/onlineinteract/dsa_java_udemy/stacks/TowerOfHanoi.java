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
        tower1.push(5);
        tower1.push(4);
        tower1.push(3);
        tower1.push(2);
        tower1.push(1);
        tower1.printStack();
        towers.put(1, tower1);

        // Initialize Tower 2 (empty).
        Stack tower2 = new Stack();
        tower2.setName("Tower 2");
        tower2.printStack();
        towers.put(2, tower2);

        // Initialize Tower 3 (empty).
        Stack tower3 = new Stack();
        tower3.setName("Tower 3");
        tower3.printStack();
        towers.put(3, tower3);

        // Start the Tower of Hanoi algorithm to move all disks from Tower 1 to Tower 3.
        System.out.println("Algo commencing printing out each start -> end movement:\n");
        hanoi(tower1.height, 1, 3);
        Print.printSeparator();
        System.out.println("Algo Complete");
        Print.printSeparator();

        // Print the final state of all towers.
        tower1.printStack();
        tower2.printStack();
        tower3.printStack();
    }

    /**
     * The hanoi method recursively solves the Tower of Hanoi problem.
     * It moves disks from the starting tower to the ending tower while following
     * the rules of the puzzle.
     *
     * @param n     The number of disks to move.
     * @param start The key representing the starting tower.
     * @param end   The key representing the destination tower.
     */
    private static void hanoi(int n, int start, int end) {
        if (n == 1) {
            moveDisk(start, end);
        } else {
            int other = 6 - (start + end);
            hanoi(n - 1, start, other);
            moveDisk(start, end);
            hanoi(n - 1, other, end);
        }
    }

    /**
     * The moveDisk utility method moves the top disk from the starting tower to the
     * destination tower and prints the movement.
     *
     * @param start The key representing the starting tower.
     * @param end   The key representing the destination tower.
     */
    private static void moveDisk(int start, int end) {
        System.out.println(start + " -> " + end);
        Stack startTower = towers.get(start);
        Stack endTower = towers.get(end);
        endTower.push(startTower.pop().value);
    }
}
