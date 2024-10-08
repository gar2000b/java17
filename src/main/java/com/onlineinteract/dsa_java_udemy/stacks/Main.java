package com.onlineinteract.dsa_java_udemy.stacks;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack(4);
        stack.getTop();
        stack.getHeight();
        stack.printStack();
        Print.printSeparator();

        stack = new Stack(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.printStack();
        Print.printSeparator();

        stack = new Stack(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.getHeight();
        stack.printStack();
        Print.printSeparator();
    }
}
