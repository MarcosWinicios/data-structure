package com.studies.linkedList;

public class LinkedList<Type> {

    private Node<Type> first;
    private Node<Type> last;
    private int size;

    public LinkedList() {
        this.size = 0;
    }

    public void add(Type newValue) {
        Node<Type>  newNode = new Node<Type>(newValue);

        if (this.first == null && this.last == null) {
            this.first = newNode;
        } else {
            this.last.setNext(newNode);
        }
        this.last = newNode;
        this.size++;

    }

    public void remove(Type value) {
        Node<Type>  previous = null;
        Node<Type>  current = this.first;

        for (int i = 0; i < this.size; i++) {
            if (current.getValue().equals(value)) {

                if(this.size == 1) {
                    this.first = null;
                    this.last = null;
                }else if(current == this.first){
                    this.first =  current.getNext();
                    current.setNext(null);
                } else if (current == this.last) {
                    previous.setNext(null);
                    this.last = previous;
                }else {
                    previous.setNext(current.getNext());
                    current = null;
                }
                this.size--;
                break;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public Node<Type>  get(int position) {
        //linear search algorithm
        return this.getLinearSearch(position);
    }

    private Node<Type>  getLinearSearch(int position) {
        Node<Type>  current = this.first;

        for (int i = 0; i < position; i++) {
            if (current.getNext() != null) {
                current = current.getNext();
            }
        }
        return current;
    }

    public Node<Type>  getFirst() {
        return first;
    }

    public void setFirst(Node<Type>  first) {
        this.first = first;
    }

    public Node<Type> getLast() {
        return last;
    }

    public void setLast(Node<Type>  last) {
        this.last = last;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

