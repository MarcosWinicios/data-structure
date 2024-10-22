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

    public void remove(String value) {
         Node previous = null;
         Node current = this.first;

         for(int i = 0 ; i < this.size; i++){
            if(current.getValue().equalsIgnoreCase(value)){
                previous.setNext(current.getNext());
                current = null;
                this.size--;
                break;
            }
            previous =  current;
            current =  current.getNext();
         }
    }

    public Node get(int position) {
        //linear search algorithm
        return this.getLinearSearch(position);
    }

    private Node getLinearSearch(int position){
        Node current = this.first;

        for(int i = 0; i < position; i++){
            if(current.getNext() != null){
                current = current.getNext();
            }
        }
        return current;
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

