package com.studies.stack;

import com.studies.linkedList.LinkedList;

public class Stack<Type> {

    LinkedList<Type> list;

    public Stack(){
        this.list =  new LinkedList<>();
    }

    public  void add(Type newValue){
        this.list.addStart(newValue);
    }

    public void remove(){
        this.list.remove(this.get());
    }

    public Type get(){
        return this.list.getFirst().getValue();
    }
}
