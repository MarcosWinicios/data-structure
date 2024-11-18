package com.studies.algorithms.operations.search;

import com.studies.algorithms.metrics.ResultSearch;


public class BinarySearch implements SearchAlgorithmInterface {

    private final String name = "Binary Search";

    @Override
    public ResultSearch find(int[] array, long targetValue) {
        boolean isPresent = false;
        int init = 0;
        int end = array.length - 1;
        int mid;
        int position = 0;

        long testCounter = 0;

        while (init <= end) {
            testCounter++;
            mid = (end + init) / 2;
            if (array[mid] == targetValue) {
                isPresent = true;
                position = mid;
                break;
            } else if (array[mid] < targetValue) {
                init = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return new ResultSearch(array, testCounter, this.name, isPresent, position);
    }

    @Override
    public String getName() {
        return this.name;
    }

}

