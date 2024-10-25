package com.studies.linkedList;

public class LinkedListUtils {

    public static void printLinkedList(LinkedList list) {
        linkedListToStringDemo(list);
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.get(i).getValue());
        }
    }

    public static void testRemoveValue(String value, LinkedList list) {
        list.remove(value);
        System.out.println("Removeu o estado " + value);
        printLinkedList(list);
    }

    public static void linkedListToStringDemo(LinkedList list) {
        String value = "\n" +
                "Tamanho: " + list.getSize() + "\n" +
                "Primeiro: " + (list.getFirst() != null ? list.getFirst().getValue() : "") + "\n" +
                "Último: " + (list.getLast() != null ? list.getLast().getValue() : "") + "\n";

        System.out.println(value);
    }
}
