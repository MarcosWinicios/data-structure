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
        tree.printInOrder(); //5 7 8 9 10 13 18 20

//        remove(tree, 20);
//        remove(tree, 5);
//        remove(tree, 8);
//        remove(tree, 9);
//        remove(tree, 13);
//        remove(tree, 7);
//        remove(tree, 18);
//        remove(tree, 10);


        System.out.println("\nImprimindo árvore Pré-ordem: ");
        tree.printPreOrder();//10 8 5 7 9 18 13 20

        System.out.println("\nImprimindo árvore Pós-ordem: ");
        tree.printPostOrder();
    }

    private static void remove(Tree<Integer> tree, Integer value){

        tree.remove(value);
        System.out.println("\nImprimindo árvore Em-ordem após a remoção do valor: " + value);
        tree.printInOrder();
    }

}
