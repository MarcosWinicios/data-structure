package com.studies.algorithms.programs;

import com.studies.algorithms.metrics.ResultSorting;
import com.studies.algorithms.sorting.BubbleSort;
import com.studies.algorithms.sorting.HeapSort;
import com.studies.algorithms.sorting.InsertionSort;
import com.studies.algorithms.sorting.QuickSort;
import com.studies.algorithms.sorting.SelectionSort;
import com.studies.algorithms.sorting.ShellSort;
import com.studies.algorithms.sorting.SortingAlgorithmsInterface;
import com.studies.algorithms.repository.SortingRepository;
import com.studies.config.ConnectionDatabase;
import com.studies.utils.Utils;

import java.util.UUID;

public class SortingAlgorithmsTest {

    private final static int[] DESORDERED_ARRAY = Utils.generateRandomIntegerArray(10);
//    private final static int[] DESORDERED_ARRAY = {2, 10, 4, 7, 1, 8, 9, 3, 6, 5};
//    private static String groupId = "2cb9a8f1-4c65-41d7-8a1a-46f2ff425350";
    private static String groupId;

    public static void main(String[] args) {

        ConnectionDatabase.getInstance();

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

        ResultSorting result = sortInterface.sort(array);

        end = System.currentTimeMillis();

        result.setTime(end - init);
        result.setGroupId(getGroupId());

        System.out.println(result.toString() + "\n");
        Utils.printLine(result.toString().length());

        new SortingRepository().save(result);
    }

    private static String getGroupId(){
        if(groupId == null){
            groupId = UUID.randomUUID().toString();
        }
        return groupId;
    }
}
