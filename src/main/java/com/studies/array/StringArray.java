package com.studies.array;

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
    }
}
