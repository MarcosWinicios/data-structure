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
        tree.inOrder(tree.getRoot()); //5 7 8 9 10 13 18 20

        System.out.println("\nImprimindo árvore Pré-ordem: ");
        tree.preOrder(tree.getRoot());//10 8 5 7 9 18 13 20

        System.out.println("\nImprimindo árvore Pós-ordem: ");
        tree.postOrder(tree.getRoot());
    }

}
