package com.studies.array;

import com.studies.utils.Utils;

public class SortingAlgorithms {

    public static void main(String[] args) {
        int [] array = new int[10];

//        array = Utils.generateUniqueRandomArray(array.length);
        array = Utils.generateRandomIntegerArray(array.length);

        System.out.println("Array desordenado: ");
        Utils.printArray(array);

        array = sortArrayBubleSort(array);

        System.out.println("Array ordenado: ");
        Utils.printArray(array);
    }

    //O(N²)
    public static int[] sortArrayBubleSort(int [] array){
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
}
