package com.examples.algo.patterns.twopointers;

import java.util.HashMap;
import java.util.Map;


/**
 *  * Given a string, find the length of the longest
 *  * substring without repeating characters.
 *  *
 *  * <p>Examples:
 *  *
 *  * <p>Given "abcabcbb", the answer is "abc", which the length is 3.
 *  *
 *  * <p>Given "bbbbb", the answer is "b", with the length of 1.
 *  *
 *  * <p>Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 *  * substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringMain {

    public static void main(String[] args) {

        System.out.println(new LongestSubstringMain().longestSubstringLength("abcabcaa"));
    }

    private int longestSubstringLength(String s){

        if(s == null || s.isEmpty()) return 0;

        int left=0;
        int max = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();

        for(int right=0;right<s.length();right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1,left);
            }

            map.put(s.charAt(right),right);
            max = Math.max(max,(right - left)+1);
        }

        return max;
    }
}
