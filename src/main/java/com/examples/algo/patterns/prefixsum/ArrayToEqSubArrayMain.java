package com.examples.algo.patterns.prefixsum;

/*
Given an array of integers greater than zero,
find if it is possible to split it in two subarrays (without reordering the elements),
such that the sum of the two subarrays is the same. Print the two subarrays.
 */

public class ArrayToEqSubArrayMain {

    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3 , 4 , 5 , 5 };
        int n = arr.length;
        printTwoParts(arr, n);
        System.out.println();
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        printTwoPartsOptimally(arr,n);
    }


    //brute force method with time complexity O(n^2) and space complexity O(1)
    private static int findSplitPoint(int[]arr,int n){

        int leftSum =0;
        for(int i=0;i<n;i++){
            leftSum+=arr[i];

            int rightSum = 0;
            for(int j=i+1;j< n;j++){
                rightSum+=arr[j];
            }

            if(leftSum == rightSum)
                return i+1;
        }

        return -1;
    }

    // optimal solution with time complexity O(n) and space complexity O(1)
    /*
    An Efficient solution is to first compute the sum of the whole array from left to right.
    Now we traverse array from right and keep track of right sum, left sum can be computed by subtracting current element from whole sum.
     */
    private static int findSplitPointOp(int[]arr,int n){

        // compute leftSum
        int leftSum = 0;
        for(int i=0;i<n;i++){
            leftSum+=arr[i];
        }

        // compute rightSum and exclude current element to leftSum
        int rightSum = 0;
        for(int i=n-1;i>=0;i--){
            rightSum+=arr[i];

            leftSum -=arr[i];

            // check if leftSum equals rightSum
            if(leftSum==rightSum){
                return i;
            }
        }

        return -1;
    }

    private static void printTwoParts(int[] arr,int n){

        int splitPoint = findSplitPoint(arr,n);
        if(splitPoint ==-1 || splitPoint==n){
            System.out.println("not possible");
            return;
        }
        for(int i=0;i<n;i++){
            if(splitPoint==i){
                System.out.println();
            }
            System.out.print(arr[i]+" ");
        }

    }

    private static void printTwoPartsOptimally(int[] arr,int n){

        int splitPoint = findSplitPointOp(arr,n);
        if(splitPoint ==-1 || splitPoint==n){
            System.out.println("not possible");
            return;
        }
        for(int i=0;i<n;i++){
            if(splitPoint==i){
                System.out.println();
            }
            System.out.print(arr[i]+" ");
        }

    }
}
