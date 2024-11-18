package com.studies.algorithms.search.operations;

import com.studies.algorithms.metrics.ResultSearch;

public class LinearSearch implements SearchAlgorithmInterface{

    private final String name = "Linear Search";
    //O(n)
    @Override
    public ResultSearch find(int[] array, long targetValue) {

        boolean isPresent = false;
        int position = 0;
        long testCounter = 0L;

        for(int i = 0; i < array.length;i++){
            testCounter++;

            if(array[i] == targetValue){
                isPresent = true;
                position = i;
                break;
            }
        }

        return new ResultSearch(array, testCounter, this.name, isPresent, position);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
