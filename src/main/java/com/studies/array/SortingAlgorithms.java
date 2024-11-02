package com.studies.array;

import com.studies.utils.Utils;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int size = 100000;
        int [] disorderedArray, sortedArray;

//        disorderedArray = Utils.generateUniqueRandomArray(array.length);
        disorderedArray = Utils.generateRandomIntegerArray(size);
//
//        System.out.println("Array desordenado: ");
//        Utils.printArray(disorderedArray);

        sortedArray = sortArrayBubleSort(disorderedArray);
//        System.out.println("Array ordenado: ");
//        Utils.printArray(sortedArray);

        sortedArray = sortArrayInsertionSort(disorderedArray);
//        System.out.println("Array ordenado: ");
//        Utils.printArray(sortedArray);

    }

    //O(N²)
    public static int[] sortArrayBubleSort(int [] array){
        System.out.println("\nOrdenando array de " + array.length + " posições com Bluble Sort");
        long init = System.currentTimeMillis();
        long end;

        int aux = 0;
        for(int i = 0; i < array.length; i++){//(O(N)
            for (int j = i + 1; j < array.length; j++){//O(N-1) -> O(N)
                if(array[i] > array[j]){
                    aux = array[j];
                    array[j] = array[i];
                    array[i] = aux;
                }
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Tempo: " + (end - init));
        return array;
    }

    //O(N²) -> Mais rápido que o buble sort
    public static int[] sortArrayInsertionSort(int[] array){
        System.out.println("\nOrdenando array de " + array.length + " posições com Insertion Sort");

        long init = System.currentTimeMillis();
        long end;

        int aux, j;
        for (int i = 1; i < array.length; i++){
            aux = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > aux){
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] =  aux;
        }

        end = System.currentTimeMillis();
        System.out.println("Tempo: " + (end - init));

        return array;
    }
}
