package com.studies.compare.sorting.algorithms;

import com.studies.compare.sorting.Result;

public class ShellSort implements SortingAlgorithmsInterface{

    private final String name = "SHELL SORT";

    @Override
    public Result sort(int[] array) {
        int exchangesCounter = 0;
        int h = 1;
        int size = array.length;

        while (h < size){
            h = h * 3 + 1;
        }

        h = (int) Math.floor(h / 3);

        int element, j;

        while (h > 0){
            for(int i = h; i < size; i++){
                element = array[i];
                j = i;

                while (j >= h && array[j - h] > element){
                    array[j] = array[j - h];
                    j = j - h;
                    exchangesCounter++;
                }
                array[j] = element;
                exchangesCounter++;
            }
            h = h /2;
        }

        return new Result(array, exchangesCounter);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
