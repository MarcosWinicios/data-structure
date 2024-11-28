package com.studies.dataStructures.graph;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Vertex<Type> {

    private Type data;
    private List<Edge<Type>> entranceEdges;
    private List<Edge<Type>> exitEdges;

    public  Vertex(Type data){
        this.data = data;
        this.entranceEdges = new ArrayList<>();
        this.exitEdges = new ArrayList<>();
    }

    public void addEntranceEdges(Edge<Type> edge){
        this.entranceEdges.add(edge);
    }

    public void addExitEdges(Edge<Type> edge){
        this.exitEdges.add(edge);
    }
}
