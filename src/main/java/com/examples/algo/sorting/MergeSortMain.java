package com.examples.algo.sorting;

import java.util.Arrays;
import java.util.List;

public class MergeSortMain {

    public static void main(String[] args) {

        int[] arr = {4,1,3,6,2,5,10,9,7,8,11};

        sortArray(arr);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }


    }

    private static void sortArray(int[] arr) {

        int low = 0;
        int high = arr.length-1;

        mergeSort(low,high,arr);

    }

    private static void mergeSort(int low, int high, int[] arr) {

        if(low < high){
            int mid = (low+high)/2;
            mergeSort(low,mid,arr); // Left side sort
            mergeSort(mid+1,high,arr); // right side sort
            merge(arr,low,mid,high); // then merge arrays
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {

        // find sizes of temporary array
        int size1 = mid-low+1;
        int size2 = high-mid;

        int[] L = new int[size1];
        int[] R = new int[size2];

        // compy data to temp array
        for(int i =0;i<size1;++i)
            L[i]= arr[low+i];

        for (int j =0;j<size2;++j)
            R[j] = arr[mid+1+j];


        // merge temporary arrays

        //initialize start points

        int i=0; int j=0;
        int k =low;

        while(i< size1 && j< size2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        // copy remaining elements of L[]
        while(i<size1){
            arr[k]=L[i];
            i++;
            k++;
        }

        // copy remaining elements of R[]
        while(j<size2){
            arr[k]=R[j];
            j++;
            k++;
        }

    }
}
