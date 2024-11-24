package com.studies.dataStructures.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tree<Type extends Comparable> {

    private Element<Type> root;

    public Tree(){
        this.root = null;
    }


    public void add(Type value){
        Element<Type> newElement =  new Element<>(value);

        if(this.root == null){
            this.root = newElement;
        }else{
            Element<Type> current =  this.root;
            while (true){
                if(newElement.getValue().compareTo(current.getValue()) < 0){
                    if(current.getLeft() != null){
                        current = current.getLeft();
                    }else{
                        current.setLeft(newElement);
                        break;
                    }
                }else { //se o novo elemento for maior ou igual
                    if(current.getRight() != null){
                        current = current.getRight();
                    }else{
                        current.setRight(newElement);
                        break;
                    }
                }
            }
        }
    }

    public void inOrder(Element<Type> current) {

        if(current != null) {
            inOrder(current.getLeft());
            System.out.println(current.getValue());
            inOrder(current.getRight());
        }
    }
}
