package com.studies.dataStructures.linkedList;

import com.studies.utils.Utils;

public class ProgramIntegers {
    public static void main(String[] args) {
        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);

        Utils.printLinkedList(numbers);
    }
}
