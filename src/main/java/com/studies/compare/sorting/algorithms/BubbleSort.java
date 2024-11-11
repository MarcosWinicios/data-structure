package com.studies.compare.sorting.algorithms;

import com.studies.compare.sorting.Result;

public class BubbleSort implements SortingAlgorithmsInterface{

    private final String name =  "BUBLE SORT";

    //O(N²)
    @Override
    public Result sort(int[] array) {
        int aux = 0;
        int exchangesCounter = 0;
        for (int i = 0; i < array.length; i++) {//(O(N)
            for (int j = i + 1; j < array.length; j++) {//O(N-1) -> O(N)
                if (array[i] > array[j]) {
                    aux = array[j];
                    array[j] = array[i];
                    array[i] = aux;
                    exchangesCounter++;
                }
            }
        }
        return new Result(array, exchangesCounter);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
