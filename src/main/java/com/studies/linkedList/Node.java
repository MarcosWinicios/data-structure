package com.studies.linkedList;


public class Node {

    private String value;
    private Node next;

    public Node(String newValue) {
        this.value = newValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}