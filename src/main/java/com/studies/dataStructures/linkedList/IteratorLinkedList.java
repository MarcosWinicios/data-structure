package com.studies.dataStructures.linkedList;

public class IteratorLinkedList<Type> {

    private Node<Type> element;

    public IteratorLinkedList(Node<Type> current) {
        this.element = current;
    }

    public boolean hasNext(){
        if(this.element == null) return false;

        return this.element.getNext() != null;
    }

    public Node<Type> getNext(){
        this.element =  this.element.getNext();
        return this.element.getNext();
    }

    public Node<Type> getElement() {
        return element;
    }
}
