package com.studies.compare.sorting.algorithms;

import com.studies.compare.sorting.Result;

public class InsertionSort implements SortingAlgorithmsInterface{

    private final String name =  "INSERTION SORT";

    //O(N²) -> Mais rápido que o buble sort
    @Override
    public Result sort(int[] array) {
        int aux, j;
        for (int i = 1; i < array.length; i++) {//O(N)
            aux = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > aux) {//O(N-1) -> O(N)
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = aux;
        }

        return new Result(array, 0);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
