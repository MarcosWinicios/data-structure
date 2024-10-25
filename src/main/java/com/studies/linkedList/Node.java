package com.studies.linkedList;


public class Node<Type> {

    private Type value;
    private Node<Type> next;

    public Node(Type newValue) {
        this.value = newValue;
    }

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    public Node<Type> getNext() {
        return next;
    }

    public void setNext(Node<Type> next) {
        this.next = next;
    }
}
