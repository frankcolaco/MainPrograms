package com.examples.algo.prefixsum;


/*
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.
 */
public class SubArraySumEqKMain {

    public static void main(String[] args) {

        SubArraySumEqKMain subArraySumEqKMain = new SubArraySumEqKMain();

        Integer[] numArray = {1,2,3};
        System.out.println("number of subarrays whose sum is equal to 3:: "+subArraySumEqKMain.subarraySum(numArray,3));
        Integer[] numArray1 = {1,1,1};
        System.out.println("number of subarrays whose sum is equal to 3:: "+subArraySumEqKMain.subarraySum(numArray1,2));


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
}
