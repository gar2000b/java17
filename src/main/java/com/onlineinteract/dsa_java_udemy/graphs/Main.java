package com.onlineinteract.dsa_java_udemy.graphs;

import com.onlineinteract.utility.Print;

public class Main {
    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.printGraph();
        Print.printSeparator();

        myGraph = new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("B", "C");
        myGraph.printGraph();
        Print.printSeparator();

        myGraph.removeEdge("A", "B");
        myGraph.printGraph();
        Print.printSeparator();

        myGraph = new Graph();
        myGraph.addVertex("A");
        myGraph.addVertex("B");
        myGraph.addVertex("C");
        myGraph.addVertex("D");
        myGraph.addEdge("A", "B");
        myGraph.addEdge("A", "C");
        myGraph.addEdge("A", "D");
        myGraph.addEdge("B", "C");
        myGraph.addEdge("C", "D");
        myGraph.printGraph();
        Print.printSeparator();

        myGraph.removeVertex("D");
        myGraph.printGraph();
        Print.printSeparator();
    }
}
