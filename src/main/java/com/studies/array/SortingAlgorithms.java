package com.studies.array;

import com.studies.utils.Utils;

public class SortingAlgorithms {

    private final static Boolean PRINT_ARRAYS_ENABLE = true;
    private final  static String SORTED_ARRAY_MESSAGE =  "Array ordenado";
    private final  static String DESORDERED_ARRAY_MESSAGE =  "Array desordenado";

    public static void main(String[] args) {
        int size = 10;
        int[] disorderedArray = Utils.generateRandomIntegerArray(size);

        Utils.printArray(disorderedArray, DESORDERED_ARRAY_MESSAGE, PRINT_ARRAYS_ENABLE);

        sortArrayBubleSort(disorderedArray);
        sortArrayInsertionSort(disorderedArray);
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

        Utils.printArray(array, SORTED_ARRAY_MESSAGE, PRINT_ARRAYS_ENABLE);
        Utils.printLine();
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

        Utils.printArray(array, SORTED_ARRAY_MESSAGE, PRINT_ARRAYS_ENABLE);
        Utils.printLine();
        return array;
    }
}
