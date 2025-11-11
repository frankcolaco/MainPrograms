package com.examples.algo.searching;

public class BinarySearchIterative {

    public static void main(String[] args) {
        int[] array = {3,6,8,12,14,17,25,29,31,36,42,47,53,55,62};
        int index = binSearch(array,array.length,33);
        if(index == -1){
            System.out.println("number not found");
        }else{
            index = index+1;
            System.out.println("Number is present on the index:: "+index);
        }

    }

    private static int binSearch(int[] array, int length, int key) {


        // initialize low, high
        int low = 0;
        int high = length-1;


        while(low<=high){
            int mid = (low+high)/2;
            if(key == array[mid]){
                return mid;
            }

            if(key< array[mid]){
                high = mid -1;
            }else{
                low = mid+1;
            }

        }

return -1;
    }


}
