package com.studies.linkedList;

public class LinkedList {

    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void add(String newValue) {
        Node newNode = new Node(newValue);

        if (this.first == null && this.last == null) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }
        this.last = newNode;
        this.size++;

    }

    public void remove(String newValue) {

    }

    public Node get(int position){
        return  null;
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

