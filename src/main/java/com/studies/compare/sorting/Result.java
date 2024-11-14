package com.studies.compare.sorting;

import java.util.Arrays;

public class Result {

    private int[] array;
    private int exchanges;
    private long time;

    public Result(int[] array, int exchanges) {
        this.array = array;
        this.exchanges = exchanges;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int[] getArray() {
        return array;
    }

    public int getExchanges() {
        return exchanges;
    }

    @Override
    public String toString() {
        if(array.length <=30){
            return "Result{" +
                    "array=" + Arrays.toString(array) +
                    ", exchanges=" + exchanges +
                    ", time=" + time + " ms" +
                    '}';
        }
        return "Result{" +
                "array size=" + array.length +
                ", exchanges=" + exchanges +
                ", time=" + time + " ms" +
                '}';
    }
}
