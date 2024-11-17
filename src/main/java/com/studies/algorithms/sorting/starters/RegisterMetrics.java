package com.studies.algorithms.sorting.starters;

import com.studies.algorithms.sorting.model.Result;
import com.studies.algorithms.sorting.operations.BubbleSort;
import com.studies.algorithms.sorting.operations.HeapSort;
import com.studies.algorithms.sorting.operations.InsertionSort;
import com.studies.algorithms.sorting.operations.QuickSort;
import com.studies.algorithms.sorting.operations.SelectionSort;
import com.studies.algorithms.sorting.operations.ShellSort;
import com.studies.algorithms.sorting.operations.SortingAlgorithmsInterface;
import com.studies.algorithms.sorting.service.ResultService;
import com.studies.config.ConnectionDatabase;
import com.studies.utils.Utils;

import java.util.UUID;

public class RegisterMetrics {

    private final static int[] DESORDERED_ARRAY = Utils.generateRandomIntegerArray(1000000);
//    private final static int[] DESORDERED_ARRAY = {2, 10, 4, 7, 1, 8, 9, 3, 6, 5};
    private static String groupId = "2cb9a8f1-4c65-41d7-8a1a-46f2ff425350";
//    private static String groupId;

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

        Result result = sortInterface.sort(array);

        end = System.currentTimeMillis();

        result.setTime(end - init);
        result.setGroupId(getGroupId());

        System.out.println(result.toString() + "\n");
        Utils.printLine(result.toString().length());

        new ResultService().save(result);
    }

    private static String getGroupId(){
        if(groupId == null){
            groupId = UUID.randomUUID().toString();
        }
        return groupId;
    }
}
