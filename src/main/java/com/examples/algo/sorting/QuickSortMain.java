package com.examples.algo.sorting;

public class QuickSortMain {

    // swap function
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //partition function
    static int partition(int[] arr,int low,int high){
        // choosing pivot as last element in array
        int pivot = arr[high];

        //index of smaller element and indicates right position of pivot found so far
        int i = low - 1;

        //traverse arr[low..high] and move all smaller elements to left side. Element from low to i are smaller after every iteration
        for(int j=low;j<=high-1;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }

        // move pivot after smaller elements and return it's position
        swap(arr,i+1,high);
        return i+1;
    }

    // quickSort function implementation
    static void quickSort(int[] arr,int low,int high){
        if(low<high){
            // partition index
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }
}
