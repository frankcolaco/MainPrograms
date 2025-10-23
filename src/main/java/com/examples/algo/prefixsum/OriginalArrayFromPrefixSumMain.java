package com.examples.algo.prefixsum;

import java.util.ArrayList;
import java.util.List;

public class OriginalArrayFromPrefixSumMain {


    public static void main(String[] args) {
        int[] presum = { 45, 57, 63, 78, 89, 97 };

        // Function call and storing the result
        List<Integer> arr = decodeArray(presum);

        // Displaying elements of the original array
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> decodeArray(int[] presum) {

        List<Integer> arr = new ArrayList<>();
        arr.add(presum[0]);

        for(int i=1;i<presum.length;i++){
            arr.add(presum[i]-presum[i-1]);
        }

        return arr;
    }
}
