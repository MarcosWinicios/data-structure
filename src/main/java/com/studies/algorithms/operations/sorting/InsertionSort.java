package com.studies.algorithms.operations.sorting;

import com.studies.algorithms.metrics.ResultSorting;

public class InsertionSort implements SortingAlgorithmsInterface{

    private final String name =  "INSERTION SORT";

    //O(N²) -> Mais rápido que o buble sort
    @Override
    public ResultSorting sort(int[] array) {
        long exchangesCounter = 0L;

        int aux, j;
        for (int i = 1; i < array.length; i++) {//O(N)
            aux = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > aux) {//O(N-1) -> O(N)
                array[j + 1] = array[j];
                j--;
                exchangesCounter++;
            }
            array[j + 1] = aux;
            exchangesCounter++;
        }

        return new ResultSorting(array, exchangesCounter, this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
