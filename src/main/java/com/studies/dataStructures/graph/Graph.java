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
        Vertex<Type> start = this.getVertex(startData);
        Vertex<Type> finish = this.getVertex(finishData);

        Edge<Type> newEdge = new Edge<>(weight, start, finish);
        start.addExitEdges(newEdge);
        finish.addEntranceEdges(newEdge);

        this.edges.add(newEdge);
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

    public void breadthFirstSearch(){
        List<Vertex<Type>> markedList =  new ArrayList<>();
        List<Vertex<Type>> queue =  new ArrayList<>();

        Vertex<Type> current = this.vertices.getFirst();
//        Vertex<Type> current = this.vertices.get(4);

        markedList.add(current);

        System.out.println(current.getData());

        queue.add(current);

        while (!queue.isEmpty()){
            Vertex<Type> visited = queue.getFirst();

            for (int i = 0; i < visited.getExitEdges().size(); i++){
                Vertex<Type> next = visited.getExitEdges().get(i).getFinish();
                if(!markedList.contains(next)){//se o vértice ainda não foi marcado
                    markedList.add(next);
                    System.out.println(next.getData());
                    queue.add(next);
                }
            }

            queue.removeFirst();
        }

    }
}
