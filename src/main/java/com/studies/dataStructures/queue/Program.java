package com.studies.dataStructures.queue;

public class Program {

    public static void main(String[] args) {
        Queue<String> queue =  new Queue();

        queue.add("Jão");
        queue.add("Zé");
        queue.add("Juca");
        queue.add("Maria");
        queue.add("Ana");

        System.out.println("Primeiro da fila: " + queue.get());

        queue.remove();

        System.out.println("Novo primeiro da Fila: " + queue.get());

    }
}
