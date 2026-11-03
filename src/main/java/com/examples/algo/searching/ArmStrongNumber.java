package com.examples.algo.searching;

/*
 * The k-digit number N is an Armstrong number if and
 * only if the k-th power of each digit sums to N.
 *
 * <p>Given a positive integer N, return true if and only if it is an Armstrong number.
 *
 * <p>Example 1:
 *
 * <p>Input: 153 Output: true Explanation: 153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
 * Example 2:
 *
 * <p>Input: 123 Output: false Explanation: 123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 =
 * 36.
 *
 * <p>Note:
 *
 * <p>1 <= N <= 10^8

 */
public class ArmStrongNumber {

    public static void main(String[] args) {

        System.out.println("given number is armstrong number: " + isArmStrongNumber(153));

    }

    private static boolean isArmStrongNumber(int number) {

        String sNumber = String.valueOf(number);
        int numLength = sNumber.length();

        long sum = 0;

        for (char s : sNumber.toCharArray()) {
            int i = Integer.parseInt(String.valueOf(s));
            sum += power(i, numLength);
        }

        return (sum == number);

    }

    private static long power(int s, int numLength){

        long power = 1L;

        for(int i=0;i<numLength;i++){
            power *=s;
        }
        return power;
    }
}
