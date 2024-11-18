package com.studies.algorithms.search;

import com.studies.algorithms.metrics.ResultSearch;

public interface SearchAlgorithmInterface {


    public ResultSearch find(int[] array, long targetValue);

    public default String getMessage(){
        return "Busca utilizando o algoritmo " + getName();
    }

    public String getName();

}
