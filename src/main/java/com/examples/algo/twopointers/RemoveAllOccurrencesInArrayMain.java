package com.examples.algo.twopointers;

/*
Given an integer array arr[] and an integer ele the task is to the remove all occurrences of ele from arr[] in-place
and return the number of elements which are not equal to ele.
If there are k number of elements which are not equal to ele then the input array arr[] should be modified such that
the first k elements should contain the elements which are not equal to ele and then the remaining elements.

Note: The order of first k elements may be changed.


 */

public class RemoveAllOccurrencesInArrayMain {

    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 0, 2, 2, 4, 2};
        int ele = 2;
        System.out.println(removeElement(arr, ele));
    }

    /*
    Time Complexity: O(n), where n is the number of elements in arr[]
    Auxiliary Space: O(1)
     */
    private static int removeElement(int[] arr, int ele) {

        int k = 0;

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=ele){
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }
}
