package com.studies.dataStructures.graph;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Edge<Type> {

    private Double weight;
    private Vertex<Type> start;
    private Vertex<Type> finish;

    public Edge(Double weight, Vertex<Type> start, Vertex<Type> finish) {
        this.weight = weight;
        this.start = start;
        this.finish = finish;
    }
}
