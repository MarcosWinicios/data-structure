package com.studies.dataStructures.queue;

import com.studies.dataStructures.linkedList.LinkedList;

public class Queue<Type> {

    private LinkedList<Type> list;

    public Queue(){
        this.list =  new LinkedList<>();
    }

    public void add(Type newValue){
        this.list.add(newValue);
    }

    public void remove(){
        this.list.remove(this.get());
    }

    public Type get(){
        return this.list.getFirst().getValue();
    }


}
