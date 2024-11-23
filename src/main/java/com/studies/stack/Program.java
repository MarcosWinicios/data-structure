package com.studies.stack;

public class Program {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.add("E");
        stack.add("B");
        stack.add("Z");
        stack.add("D");
        stack.add("C");

        System.out.println("Topo: " + stack.get());

        stack.remove();
        System.out.println("Novo Topo: " + stack.get());


        stack.remove();
        System.out.println("Novo Topo: " + stack.get());
    }
}
