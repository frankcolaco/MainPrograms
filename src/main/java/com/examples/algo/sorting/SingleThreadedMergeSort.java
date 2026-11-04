package com.examples.algo.sorting;

public class SingleThreadedMergeSort {

    private static int[] scratch = new int[10];

    public static void main(String[] args) {

        int[] input = new int[]{9, 8, 7, 6, 4, 5, 2, 3, 0, 1};

        printArray(input, "Before: ");

        mergeSort(0, input.length - 1, input);

        printArray(input, "After: ");

    }

    private static void printArray(int[] input, String msg) {
        System.out.println();
        System.out.print(msg + " ");
        for (int i = 0; i < input.length; i++) {
            System.out.print(" " + input[i] + " ");
        }
        System.out.println();
    }

    private static void mergeSort(int start, int end, int[] input) {


        if (start == end) return;

        int mid = start + ((end - start) / 2);

        // sort first half
        mergeSort(start, mid, input);

        // sort second half
        mergeSort(mid + 1, end, input);

        // merge two sorted arrays
        int i = start;
        int j = mid + 1;
        int k;

        for (k = start; k <= end; k++) {
            scratch[k] = input[k];
        }

        k = start;

        while (k <= end) {
            if (i <= mid && j <= end) {
                input[k] = Math.min(scratch[i], scratch[j]);

                if (input[k] == scratch[i]) {
                    i++;
                } else j++;
            } else if (i <= mid && j > end) {
                input[k] = scratch[i];
                i++;
            } else {
                input[k] = scratch[j];
                j++;
            }
            k++;
        }
    }
}
