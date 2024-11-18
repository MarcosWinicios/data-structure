package com.studies.algorithms.metrics;


import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
public class ResultSearch {

    private String Id;
    private String algorithmName;
    private int[] array;
    private int arraySize;
    private long tests;
    private long time;
    private String groupId;
    private boolean isPresent;
    private long position;

    public ResultSearch(int[] array, long tests, String algorithmName, boolean isPresent, long position) {
        this.tests = tests;
        this.algorithmName = algorithmName;
        this.array = array;
        this.arraySize = array.length;
        this.isPresent = isPresent;
        this.position = position;
    }

    @Override
    public String toString() {
        if(array.length <= 30){
            if(isPresent){
                return "ResultSearch{" +
                        "array=" + Arrays.toString(array) +
                        "\nelemento encontrado na posição= " + position +
                        ", time=" + time +
                        ", quantidade de tests=" + tests +
                        ", arraySize=" + arraySize +
                        '}';
            }
            return "ResultSearch{" +
                    "array=" + Arrays.toString(array) +
                    "\nelemento não encontrado" +
                    ", time=" + time +
                    ", quantidade de tests=" + tests +
                    ", arraySize=" + arraySize +
                    '}';
        }
        if (isPresent){

                return "ResultSearch{" +
                        "\nelemento encontrado na posição= " + position +
                        ", time=" + time +
                        ", quantidade de tests=" + tests +
                        ", arraySize=" + arraySize +
                        '}';
        }
        return "ResultSearch{" +
                "\nelemento não encontrado" +
                "  time=" + time +
                ", quantidade de tests=" + tests +
                ", arraySize=" + arraySize +
                '}';
    }
}
