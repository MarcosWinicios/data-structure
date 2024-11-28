package com.studies.dataStructures.graph;

public class Program {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();

        graph.addVertex("João");
        graph.addVertex("Lorenzo");
        graph.addVertex("Creuza");
        graph.addVertex("Créber");
        graph.addVertex("Cráudio");

        graph.addEdge(2.0, "João", "Lorenzo");
        graph.addEdge(3.0, "Lorenzo", "Créber");
        graph.addEdge(1.0, "Créber", "Creuza");
        graph.addEdge(1.0, "João", "Creuza");
        graph.addEdge(2.0, "Cráudio", "Lorenzo");
        graph.addEdge(3.0, "Cráudio", "João");

        graph.breadthFirstSearch();
    }
}
