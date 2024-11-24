package com.studies.dataStructures.array;

import java.util.Scanner;

public class StringArray {

    public static void main(String[] args) {

        String[] states = new String[10];
        states[0] = "AC";
        states[1] = "BA";
        states[2] = "CE";
        states[3] = "DF";
        states[4] = "AM";
        states[5] = "AP";
        states[6] = "PB";
        states[7] = "RN";
        states[8] = "MS";
        states[9] = "SP";

        for (int i = 0; i < states.length; i++) {
            System.out.println("Estado: " + states[i]);
        }
        Scanner reader = new Scanner(System.in);

        System.out.println("Digite uma sigla de estado a ser buscada: ");

        String acronymQuery = reader.nextLine();
        linearSearch(acronymQuery, states);

    }

    /***
     * busca linear: busca que caminha da primeira até a última posição do array
     * É uma busca ineficiente, por ser lenta.
     * A medida que o tamanho do array aumenta, o tempo de busca também aumenta
     */
    public static void linearSearch(String targetValue, String[] array) {
        boolean isPresent = false;
        int position = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equalsIgnoreCase(targetValue)) {
                isPresent = true;
                position = i;
                break;
            }
        }

        if (isPresent) {
            System.out.println("Esse estado foi encontrado na posição: " + position);
        } else {
            System.out.println("Estado não encontrado");
        }
    }
}
