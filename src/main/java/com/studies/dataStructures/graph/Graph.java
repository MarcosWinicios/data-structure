package com.studies.dataStructures.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<Type> {

    private List<Vertex<Type>> vertices;
    private List<Edge<Type>> edges;

    public Graph(){
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    }

    public void addVertex(Type data){
        Vertex<Type> newVertex = new Vertex<>(data);
        this.vertices.add(newVertex);
    }

    public void addEdge(Double weight, Type startData, Type finishData){

    }

    public Vertex<Type> getVertex(Type data){
        Vertex<Type> vertex = null;

        for(Vertex<Type> item : this.vertices){
            if(item.getData().equals(data)){
                vertex = item;
                break;
            }
        }
        return vertex;
    }
}
