package com.studies.compare;

import com.studies.linkedList.LinkedList;

import java.util.ArrayList;

public class CompareArrayAndLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        ArrayList<Integer> array = new ArrayList<>();

        System.out.println("__Adicionar elementos__");

        //array
        int limit = 10000;
        long initialTime =  System.currentTimeMillis();
        long finalTime;

        for(int i = 0; i < limit; i++){
            array.add(i);
        }

        finalTime = System.currentTimeMillis();

        System.out.println("Adicionou " + limit + " elemenetos no vetor: ");
        System.out.println(finalTime - initialTime);

        //linkedlist
        initialTime =  System.currentTimeMillis();
        for(int i = 0; i < limit; i++){
            linkedList.add(i);
        }

        finalTime = System.currentTimeMillis();

        System.out.println("\nAdicionou " + limit + " elemenetos no linkedList: ");
        System.out.println(finalTime - initialTime);

        System.out.println("\n__Ler valores__");
        //array
        initialTime = System.currentTimeMillis();
        for(int i = 0; i < array.size(); i++){
            array.get(i);
        }

        finalTime = System.currentTimeMillis();

        System.out.println("\nTempo de leitura do vetor: ");
        System.out.println(finalTime - initialTime);

        //linkedlist
        initialTime = System.currentTimeMillis();
        for(int i = 0; i < linkedList.getSize(); i++){
            linkedList.get(i);
        }

        finalTime = System.currentTimeMillis();

        System.out.println("\nTempo de leitura do likedList: ");
        System.out.println(finalTime - initialTime);

    }
}
