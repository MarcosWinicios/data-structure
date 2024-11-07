package com.studies.array;

import com.studies.utils.Utils;

import java.util.Arrays;

public class SortingAlgorithms {

    private final static Boolean PRINT_ARRAYS_ENABLE = false;
    private final static String SORTED_ARRAY_MESSAGE = "Array ordenado";
    private final static String DESORDERED_ARRAY_MESSAGE = "Array desordenado";
    private final static int[] DESORDERED_ARRAY = Utils.generateRandomIntegerArray(100000);
//    private final static int[] DESORDERED_ARRAY = Utils.generateUniqueRandomArray(6);
//    private final static int[] DESORDERED_ARRAY = {2, 10, 5, 8, 6, 25};

    public static void main(String[] args) {
        printArray(DESORDERED_ARRAY, DESORDERED_ARRAY_MESSAGE);

        int[] disorderedArray1 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
        int[] disorderedArray2 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
        int[] disorderedArray3 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
        int[] disorderedArray5 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
//
        sortArrayBubleSort(disorderedArray1);
        sortArrayInsertionSort(disorderedArray2);
        sortArraySelectionSort(disorderedArray3);
        sortArrayHeapSort(disorderedArray5);

    }

    private static void printArray(int[] array) {
        printArray(array, SORTED_ARRAY_MESSAGE);
    }

    private static void printArray(int[] array, String message) {
        if (PRINT_ARRAYS_ENABLE) {
            Utils.printArray(array, message);
            Utils.printLine();
        }
    }

    //O(N²)
    public static int[] sortArrayBubleSort(int[] array) {
        System.out.println("\nOrdenando array de " + array.length + " posições com Bluble Sort");
        long init = System.currentTimeMillis();
        long end;

        int aux = 0;
        for (int i = 0; i < array.length; i++) {//(O(N)
            for (int j = i + 1; j < array.length; j++) {//O(N-1) -> O(N)
                if (array[i] > array[j]) {
                    aux = array[j];
                    array[j] = array[i];
                    array[i] = aux;
                }
            }
        }
        end = System.currentTimeMillis();
        System.out.println("Tempo: " + (end - init));

        printArray(array);
        return array;
    }

    //O(N²) -> Mais rápido que o buble sort
    public static int[] sortArrayInsertionSort(int[] array) {
        System.out.println("\nOrdenando array de " + array.length + " posições com Insertion Sort");

        long init = System.currentTimeMillis();
        long end;

        int aux, j;
        for (int i = 1; i < array.length; i++) {//O(N)
            aux = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > aux) {//O(N-1) -> O(N)
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = aux;
        }

        end = System.currentTimeMillis();
        System.out.println("Tempo: " + (end - init));

        printArray(array);
        return array;
    }

    //O(N²)
    public static int[] sortArraySelectionSort(int[] array) {
        System.out.println("\nOrdenando array de " + array.length + " posições com Selection Sort");

        long init = System.currentTimeMillis();
        long end;

        int minorElementPosition, aux;
        for (int i = 0; i < array.length; i++) {//O(N)
            minorElementPosition = i;
            for (int j = i + 1; j < array.length; j++) {//O(N-1) -> O(N)
                if (array[j] < array[minorElementPosition]) {
                    minorElementPosition = j;
                }
            }
            aux = array[minorElementPosition];
            array[minorElementPosition] = array[i];
            array[i] = aux;
        }

        end = System.currentTimeMillis();
        System.out.println("Tempo: " + (end - init));

        printArray(array);
        return array;
    }

    //O(N log N)
    public static int[] sortArrayHeapSort(int[] array) {
        System.out.println("\nOrdenando array de " + array.length + " posições com Heap Sort");
        long init = System.currentTimeMillis();
        long end;

        /**
         * Percorre o array da metade ao inicio aplicando o heap. Utilizando o conceito de árvore.
         * Para cada item o metodo heap elege uma raiz, o filho da direita e um da esquerda.
         * Sendo que:
         * - raiz = array[i]
         * - direita = array[2 * i + 1]
         * - esquerda = array[2 * i + 2]
         *
         * Esse for descobre qual o maior dentre os três, e o torna a raiz realizando a troca de posições.
         */
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) { //Percorre apenas até a metade do array para montar um heap
            applyHeap(array, n, i);
        }

        printArray(array, "Array Quase ordenado");

        /**
         * Agora esse for irá realizar a troca de posições entre os elementos levando os maiores para direita e os menores para esquerda
         * Também aplica o heap novamente para garantir a ordenação
         */
        for (int j = n - 1; j > 0; j--) {
            int aux = array[0];
            array[0] = array[j];
            array[j] = aux;

            applyHeap(array, j, 0);
        }

        end = System.currentTimeMillis();
        System.out.println("Tempo: " + (end - init));

        printArray(array);
        return array;
    }

    private static void applyHeap(int[] array, int n, int i) {
        int root = i; //raiz
        int left = 2 * i + 1; //filho da esquerda
        int right = 2 * i + 2; //filho da direita

        printArray(array, "");
        printTreeElements(array, i, left, right, "Galho antes da ordenação");

        //Verifica se o filho da esquerda é maior que a raiz
        if (left < n && array[left] > array[root]) {
            root = left;
        }
        //Verifica se o filho da direita é maior que a raiz
        if (right < n && array[right] > array[root]) {
            root = right;
        }

        //Definiu como raiz o index do maior elemento dentre os três

        //Troca o filho e a raiz de posições se o filho for maior
        if (root != i) {
            int aux = array[i];
            array[i] = array[root];
            array[root] = aux;

            printArray(array, "");
            printTreeElements(array, i, left, right, "Galho após a ordenação");
            applyHeap(array, n, root);
        }
    }

    private static void printTreeElements(int[] array, int root, int left, int right, String message) {
        if (PRINT_ARRAYS_ENABLE) {
            System.out.println("\n" + message);
            String rootValue = (root < array.length ? array[root] : "null").toString();
            String leftValue = (left < array.length ? array[left] : "null").toString();
            String rightValue = (right < array.length ? array[right] : "null").toString();
            System.out.println("    " + rootValue + "\n    /\\\n" + printLeft(leftValue) + "  " + rightValue + "\n");
        }
    }

    private static String printLeft(String leftValue) {
        if (leftValue.length() > 2) {
            return leftValue;
        } else if (leftValue.length() == 2) {
            return "  " + leftValue;
        }
        return "   " + leftValue;
    }
}
