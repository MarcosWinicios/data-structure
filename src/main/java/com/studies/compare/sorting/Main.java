package com.studies.compare.sorting;

import com.studies.compare.sorting.algorithms.BubbleSort;
import com.studies.compare.sorting.algorithms.HeapSort;
import com.studies.compare.sorting.algorithms.InsertionSort;
import com.studies.compare.sorting.algorithms.QuickSort;
import com.studies.compare.sorting.algorithms.SelectionSort;
import com.studies.compare.sorting.algorithms.ShellSort;
import com.studies.compare.sorting.algorithms.SortingAlgorithmsInterface;
import com.studies.utils.Utils;

public class Main {

//    private final static int[] DESORDERED_ARRAY = Utils.generateRandomIntegerArray(10);
    private final static int[] DESORDERED_ARRAY = {2, 10, 4, 7, 1, 8, 9, 3, 6, 5};

    public static void main(String[] args) {
        SortingAlgorithmsInterface bubbleSort = new BubbleSort();
        SortingAlgorithmsInterface insertionSort =  new InsertionSort();
        SortingAlgorithmsInterface selectionSort = new SelectionSort();
        SortingAlgorithmsInterface heapSort = new HeapSort();
        SortingAlgorithmsInterface quickSort = new QuickSort();
        SortingAlgorithmsInterface shellSort = new ShellSort();

        execute(bubbleSort, DESORDERED_ARRAY.clone());
        execute(insertionSort, DESORDERED_ARRAY.clone());
        execute(selectionSort, DESORDERED_ARRAY.clone());
        execute(heapSort, DESORDERED_ARRAY.clone());
        execute(quickSort, DESORDERED_ARRAY.clone());
        execute(shellSort, DESORDERED_ARRAY.clone());
    }

    public static void execute(SortingAlgorithmsInterface sortInterface, int[] array){

        System.out.println(sortInterface.getMessage() + ": ");

        long init = System.currentTimeMillis();
        long end;

        Result result = sortInterface.sort(array);

        end = System.currentTimeMillis();
        result.setTime(end - init);

        System.out.println(result.toString() + "\n");

        Utils.printLine(result.toString().length());
    }
}
