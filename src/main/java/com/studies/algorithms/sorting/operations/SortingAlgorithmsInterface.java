package com.studies.algorithms.sorting.operations;

import com.studies.algorithms.sorting.model.Result;

public interface SortingAlgorithmsInterface {


    public Result sort(int[] array);

    public default String getMessage(){
        return "Ordenação utilizando o algoritmo " + getName();
    }

    public String getName();
}
