package com.examples.algo.prefixsum;

/*
The equilibrium index of an array is an index such that the sum of all elements at lower indexes equals the sum of all elements at higher indexes.
 */

public class EquilibriumMain {

    public static void main(String[] args) {
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println("equilibrium using brute force:: "+findEquilibriumB(arr));
        System.out.println("equilibrium using better approach:: "+findEquilibriumOp(arr));
        System.out.println("equilibrium using expected approach:: "+findEquilibriumBest(arr));
    }

    // brute force approach time complexity: O(n^2) and space complexity is O(1)
    private static int findEquilibriumB(int[] arr){

        long startTime = System.currentTimeMillis();
        // check for indexes one by one until an equilibrium index is found
        for(int i=0;i<arr.length;++i){

            //left sum
            int leftSum = 0;
            for (int k=0;k<i;k++) {
                leftSum += arr[k];
            }

            //right sum
            int rightSum = 0;
            for(int j=i+1;j<arr.length;j++){
                rightSum += arr[j];
            }

            // check if left and right sum is equal and return
            if(leftSum == rightSum){
                float endTime = System.currentTimeMillis() - startTime;
                System.out.println("Total time required in brute force approach:: "+endTime);
                return i;
            }
        }
        return -1;
    }

    // better approach than brute force with Time complexity: O(n) and space complexity: O(n)
    private static int findEquilibriumOp(int[] arr){
        long startTime = System.currentTimeMillis();
        int n= arr.length;
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0]=arr[0];
        suff[n-1] = arr[n-1];

        // calculate prefix sums
        for(int i=1;i<n;i++)
            pref[i]=pref[i-1] + arr[i];

        //calculate suffix sums
        for(int j=n-2;j>=0;j--)
            suff[j]=suff[j+1]+arr[j];

        // check if prefix sum is equal to suffix sum
        for(int i=0;i<n;i++){
            if(pref[i]==suff[i]){
                float endTime = System.currentTimeMillis() - startTime;
                System.out.println("Total time required in optimal approach:: "+endTime);
                return i;
            }
        }


        return -1;

    }

    // expected approach with time complexity: O(n) and space complexity O(1)

    private static int findEquilibriumBest(int[] arr){
        long startTime = System.currentTimeMillis();
        int prefSum =0; int total=0;

        //calculate array sum
        for(int ele: arr){
            total +=ele;
        }

        //iterate pivot over all elements of array
        for(int pivot=0;pivot< arr.length;pivot++){

            int suffSum = total - prefSum - arr[pivot];
            if(prefSum==suffSum){
                float endTime = System.currentTimeMillis() - startTime;
                System.out.println("Total time required in expected approach:: "+endTime);
                return pivot;
            }
            prefSum +=arr[pivot];
        }
        return -1;
    }
}
