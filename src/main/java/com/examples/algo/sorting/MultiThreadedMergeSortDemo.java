package com.examples.algo.sorting;

import java.util.Random;

public class MultiThreadedMergeSortDemo {

    private static final int SIZE = 25;
    private static Random random = new Random(System.currentTimeMillis());
    private static int[] input = new int[SIZE];

    public static void main(String[] args) {

        createTestData();

        printArray(input, "Before: ");
        long start = System.currentTimeMillis();
        new MultiThreadedMergeSort().mergeSort(0, input.length - 1, input);
        long end = System.currentTimeMillis();
        System.out.println("\n\n Time taken to complete sort: " + (end - start) + " milliseconds");
        printArray(input, "After: ");
    }

    private static void printArray(int[] input, String msg) {
        System.out.println();
        System.out.print(msg + " ");
        for (int j : input) {
            System.out.print(" " + j + " ");
        }
        System.out.println();
    }

    private static void createTestData() {

        for (int i = 0; i < SIZE; i++) {
            input[i] = random.nextInt(10000);
        }
    }

}

class MultiThreadedMergeSort {

    void mergeSort(int start, int end, int[] input) {
        if (start == end) return;

        int mid = start + ((end - start) / 2);

        Thread sortFirstHalf = new Thread(() -> mergeSort(start, mid, input));

        Thread sortSecondHalf = new Thread(() -> mergeSort(mid + 1, end, input));

        sortFirstHalf.start();
        sortSecondHalf.start();

        try {
            sortFirstHalf.join();
            sortSecondHalf.join();
        } catch (Exception e) {

        }

        merge(start, mid, end, input);
    }

    private void merge(int start, int mid, int end, int[] input) {

        int size1 = mid - start + 1;
        int size2 = end - mid;
        int[] L = new int[size1];
        int[] R = new int[size2];

        // copy to temporary array
        for (int i = 0; i < size1; ++i)
            L[i] = input[start + i];

        for (int j = 0; j < size2; ++j)
            R[j] = input[mid + 1 + j];


        // merge temporary arrays

        // initialize start points

        int i = 0;
        int j = 0;
        int k = start;

        while (i < size1 && j < size2) {
            if (L[i] <= R[j]) {
                input[k] = L[i];
                i++;
            } else {
                input[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            input[k] = L[i];
            i++;
            k++;
        }

        while (j < size2) {
            input[k] = R[j];
            j++;
            k++;
        }
    }

}
