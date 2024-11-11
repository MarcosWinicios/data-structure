package com.studies.compare.sorting.algorithms;

import com.studies.compare.sorting.Result;

public class SelectionSort implements SortingAlgorithmsInterface{

    private final String name = "SELECTION SORT";

    //O(N²)
    @Override
    public Result sort(int[] array) {
        int minorElementPosition, aux;
        int exchangesCounter = 0;
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

        return new Result(array, exchangesCounter);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
