package com.examples.algo.searching;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        int[] array = {3,6,8,12,14,17,25,29,31,36,42,47,53,55,62};

        int index = binSearch(array,29);
        if(index == -1){
            System.out.println("number not found");
        }else{
            index = index+1;
            System.out.println("Number is present on the index:: "+index);
        }
    }

    private static int binSearch(int[]arr,int key){

        int low = 0;
        int high = arr.length-1;

        return rBinSearch(low,high,key,arr);
    }

    private static int rBinSearch(int low, int high, int key,int[] arr) {

        if(low == high){
            if(arr[low]==key){
                return low;
            }
            else {
                return -1;
            }
        }else{
            int mid = (low+high)/2;
            if(arr[mid]==key){
                return mid;
            }else if(arr[mid]<key){
                    high = mid-1;
                    rBinSearch(low,high,key,arr);
                }else return rBinSearch(mid+1,high,key,arr);
        }
        return -1;
    }
}
