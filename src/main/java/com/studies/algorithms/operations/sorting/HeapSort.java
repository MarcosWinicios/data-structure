package com.studies.algorithms.operations.sorting;

import com.studies.algorithms.metrics.ResultSorting;

public class HeapSort implements SortingAlgorithmsInterface{

    private final String name =  "HEAP SORT";
    private long exchangesCounter = 0L;

    @Override
    public ResultSorting sort(int[] array) {

        /**
         * Percorre o array da metade ao inicio aplicando o heap. Utilizando o conceito de árvore.
         * Para cada item o metodo heap elege uma raiz e os filhos da direita e esquerda.
         * Sendo que:
         * - raiz = array[i]
         * - direita = array[2 * i + 1]
         * - esquerda = array[2 * i + 2]
         *
         * Ao finalizar este for, o maior número estará no topo da árvore, sendo também no primeiro index do array
         */
        int size = array.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            applyHeap(array, size, i);
        }

        /**
         * Agora este for irá levar o maior valor para a última posição e reaplicar o heap sempre diminuindo um index do array.
         * Sempre, após aplicar o heap, o maior valor estará no inicio do array, e nesse for, este valor sempre será jogado para o fim
         */
        for (int lastIndex = size - 1; lastIndex > 0; lastIndex--) {
            int aux = array[0];
            array[0] = array[lastIndex];
            array[lastIndex] = aux;
            exchangesCounter++;

            applyHeap(array, lastIndex, 0);
        }

        return new ResultSorting(array, exchangesCounter, this.name);
    }


    private void applyHeap(int[] array, int lastIndex, int i) {
        int root = i; //raiz
        int left = 2 * i + 1; //filho da esquerda
        int right = 2 * i + 2; //filho da direita

        //Verifica se o filho da esquerda é maior que a raiz
        if (left < lastIndex && array[left] > array[root]) {
            root = left;
        }
        //Verifica se o filho da direita é maior que a raiz
        if (right < lastIndex && array[right] > array[root]) {
            root = right;
        }

        //Definiu como raiz o index do maior elemento dentre os três

        //Troca o filho e a raiz de posições se o filho for maior
        if (root != i) {
            int aux = array[i];
            array[i] = array[root];
            array[root] = aux;

            exchangesCounter++;
            applyHeap(array, lastIndex, root);
        }
    }


    @Override
    public String getName() {
        return this.name;
    }
}
