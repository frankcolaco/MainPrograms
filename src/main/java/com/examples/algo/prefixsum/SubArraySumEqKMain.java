package com.examples.algo.prefixsum;


import java.util.HashMap;

/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubArraySumEqKMain {

    public static void main(String[] args) {

        SubArraySumEqKMain subArraySumEqKMain = new SubArraySumEqKMain();

        //brute force method Time complexity: O(n^2) space complexity: O(n)
        Integer[] numArray = {1,2,3};
        System.out.println("number of subarrays whose sum is equal to 3:: "+subArraySumEqKMain.subarraySum(numArray,3));
        Integer[] numArray1 = {1,1,1};
        System.out.println("number of subarrays whose sum is equal to 3:: "+subArraySumEqKMain.subarraySum(numArray1,2));

        //optimized approach Time complexity: O(n) space complexity: O(n)
        System.out.println("::::: below result is with using hashmap ::::::");
        Integer[] arr = {10, 2, -2, -20, 10};
        int k = -10;
        HashMap<Integer,Integer> prefixSums = new HashMap<>();
        System.out.println("number of subarrays whose sum is equal to -10:: "+subArraySumEqKMain.subarraySum(arr,k,prefixSums));


    }

    int subarraySum(Integer[] nums, int k) {

        int count = 0;
        int length = nums.length;
        for(int i=0;i<length;i++){
            int currSum = 0;
            for(int j=i;j<length;j++){
                currSum += nums[j];
                if(currSum == k) {
                    count++;
                }
            }
        }
    return count;
    }

    int subarraySum(Integer[] nums, int k, HashMap<Integer,Integer>prefixSums) {

        int count = 0;
        int length = nums.length;
        int currSum = 0;
        for(int i=0;i<length;i++){

                currSum += nums[i];
                if(currSum == k) {
                    count++;
                }

             if(prefixSums.containsKey(currSum - k)){
                 count +=prefixSums.get(currSum-k);
             }

             prefixSums.put(currSum,prefixSums.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}
