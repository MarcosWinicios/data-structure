package com.studies.linkedList;

import com.sun.security.jgss.GSSUtil;

public class Program {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        linkedLinkToStringDemo(list);

        list.add("AC");
        list.add("BA");
        list.add("CE");
        list.add("DF");


        printLinkedList(list);

        //remover estado CE (elemento do meio da lista)
//        testRemoveValue("CE", list);

        //remover estado AC (primeiro elemento da lista)
//        testRemoveValue("AC", list);

        //remover o etado DF (último elemento da lista)
        testRemoveValue("DF", list);


        list.add("SP");
        System.out.println("Adicionando estado SP");
        printLinkedList(list);
    }

    public static void printLinkedList(LinkedList list){
        for(int i = 0; i < list.getSize(); i++){
            System.out.println(list.get(i).getValue());
        }
    }

    public static void testRemoveValue(String value, LinkedList list){
        list.remove(value);
        System.out.println("Removeu o estado " + value);
        printLinkedList(list);
    }

    public static void linkedLinkToStringDemo(LinkedList list){
        StringBuilder value = new StringBuilder()
                .append("\n")
                .append("Tamanho: ").append(list.getSize()).append("\n")
                .append("Primeiro: ").append(list.getFirst()).append("\n")
                .append("Último: ").append(list.getLast()).append("\n");

        System.out.println(value);
    }

//    public static  void testAddValue()
}
