package com.studies.linkedList;

public class ProgramStrings {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        LinkedListUtils.linkedListToStringDemo(list);

        list.add("AC");
        list.add("BA");
        list.add("CE");
        list.add("DF");


        LinkedListUtils.printLinkedList(list);

        //remover estado BA (elemento do meio da lista)
        LinkedListUtils.testRemoveValue("BA", list);


        //remover estado CE (elemento do meio da lista)
        LinkedListUtils.testRemoveValue("CE", list);

        //remover estado AC (primeiro elemento da lista)
        LinkedListUtils.testRemoveValue("AC", list);

        //remover o etado DF (último elemento da lista)
        LinkedListUtils.testRemoveValue("DF", list);


        list.add("SP");
        System.out.println("Adicionando estado SP");
        LinkedListUtils.printLinkedList(list);

        //remover o etado SP (último elemento da lista)
        LinkedListUtils.testRemoveValue("SP", list);

        list.add("RJ");
        LinkedListUtils.printLinkedList(list);
    }
}
