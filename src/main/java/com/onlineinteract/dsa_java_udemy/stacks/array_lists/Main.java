package com.onlineinteract.dsa_java_udemy.stacks.array_lists;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.printStack();
        Print.printSeparator();

        Integer result = myStack.pop();
        System.out.println("Node removed with value: " + result);
        myStack.printStack();
        Print.printSeparator();

        String stringResult = reverseString("hello");
        System.out.println(stringResult);
        Print.printSeparator();

        String input = "((()))";
        boolean balancedParentheses = isBalancedParentheses(input);
        System.out.println("Parentheses balanced: " + balancedParentheses);
        Print.printSeparator();

        myStack = new Stack<>();

        myStack.push(4);
        myStack.push(1);
        myStack.push(5);
        myStack.push(2);
        myStack.push(3);
        sortStack(myStack);
        myStack.printStack();
        Print.printSeparator();
    }

    public static String reverseString(String myString) {
        if (myString.isEmpty()) {
            return "";
        }

        String result = "";
        Stack<Character> myStack = new Stack<>();

        for (Character character : myString.toCharArray()) {
            myStack.push(character);
        }

        while (!myStack.isEmpty()) {
            result += myStack.pop();
        }

        return result;
    }

    public static boolean isBalancedParentheses(String input) {
        if (input.length() == 0) {
            return true;
        }

        if (input.length() == 1) {
            return false;
        }

        Stack<Character> myStack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (c.equals('(')) {
                myStack.push(c);
            } else if (c.equals(')')) {
                myStack.pop();
            }
        }

        if (myStack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void sortStack(Stack<Integer> originalStack) {
        Stack<Integer> sortedStack = new Stack<>();

        while (!originalStack.isEmpty()) {
            Integer topOriginal = originalStack.peek();
            Integer topSorted = sortedStack.peek();

            if (topOriginal == null) {
                break;
            }

            if (topSorted == null) {
                sortedStack.push(originalStack.pop());
                continue;
            }

            if (topOriginal < topSorted) {
                /**
                 * Loop to move topOriginal down to correct position
                 */
                topOriginal = originalStack.pop();
                while (topOriginal < topSorted) {
                    originalStack.push(sortedStack.pop());
                    topSorted = sortedStack.peek();
                    if (topSorted == null) {
                        break;
                    }
                }
                sortedStack.push(topOriginal);
            } else {
                sortedStack.push(originalStack.pop());
            }
        }

        while (!sortedStack.isEmpty()) {
            originalStack.push(sortedStack.pop());
        }
    }
}
