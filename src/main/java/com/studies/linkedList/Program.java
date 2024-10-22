package com.studies.linkedList;

public class Program {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        System.out.println("Tamanho: " +  list.getSize());

        list.add("AC");
        list.add("BA");
        list.add("CE");
        list.add("DF");

        System.out.println("Tamanho: " +  list.getSize());
        System.out.println("Primeiro: " + list.getFirst().getValue());
        System.out.println("Último: " + list.getLast().getValue());

        System.out.println(list.get(0).getValue());
        System.out.println(list.get(1).getValue());
        System.out.println(list.get(2).getValue());
        System.out.println(list.get(3).getValue());

        printLinkedList(list);

        //remover estado CE
        list.remove("CE");
        System.out.println("removeu estado CE");
        printLinkedList(list);
    }

    public static void printLinkedList(LinkedList list){

        for(int i = 0; i < list.getSize(); i++){
            System.out.println(list.get(i).getValue());
        }
    }
}
