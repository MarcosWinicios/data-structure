package com.studies.linkedList;

public class Program {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        linkedListToStringDemo(list);

        list.add("AC");
        list.add("BA");
        list.add("CE");
        list.add("DF");


        printLinkedList(list);

        //remover estado BA (elemento do meio da lista)
        testRemoveValue("BA", list);


        //remover estado CE (elemento do meio da lista)
        testRemoveValue("CE", list);

        //remover estado AC (primeiro elemento da lista)
        testRemoveValue("AC", list);

        //remover o etado DF (último elemento da lista)
        testRemoveValue("DF", list);


        list.add("SP");
        System.out.println("Adicionando estado SP");
        printLinkedList(list);

        //remover o etado SP (último elemento da lista)
        testRemoveValue("SP", list);

        list.add("RJ");
        printLinkedList(list);
    }

    public static void printLinkedList(LinkedList list){
        linkedListToStringDemo(list);
        for(int i = 0; i < list.getSize(); i++){
            System.out.println(list.get(i).getValue());
        }
    }

    public static void testRemoveValue(String value, LinkedList list){
        list.remove(value);
        System.out.println("Removeu o estado " + value);
        printLinkedList(list);
    }

    public static void linkedListToStringDemo(LinkedList list){
        StringBuilder value = new StringBuilder()
                .append("\n")
                .append("Tamanho: ").append(list.getSize()).append("\n")
                .append("Primeiro: ").append((list.getFirst() != null ? list.getFirst().getValue() : "")).append("\n")
                .append("Último: ").append((list.getLast() !=null ? list.getLast().getValue() : "")).append("\n");

        System.out.println(value);
    }

//    public static  void testAddValue()
}
