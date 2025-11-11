package com.examples.algo.patterns.prefixsum;

/*
Given an array arr[] of n integers and q queries represented by an array queries[][], where queries[i][0] = l and queries[i][1] = r.
For each query, the task is to calculate the mean of elements in the range l to r and return its floor value.
 */


public class MeanOfRangeInArrayMain {

    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 8, 5};
        int[][] queries = {{1, 3}, {2, 5}};

        int[] result = findMeanB(arr, queries);
        printArr(result);
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::");
        result = findMeanOp(arr,queries);
        printArr(result);
    }


    // brute force method Time Complexity: O(n * q) and space complexity is O(1).

    public static int[] findMeanB(int[] arr, int[][]queries){
        int n = arr.length;
        int q = queries.length;
        int[] result = new int[q];

        // iterate through each query element
        for(int i=0;i<q;i++){

            // convert to zero based index
            int l = queries[i][0]-1;
            int r = queries[i][1]-1;

            int sum = 0; int count = 0;
            //calculate the sum in the range and keep tap on count
            for(int j=l;j<=r;j++){
                sum +=arr[j];
                count++;
            }
            result[i]=sum/count;
        }
        return result;
    }

    // optimal solution Time complexity O(p+q) and space complexity is O(n)
    public static int[] findMeanOp(int[] arr,int[][] queries){

        int n= arr.length;
        int q= queries.length;
        int[] prefixSum = new int[n+1];
        int[] result = new int[q];


        // compute prefixSum
        for(int i=1;i<=n;i++){
            prefixSum[i] = prefixSum[i-1] + arr[i-1];
        }

        //iterate through all queries

        for(int i=0;i<q;i++){
            // make zero based index
            int l = queries[i][0]-1;
            int r = queries[i][1]-1;

            //calculate sum using prefixSum
            int sum = prefixSum[r+1] - prefixSum[l];
            int count = (r - l +1);

            //store the floor

            result[i]=sum/count;
        }
        return result;
    }

    // Function to print the result
    static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
