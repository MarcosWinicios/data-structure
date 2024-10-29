package com.studies.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Utils {

    private static final Random random = new Random();

    public static <T> void printList(List<T> list){
        System.out.println("\n"+list.toString());
    }

    public static <T> void printListIndexes(List<T> list){

        for (int i = 0; i < list.size(); i++){
            if(i == 0 ){
                System.out.print("[");
            }else {
                System.out.print(", ");
            }
            System.out.print(list.indexOf(
                    list.get(i)
            ));

            if(i == list.size() - 1){
                System.out.print("]");
            }
        }
    }

    public static int[] generateRandomIntegerArray(int size){
        int[] result = new int[size];
        for(int i = 0; i < size; i++){
            result[i] = (int) (Math.random() * 10);
        }
        return result;
    }

    public static int[] generateSortedIntegerArray(int size){
        int[] result = new int[size];
        for(int i = 0; i < size; i++){
            result[i] = i * 2;
        }
        return result;
    }

    public static <T> void printSquareMatrix(List<List<T>> matrix){
        System.out.println("\n" + matrix.toString() + "\n");

        for (List<T> row : matrix){
            System.out.println(row.toString());
        }

        System.out.println();
    }

    public static List<List<Integer>> generateRandomSquareMatrix(int size){

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < size; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < size; j++){
                row.add(random.nextInt(10));
            }
            result.add(row);
        }

        return result;
    }

    public static List<Integer> generateRandomList(int size){
        List<Integer> result =  new ArrayList<>();
        for(int i = 0; i < size; i++){
            result.add(random.nextInt(100));
        }

        return result;
    }

    public static <T> void printArray(T[] array){
        System.out.println(Arrays.toString(array));
    }

    public static void printArray(int[] array){
        System.out.println(Arrays.toString(array));
    }

    public static <K, V> void printMap(Map<K, V> map){
        map.forEach(((k, v) -> System.out.println("Key: " + k + " Value: " + v)));
    }

}
