package com.studies.array;

import com.studies.utils.Utils;

import java.util.Arrays;
import java.util.Scanner;

public class SearchAlgorithms {

    public static void main(String[] args) {
        int[] array = new int[8];

//        array = Utils.generateRandomIntegerArray(array.length);
        array = Utils.generateSortedIntegerArray(array.length);

        Utils.printArray(array);

        System.out.println("Qual numero você busca?");
        Scanner reader = new Scanner(System.in);

        int searchNumber = reader.nextInt();

        linearSearch(searchNumber, array);

    }

    //O(n)
    public static void linearSearch(int searchNumber, int[] array){
        boolean isPresent = false;
        int position = 0;
        for(int i = 0; i < array.length;i++){
            if(array[i] == searchNumber){
                isPresent = true;
                position = i;
                break;
            }
        }
        if(isPresent){
            System.out.println("Elemento encontrado na posição: " + position);
        }else{
            System.out.println("Valor não encontrado");
        }
    }
}
