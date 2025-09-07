package com.examples.algo.twopointers;
public class PalindromeMain {
    public static void main(String[] args) {
       String s = "TAKE U FORWARD";
       System.out.println("given string is palindrome:: "+ isPalindrome(s));
    }
    
    static boolean isPalindrome(String s){
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length-1;
        
        
        while(left < right){
            char l= str[left]; char r=str[right];
            if(!Character.isLetterOrDigit(l)){
                left++;
            }else if(!Character.isLetterOrDigit(r)){
                right--;
            }else if(Character.toLowerCase(l) != Character.toLowerCase(r)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}