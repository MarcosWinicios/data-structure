package com.studies.array;

import com.studies.utils.Utils;

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
        binarySearch(searchNumber, array);

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

    public static void binarySearch(int searchNumber, int[] array){
        boolean isPresent = false;
        int init = 0;
        int end = array.length -1;
        int mid;
        int position = 0;

        while (init <= end){
            mid = (int) ((end + init) / 2);
            if(array[mid] == searchNumber){
                isPresent = true;
                position = mid;
                break;
            }else if(array[mid] < searchNumber){
                init = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        if(isPresent){
            System.out.println("Elemento encontrado na posição: " + position);
        }else{
            System.out.println("Valor não encontrado");
        }
    }
}
