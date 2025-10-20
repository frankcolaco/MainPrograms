package com.examples.algo.prefixsum;

/*

Given an integer array nums, handle multiple queries of the following type:

    Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.

Implement the NumArray class:

    NumArray(int[] nums) Initializes the object with the integer array nums.
    int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

 */

public class RangeSumArrayMain {

    public static void main(String[] args) {
        RangeSumArrayMain rangeSumArrayMain = new RangeSumArrayMain();
        Integer[] numArray = {-2, 0, 3, -5, 2, -1};
        Integer rangeSum = rangeSumArrayMain.sumRange(numArray,3,5);
        System.out.println("Sum for the given range is:: "+rangeSum);

        rangeSum = rangeSumArrayMain.sumRange(numArray,2,6);
        System.out.println("Sum for the given range is:: "+rangeSum);
    }



    int sumRange(Integer[] arr,int left, int right) {

        int sum = 0;
        int length = arr.length;

        if(left >= length || right >= length){
            System.out.println("sum range is out of bound");
            return sum;
        }
        for(int i =left;i<=right;i++){
            sum = sum + arr[i];
        }
        return sum;

    }

}
