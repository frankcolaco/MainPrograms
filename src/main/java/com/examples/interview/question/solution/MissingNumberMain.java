package com.examples.interview.question.solution;

import java.util.*;

public class MissingNumberMain {

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        System.out.println(new MissingNumberMain().missingNumber(nums));
        System.out.println("==================");
        new MissingNumberMain().missingNumberAny(nums);
        System.out.println("==================");
        new MissingNumberMain().missingNumbersOptimal(nums);
    }

    private int missingNumber(int[] nums) {

        int sum = 0;
        int n = nums.length;

        for (int num : nums) {
            sum += num;
        }

        int arrSum = (((n + 1)) * n) / 2;
        if (arrSum == sum) return 0;
        else return arrSum - sum;
    }

    private void missingNumberAny(int[] nums){
        Set<Integer> uniqueNumbers = new HashSet<>();

        if(nums.length ==0) return;

        for(int num:nums){
            uniqueNumbers.add(num);
        }

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i=min;i<max;i++){
            if(!uniqueNumbers.contains(i)){
                missingNumbers.add(i);
            }
        }
        System.out.println("missing numbers: "+ missingNumbers);


    }

    private void missingNumbersOptimal(int[] nums){
        Set<Integer> uniqueNumbers = new HashSet<>();

        if(nums.length ==0) return;
        int min = nums[0];
        int max = nums[0];

        for(int num:nums){
            uniqueNumbers.add(num);
            if(num < min) min = num;
            if(num > max) max = num;

        }
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i=min;i<=max;i++){
            if(!uniqueNumbers.contains(i)){
                missingNumbers.add(i);
            }
        }
        System.out.println("missing numbers: "+missingNumbers);

    }

}
