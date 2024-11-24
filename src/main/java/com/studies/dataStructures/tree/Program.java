package com.studies.dataStructures.tree;

public class Program {

    public static void main(String[] args) {
        Tree<Integer> tree =  new Tree<>();

        tree.add(10);
        tree.add(8);
        tree.add(5);
        tree.add(9);
        tree.add(7);
        tree.add(18);
        tree.add(13);
        tree.add(20);

        System.out.println("Imprimindo árvore Em-ordem: ");
        tree.inOrder(tree.getRoot());

        System.out.println("Imprimindo árvore Pré-ordem: ");
        tree.preOrder(tree.getRoot());
    }

}
