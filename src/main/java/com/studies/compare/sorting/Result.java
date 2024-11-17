package com.studies.compare.sorting;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String algorithmName;
    @Transient
    private int[] array;
    private int arraySize;
    private long exchanges;
    private long time;
    private String groupId;

    public Result(int[] array, long exchanges, String algorithmName) {
        this.array = array;
        this.arraySize = array.length;
        this.exchanges = exchanges;
        this.algorithmName = algorithmName;
    }


    public Result(String id, String algorithmName, int arraySize, long exchanges, long time, String groupId) {
        Id = id;
        this.array = new int[arraySize];
        this.algorithmName = algorithmName;
        this.arraySize = arraySize;
        this.exchanges = exchanges;
        this.time = time;
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        if(array != null && array.length <=30){
            return "Result{" +
                    "algorithm=" + algorithmName +
                    "array=" + Arrays.toString(array) +
                    ", exchanges=" + exchanges +
                    ", time=" + time + " ms" +
                    '}';
        }
        return "Result{" +
                "algorithm=" + algorithmName +
                ", array size=" + arraySize +
                ", exchanges=" + exchanges +
                ", time=" + time + " ms" +
                '}';
    }
}
