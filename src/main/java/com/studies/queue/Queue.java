package com.studies.queue;

import com.studies.linkedList.LinkedList;

public class Queue {

    private LinkedList<String> list;

    public Queue(){
        this.list =  new LinkedList<>();
    }

    public void add(String newValue){
        this.list.add(newValue);
    }

    public void remove(){
        this.list.remove(this.get());
    }

    public String get(){
        return this.list.getFirst().getValue();
    }


}
