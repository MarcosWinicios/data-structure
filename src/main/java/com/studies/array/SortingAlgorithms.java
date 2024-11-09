package com.studies.array;

import com.studies.utils.Utils;

import java.util.Arrays;

public class SortingAlgorithms {

    private final static Boolean PRINT_ARRAYS_ENABLE = false;
    private final static Boolean PRINT_NODES_ENABLE = false;
    private final static String SORTED_ARRAY_MESSAGE = "Array ordenado";
    private final static String DESORDERED_ARRAY_MESSAGE = "Array desordenado";
    private final static int[] DESORDERED_ARRAY = Utils.generateRandomIntegerArray(10000);
    private static int countHeapExecutions = 0;
    private static int countLoopsExecutions = 0;
    private static long time = 0;

//    private final static int[] DESORDERED_ARRAY = Utils.generateUniqueRandomArray(6);
//    private final static int[] DESORDERED_ARRAY = {2, 10, 4, 7, 1, 8, 9, 3, 6, 5};

    private static void resetCounts() {
        countLoopsExecutions = 0;
        countHeapExecutions = 0;
    }

    private static void printMetrics() {
        int lineSize = 0;
        String heapMessage = "| Execuções de heaps: " + countHeapExecutions;
        String loopMessage = "| Loops executados: " + countLoopsExecutions;
        String timeMessage = "| Tempo: " + time + " ms";

        lineSize = getMax(new int[]{
                heapMessage.length(),
                loopMessage.length(),
                timeMessage.length()
        });

        Utils.printLine(lineSize);

        if (countHeapExecutions > 0) {
            printMetricMessage(heapMessage, lineSize);
        }
        printMetricMessage(loopMessage, lineSize);
        printMetricMessage(timeMessage, lineSize);
        Utils.printLine(lineSize);
    }

    public static void printMetricMessage(String message, int lineSize) {
        if (message.length() != lineSize) {
            System.out.print(message + getSpaces(lineSize - message.length()) + "|\n");
        } else {
            System.out.print(message + "|\n");
        }
    }

    private static int getMax(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    private static String getSpaces(int quantities) {
        String spaces = " ";
        for (int i = 1; i < quantities; i++) {
            spaces += " ";
        }
        return spaces;
    }

    public static void main(String[] args) {
        printArray(DESORDERED_ARRAY, DESORDERED_ARRAY_MESSAGE);

        int[] disorderedArray1 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
        int[] disorderedArray2 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
        int[] disorderedArray3 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
        int[] disorderedArray5 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);
        int[] disorderedArray6 = Arrays.copyOf(DESORDERED_ARRAY, DESORDERED_ARRAY.length);

//        sortArrayBubleSort(disorderedArray1);
////        sortArrayInsertionSort(disorderedArray2);
////        sortArraySelectionSort(disorderedArray3);
////        sortArrayHeapSort(disorderedArray5);
        sortArrayQuickSort(disorderedArray6);

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
        resetCounts();
        System.out.println("\nOrdenando array de " + array.length + " posições com Bluble Sort");
        long init = System.currentTimeMillis();
        long end;

        int aux = 0;
        for (int i = 0; i < array.length; i++) {//(O(N)
            countLoopsExecutions++;
            for (int j = i + 1; j < array.length; j++) {//O(N-1) -> O(N)
                countLoopsExecutions++;
                if (array[i] > array[j]) {
                    aux = array[j];
                    array[j] = array[i];
                    array[i] = aux;
                }
            }
        }
        end = System.currentTimeMillis();
        time = (end - init);
        printArray(array);

        printMetrics();
        return array;
    }

    //O(N²) -> Mais rápido que o buble sort
    public static int[] sortArrayInsertionSort(int[] array) {
        resetCounts();
        System.out.println("\nOrdenando array de " + array.length + " posições com Insertion Sort");

        long init = System.currentTimeMillis();
        long end;

        int aux, j;
        for (int i = 1; i < array.length; i++) {//O(N)
            countLoopsExecutions++;
            aux = array[i];
            j = i - 1;
            while (j >= 0 && array[j] > aux) {//O(N-1) -> O(N)
                countLoopsExecutions++;
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = aux;
        }

        end = System.currentTimeMillis();
        time = (end - init);
        printArray(array);

        printMetrics();
        return array;
    }

    //O(N²)
    public static int[] sortArraySelectionSort(int[] array) {
        resetCounts();
        System.out.println("\nOrdenando array de " + array.length + " posições com Selection Sort");

        long init = System.currentTimeMillis();
        long end;

        int minorElementPosition, aux;
        for (int i = 0; i < array.length; i++) {//O(N)
            countLoopsExecutions++;
            minorElementPosition = i;
            for (int j = i + 1; j < array.length; j++) {//O(N-1) -> O(N)
                countLoopsExecutions++;
                if (array[j] < array[minorElementPosition]) {
                    minorElementPosition = j;
                }
            }
            aux = array[minorElementPosition];
            array[minorElementPosition] = array[i];
            array[i] = aux;
        }

        end = System.currentTimeMillis();
        time = (end - init);

        printArray(array);
        printMetrics();
        return array;
    }

    //O(N log N)
    public static int[] sortArrayHeapSort(int[] array) {
        resetCounts();

        System.out.println("\nOrdenando array de " + array.length + " posições com Heap Sort");
        long init = System.currentTimeMillis();
        long end;

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
            countLoopsExecutions++;
            applyHeap(array, size, i);
        }

//        printArray(array, "Array Quase ordenado");

        /**
         * Agora este for irá levar o maior valor para a última posição e reaplicar o heap sempre diminuindo um index do array.
         * Sempre, após aplicar o heap, o maior valor estará no inicio do array, e nesse for, este valor sempre será jogado para o fim
         */
        for (int lastIndex = size - 1; lastIndex > 0; lastIndex--) {
            countLoopsExecutions++;
            int aux = array[0];
            array[0] = array[lastIndex];
            array[lastIndex] = aux;

            applyHeap(array, lastIndex, 0);
        }

        end = System.currentTimeMillis();
        time = (end - init);
        printArray(array);

        printMetrics();
        return array;
    }


    private static void applyHeap(int[] array, int lastIndex, int i) {
        countHeapExecutions++;
        int root = i; //raiz
        int left = 2 * i + 1; //filho da esquerda
        int right = 2 * i + 2; //filho da direita

        printTreeElements(array, i, left, right, "Galho antes da ordenação");

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

            printTreeElements(array, i, left, right, "Galho após a ordenação");
            applyHeap(array, lastIndex, root);
        }
    }

    public static void  sortArrayQuickSort(int[] array){
        quickSort(array, 0, array.length);
    }

    private static int[] quickSort(int array[], int left, int right){
        if(left < right){
            int pivo  = partition(array, left, right);
            sortArrayQuickSort(array, left, pivo);
            sortArrayQuickSort(array, pivo + 1, pivo);
        }

        return array;
    }

    private static int partition(int[] array, int left, int right) {
        int mid = (int) (left + right) / 2;
        int pivo = array[mid];
        int i =  left - 1;
        int j = right + 1;

        while (true){
            do {
                i++;
            }while (array[i] < pivo);


            do{
                j --;
            }while (array[j] > pivo);

            if(i >= j){
                return j;
            }

            int aux =  array[i];
            array[i] = array[j];
            array[j] = aux;
        }
    }


    private static void printTreeElements(int[] array, int root, int left, int right, String message) {
        if (PRINT_NODES_ENABLE) {
            Utils.printArray(array, "");
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
