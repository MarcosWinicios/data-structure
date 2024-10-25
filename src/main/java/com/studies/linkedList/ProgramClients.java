package com.studies.linkedList;

public class ProgramClients {

    public static void main(String[] args) {
        LinkedList<Client> clientLinkedList = new LinkedList<>();

        clientLinkedList.add(new Client("João", "123"));
        clientLinkedList.add(new Client("Juca", "124"));
        clientLinkedList.add(new Client("Zé", "125"));

        LinkedListUtils.printLinkedList(clientLinkedList);
    }
}
