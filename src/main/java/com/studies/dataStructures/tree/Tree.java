package com.studies.dataStructures.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tree<Type extends Comparable> {

    private Element<Type> root;
    private boolean auxPrintFirst = false;

    public Tree() {
        this.root = null;
    }


    public void add(Type value) {
        Element<Type> newElement = new Element<>(value);

        if (this.root == null) {
            this.root = newElement;
        } else {
            Element<Type> current = this.root;
            while (true) {
                if (newElement.getValue().compareTo(current.getValue()) < 0) {
                    if (current.getLeft() != null) {
                        current = current.getLeft();
                    } else {
                        current.setLeft(newElement);
                        break;
                    }
                } else { //se o novo elemento for maior ou igual
                    if (current.getRight() != null) {
                        current = current.getRight();
                    } else {
                        current.setRight(newElement);
                        break;
                    }
                }
            }
        }
    }

    public void inOrder(Element<Type> current) {

        if (current != null) {
            inOrder(current.getLeft());
            System.out.print(current.getValue() + " ");
            inOrder(current.getRight());
        }
    }

    public void preOrder(Element<Type> current) {
        if (current != null) {
            System.out.print(current.getValue() + " ");
            preOrder(current.getLeft());
            preOrder(current.getRight());
        }
    }

    public void postOrder(Element<Type> current) {

        if (current != null) {
            postOrder(current.getLeft());
            postOrder(current.getRight());
            System.out.print(current.getValue() + " ");
        }
    }

    public boolean remove(Type value) {
        //buscar o elemento na árvore
        Element<Type> current = this.root;
        Element<Type> currentParent = null;

        while (current != null) {
            if (current.getValue().equals(value)) {
                //remover o elemento da árvore
                break;
            } else if (value.compareTo(current.getValue()) < 0) { // valor procurado é menor que o atual
                currentParent = current;
                current = current.getLeft();
            } else {
                currentParent = current;
                current = current.getRight();
            }
        }

        if (current != null) {
            if (current.getRight() != null) { // elemento tem dois filhos ou tem somente filhos somente à direita
                Element<Type> substitute = current.getRight();
                Element<Type> substituteParent = current;

                while (substitute.getLeft() != null) {
                    substituteParent = substitute;
                    substitute = substitute.getLeft();
                }
                substitute.setLeft(current.getLeft());
                if (currentParent != null) {
                    if (current.getValue().compareTo(currentParent.getValue()) == -1) {// atual < pai
                        currentParent.setLeft(substitute);
                    } else {
                        currentParent.setRight(substitute);
                    }
                } else { // se não tem currentParent, então é a raiz
                    this.root = substitute;
                }

                //remover o elemento da árvore
                if (substitute.getValue().compareTo(substituteParent.getValue()) == -1) {// substituto < pai do substituto
                    substituteParent.setLeft(null);
                } else {
                    substituteParent.setRight(null);
                }
            } else if (current.getLeft() != null) {//elemento tem filgos somente à esquedra
                Element<Type> substitute = current.getLeft();
                Element<Type> substituteParent = current;

                while (substitute.getRight() != null) {
                    substituteParent = substitute;
                    substitute = substitute.getRight();
                }

                if (currentParent != null) {
                    if (current.getValue().compareTo(currentParent.getValue()) == -1) {// atual < pai
                        currentParent.setLeft(substitute);
                    } else {
                        currentParent.setRight(substitute);
                    }
                } else {
                    this.root = substitute;
                }

                //remover o elemento da árvore
                if (substitute.getValue().compareTo(substituteParent.getValue()) == -1) {// substituto < pai do substituto
                    substituteParent.setLeft(null);
                } else {
                    substituteParent.setRight(null);
                }
            } else {//não tem filho
                if (currentParent != null) {
                    if (current.getValue().compareTo(currentParent.getValue()) == -1) {// atual < pai
                        currentParent.setLeft(null);
                    } else {
                        currentParent.setRight(null);
                    }
                }else{ //elemento é a raiz
                    this.root = null;
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
