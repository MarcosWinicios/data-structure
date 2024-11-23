package com.studies.stack;

import com.studies.linkedList.LinkedList;

public class Stack {

    LinkedList<String> list;

    public Stack(){
        this.list =  new LinkedList<>();
    }

    public  void add(String newValue){
        this.list.addStart(newValue);
    }

    public void remove(){
        this.list.remove(this.get());
    }

    public String get(){
        return this.list.getFirst().getValue();
    }
}
