package com.studies.compare;

import com.studies.dataStructures.linkedList.IteratorLinkedList;
import com.studies.dataStructures.linkedList.LinkedList;

import java.util.ArrayList;

public class CompareArrayAndLinkedList {

    private static ArrayList<Integer> array = new ArrayList<>();
    private static LinkedList<Integer> linkedList = new LinkedList<>();

    private static long initialTime;
    private static long finalTime;

    public static void main(String[] args) {

        compareAddOperation(100000);
        compareReadOperation();

    }

    public static void compareAddOperation(int limit){
        System.out.println("*** Adicionar elementos ***");
        initialTime =  System.currentTimeMillis();

        for(int i = 0; i < limit; i++){
            array.add(i);
        }
        finalTime = System.currentTimeMillis();

        System.out.println("Adicionou " + limit + " elementos ao vetor: ");
        System.out.println(finalTime - initialTime);

        //linkedlist
        initialTime =  System.currentTimeMillis();
        for(int i = 0; i < limit; i++){
            linkedList.add(i);
        }

        finalTime = System.currentTimeMillis();

        System.out.println("\nAdicionou " + limit + " elemenetos ao linkedList: ");
        System.out.println(finalTime - initialTime);
    }

    public static void compareReadOperation(){
        System.out.println("\n*** Ler valores ***");
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

        System.out.println("\nTempo de leitura do likedList SEM iterator: ");
        System.out.println(finalTime - initialTime);

        initialTime = System.currentTimeMillis();
        IteratorLinkedList<Integer> iterator = linkedList.getIterator();

        while (iterator.hasNext()){
            iterator.getNext();
        }

        finalTime = System.currentTimeMillis();

        System.out.println("\nTempo de leitura do likedList COM iterator: ");
        System.out.println(finalTime - initialTime);

    }
}
