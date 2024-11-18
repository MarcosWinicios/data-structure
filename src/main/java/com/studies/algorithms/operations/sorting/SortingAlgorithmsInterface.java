package com.studies.algorithms.operations.sorting;

import com.studies.algorithms.metrics.ResultSorting;

public interface SortingAlgorithmsInterface {


    public ResultSorting sort(int[] array);

    public default String getMessage(){
        return "Ordenação utilizando o algoritmo " + getName();
    }

    public String getName();
}
