package com.studies.array;

public class IntArray {
    public static void main(String[] args) {
        int[] array = new int[10];

        array[0] = 3;
        array[1] = 4;
        array[3] = 13;
        array[2] = 8;
        array[5] = 51;
        array[4] = 22;
        array[6] = 33;

        System.out.println("Impimindo...");
        System.out.println(array[0]); //3
        System.out.println(array[1]); //4
        System.out.println(array[6]); //33
        System.out.println(array[8]); //0 -> Posições não preenchidas assumem o valor 0 para arrays numéricos


        System.out.println("Imprimir todos...");

        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

        System.out.println("fim...");

    }
}
