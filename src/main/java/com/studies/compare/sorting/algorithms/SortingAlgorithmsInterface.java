package com.studies.compare.sorting.algorithms;

import com.studies.compare.sorting.Result;

public interface SortingAlgorithmsInterface {


    public Result sort(int[] array);

    public default String getMessage(){
        return "Ordenação utilizando o algoritmo " + getName();
    }

    public String getName();
}
