package com.studies.compare.sorting;

import com.studies.compare.sorting.algorithms.BubleSort;
import com.studies.compare.sorting.algorithms.SortingAlgorithmsInterface;
import com.studies.utils.Utils;

public class Main {

    private final static int[] DESORDERED_ARRAY = Utils.generateRandomIntegerArray(10);

    public static void main(String[] args) {
        SortingAlgorithmsInterface bubleSort = new BubleSort();

        execute(bubleSort, DESORDERED_ARRAY.clone());
    }

    public static void execute(SortingAlgorithmsInterface sortInterface, int[] array){

        System.out.println(sortInterface.getMessage() + ": \n");

        long init = System.currentTimeMillis();
        long end;

        Result result = sortInterface.sort(array);

        end = System.currentTimeMillis();

        System.out.println(result.toString());
    }
}
