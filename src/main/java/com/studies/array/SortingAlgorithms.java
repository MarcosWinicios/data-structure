package com.studies.array;

import com.studies.utils.Utils;

import java.util.Arrays;

public class SortingAlgorithms {

    private final static Boolean PRINT_ARRAYS_ENABLE = true;
    private final  static String SORTED_ARRAY_MESSAGE =  "Array ordenado";
    private final  static String DESORDERED_ARRAY_MESSAGE =  "Array desordenado";
    private final static int[] DESORDERED_ARRAY = Utils.generateRandomIntegerArray(10);

    public static void main(String[] args) {
        printArray(DESORDERED_ARRAY, DESORDERED_ARRAY_MESSAGE);

        int[] disorderedArray1 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
        int[] disorderedArray2 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);

        sortArrayBubleSort(disorderedArray1);
        sortArrayInsertionSort(disorderedArray2);

    }

    private static void printArray(int[] array){
        printArray(array, SORTED_ARRAY_MESSAGE);
    }

    private static void printArray(int[] array, String message){
        if(PRINT_ARRAYS_ENABLE){
            Utils.printArray(array, message);
        }
        Utils.printLine();
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

        printArray(array);
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

        printArray(array);
        return array;
    }
}
