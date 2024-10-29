package com.studies.linkedList;

public class IteratorLinkedList<Type> {

    private Node<Type> element;

    public IteratorLinkedList(Node<Type> current) {
        this.element = current;
    }

    public boolean hasNext(){
        return this.element.getNext() != null;
    }

    public Node<Type> getNext(){
        this.element =  this.element.getNext();
        return this.element.getNext();
    }
}
