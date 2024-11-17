package com.studies.compare.sorting.algorithms;

import com.studies.compare.sorting.Result;

public class QuickSort implements SortingAlgorithmsInterface{

    private final String name = "QUICK SORT";
    private long exchangesCounter;

    @Override
    public Result sort(int[] array) {
        exchangesCounter = 0L;

        quickSort(array, 0, array.length - 1);

        return new Result(array, exchangesCounter, this.name);
    }

    private void quickSort(int[] array, int left, int right){
        if(left < right){
            int pivot  = partition(array, left, right);
            quickSort(array, left, pivot);
            quickSort(array, pivot + 1, right);
        }
    }

    private int partition(int[] array, int left, int right) {
        int mid = (int) (left + right) / 2;
        int pivot = array[mid];
        int i =  left - 1;
        int j = right + 1;

        while (true){
            do {
                i++;
            }while (array[i] < pivot);

            do{
                j --;
            }while (array[j] > pivot);

            if(i >= j){
                return j;
            }
            int aux =  array[i];
            array[i] = array[j];
            array[j] = aux;

            exchangesCounter++;
        }
    }


    @Override
    public String getName() {
        return this.name;
    }
}
