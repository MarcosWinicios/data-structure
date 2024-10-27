package com.studies.compare;

import com.studies.linkedList.LinkedList;

import java.util.ArrayList;

public class CompareArrayAndLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        ArrayList<Integer> array = new ArrayList<>();

        //add elements
        int limit = 1000000;

        long initialTime =  System.currentTimeMillis();
        long finalTime;

        for(int i = 0; i < limit; i++){
            array.add(i);
        }

        finalTime = System.currentTimeMillis();

        System.out.println("Adicionou " + limit + " elemenetos no vetor: ");
        System.out.println(finalTime - initialTime);

        // -------
        initialTime =  System.currentTimeMillis();
        for(int i = 0; i < limit; i++){
            linkedList.add(i);
        }

        finalTime = System.currentTimeMillis();

        System.out.println("\n\nAdicionou " + limit + " elemenetos no linkedList: ");
        System.out.println(finalTime - initialTime);
    }
}
