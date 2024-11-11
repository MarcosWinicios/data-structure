package com.studies.compare.sorting;

import java.util.Arrays;

public class Result {

    private int[] array;
    private int exchanges;

    public Result(int[] array, int exchanges) {
        this.array = array;
        this.exchanges = exchanges;
    }

    public int[] getArray() {
        return array;
    }

    public int getExchanges() {
        return exchanges;
    }

    @Override
    public String toString() {
        return "Result{" +
                "array=" + Arrays.toString(array) +
                ", exchanges=" + exchanges +
                '}';
    }
}
