package com.examples.algo.searching.binary_search;

/**
 * * <p>You are a product manager and currently leading a team to develop a new product.
 *  * Unfortunately, the latest version of your product fails the quality check. Since each version is
 *  * developed based on the previous version, all the versions after a bad version are also bad.
 *  *
 *  * <p>Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which
 *  * causes all the following ones to be bad.
 *  *
 *  * <p>You are given an API bool isBadVersion(version) which will return whether version is bad.
 *  * Implement a function to find the first bad version. You should minimize the number of calls to
 *  * the API.
 *
 *  The snippet int mid = (low+high) >>>1; is basically int mid = (low+high)/2;
 *  but we have used bitwise operation >>>1 to prevent bugs caused by integer overflow.
 *  How Each Part Works
 *      1. low + high: Adds the lower and upper bounds together.
 *      2. >>> 1 (Unsigned Right Shift): Shifts all bits of the integer sum to the right by 1 position, filling the leftmost bit with 0.
 *          In binary arithmetic, shifting right by 1 is equivalent to integer division by 2 (2^1).
 *
 *  Why use >>>1 instead of /2?
 *  Preventing Negative Indices from Integer Overflow
 *      In Java, a signed 32-bit integer (int) has a maximum value of 2,147,483,647.
 *      If low and high are very large indices (common in massive arrays or database systems), their sum can exceed Integer.MAX_VALUE.
 *
 *      Standard Division ((low + high) / 2):
 *      If low + high overflows, the number wraps around into a negative value.
 *      Dividing a negative number by 2 (-2 / 2) results in a negative mid-point, throwing an ArrayIndexOutOfBoundsException.
 *
 *      Unsigned Right Shift ((low + high) >>> 1):
 *        The >>> operator treats the 32-bit pattern as an unsigned integer.
 *        Even if the sum overflows into a negative representation, >>> 1 interprets those bits as a massive positive number and shifts it correctly,
 *        yielding the exact correct midpoint without crashing or returning a negative index.
 *
 */
public class FirstBadVersion {

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(16283945));
    }

    public int firstBadVersion(int n){
        int low=0;
        int high =n;
        while(low < high){
            int mid = (low+high) >>>1;
            if(isBadVersion(mid)){
                high = mid;
            }else low = mid+1;
        }
        return high;
    }

    private boolean isBadVersion(int n){
        if(n>=17283945){
            return true;
        }
        return false;
    }
}
