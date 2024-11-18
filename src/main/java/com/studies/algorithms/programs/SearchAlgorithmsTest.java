package com.studies.algorithms.programs;

import com.studies.algorithms.metrics.ResultSearch;
import com.studies.algorithms.search.BinarySearch;
import com.studies.algorithms.search.LinearSearch;
import com.studies.algorithms.search.SearchAlgorithmInterface;
import com.studies.utils.Utils;

import java.util.Arrays;
import java.util.UUID;

public class SearchAlgorithmsTest {
    private static String groupId = "2cb9a8f1-4c65-41d7-8a1a-46f2ff425350";

    private static int[] ARRAY = Utils.generateUniqueRandomArray(100000);
//    private final static int[] ARRAY = {2, 10, 4, 7, 1, 8, 9, 3, 6, 5};

    public static void main(String[] args) {
        long targetValue = ARRAY[ARRAY.length - 1];
        System.out.println(targetValue);

       ARRAY =  Arrays.stream(ARRAY).sorted().toArray();

        SearchAlgorithmInterface linearSearch = new LinearSearch();
        SearchAlgorithmInterface binarySearch = new BinarySearch();

        execute(ARRAY, targetValue, linearSearch);
        execute(ARRAY, targetValue, binarySearch);
    }

    public static void execute(int[] array, long targetValue, SearchAlgorithmInterface algorithm){
        System.out.println(algorithm.getMessage() + ": \n");

        long init = System.currentTimeMillis();
        long end;

        ResultSearch result = algorithm.find(array, targetValue);

        end = System.currentTimeMillis();

        result.setTime(end - init);
        result.setGroupId(getGroupId());


        System.out.println(result.toString() + "\n");

        Utils.printLine(result.toString().length());

    }

    private static String getGroupId(){
        if(groupId == null){
            groupId = UUID.randomUUID().toString();
        }
        return groupId;
    }
}
