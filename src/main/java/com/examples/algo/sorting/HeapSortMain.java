package com.examples.algo.sorting;

import java.util.Arrays;

public class HeapSortMain {

    public static void main(String[] args) {
        int[] arr = {9, 4, 3, 8, 10, 2, 5 };
        heapSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    // main function to apply heap sort
    private static void heapSort(int[] arr) {

        int len = arr.length;
        // build heap
        for(int i=len/2-1;i>=0;i--){
            heapify(arr,len,i);
        }

        // one by one extract element from heap - we extract root element every time and so 0th element is swapped with freed space in array.
        for(int i=len-1;i>0;i--){
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;

            heapify(arr,i,0);

        }
    }

    // to heapify a subtree rooted with node i
    private static void heapify(int[] arr,int n,int i){

        // initialize largest as root
        int largest = i;

        //left index
        int lIndex = 2*i+1;

        // right index
        int rIndex = 2*i+2;

        // if left child is larger than root
        if(lIndex<n && (arr[lIndex]>arr[largest])){
            largest = lIndex;
        }

        // if right child is larger than the largest so far
        if(rIndex < n && (arr[rIndex]>arr[largest])){
            largest = rIndex;
        }

        // if largest is not equal to root
        if(largest != i){
            int temp = arr[i];
            arr[i]=arr[largest];
            arr[largest]=temp;

            // recursively heapify the sub-tree
            heapify(arr,n,largest);
        }

    }


}
