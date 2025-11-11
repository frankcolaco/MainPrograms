package com.examples.algo.patterns.twopointers;

import java.util.ArrayList;


/*
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 */
public class TwoSumMain {

    public static void main(String[] args) {
        // brute force method Time complexity: O(n^2) space complexity: O(1)
        int[] arr ={2,4,5,7};
        int target = 9;
        ArrayList<Integer> result = twoSum(arr,target);
        result.forEach(System.out::println);

        //optimal method Time complexity: O(n) space complexity: O(1)
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::");
        result = twoSumOp(arr,target);
        result.forEach(System.out::println);
    }

    private static ArrayList<Integer> twoSumOp(int[] arr, int target) {

        int left = 0; int right = arr.length-1;

        while(left < right){
            int cSum = arr[left]+arr[right];
            if(cSum == target){
                ArrayList<Integer> result = new ArrayList<>();
                result.add(left+1);
                result.add(right+1);
                return result;
            }else if(cSum<target){
                left++;
            }else{
                right--;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);

        return result;
    }

    private static ArrayList<Integer> twoSum(int[] arr, int target) {

        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = arr[i]+arr[j];
                if(sum == target){
                    ArrayList<Integer> result = new ArrayList<>();
                    result.add(i+1);
                    result.add(j+1);
                    return result;
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        return result;
    }
}
