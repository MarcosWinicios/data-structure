package com.studies.algorithms.operations.sorting;

import com.studies.algorithms.metrics.ResultSorting;

public class SelectionSort implements SortingAlgorithmsInterface{

    private final String name = "SELECTION SORT";

    //O(N²)
    @Override
    public ResultSorting sort(int[] array) {
        int minorElementPosition, aux;
        long exchangesCounter = 0L;
        for (int i = 0; i < array.length; i++) {//O(N)

            minorElementPosition = i;
            for (int j = i + 1; j < array.length; j++) {//O(N-1) -> O(N)

                if (array[j] < array[minorElementPosition]) {
                    minorElementPosition = j;
                }
            }
            aux = array[minorElementPosition];
            array[minorElementPosition] = array[i];
            array[i] = aux;

            exchangesCounter++;
        }

        return new ResultSorting(array, exchangesCounter, this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
