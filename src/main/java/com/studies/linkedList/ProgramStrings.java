package com.studies.linkedList;

import com.studies.utils.Utils;

public class ProgramStrings {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        Utils.linkedListToStringDemo(list);

        list.add("AC");
        list.add("BA");
        list.add("CE");
        list.add("DF");


//        Utils.printLinkedList(list);

        //remover estado BA (elemento do meio da lista)
        Utils.linkedListRemoveValue("BA", list);


        //remover estado CE (elemento do meio da lista)
        Utils.linkedListRemoveValue("CE", list);

        //remover estado AC (primeiro elemento da lista)
        Utils.linkedListRemoveValue("AC", list);

        //remover o etado DF (último elemento da lista)
        Utils.linkedListRemoveValue("DF", list);


        list.add("SP");
        System.out.println("Adicionando estado SP");
        Utils.printLinkedList(list);

        //remover o etado SP (último elemento da lista)
        Utils.linkedListRemoveValue("SP", list);

        list.add("RJ");
        Utils.printLinkedList(list);
    }
}
