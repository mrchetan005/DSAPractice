package Arrays;

import java.util.*;

/*
        * Missing And Repeating Numbers

        * Problem Statement: You are given an array of size The elements of the array are in the range from I to Ideally, the array should contain elements from 1 to 'N'. But due to some miscalculations, there is a number R in the range (1, Nl which appears in the array twice and another number M in the range [1, N] which is missing from the array.
        Your task is to find the missing number (M) and the repeating number (R).
        For example: 
            Consider an array of size six. The elements of the array are { 6, 4, 3, 5, 5, I }. The array should contain elements from one to six. Here, 2 is not present and 5 is occurring twice. Thus, 2 is the missing number (M) and 5 is the repeating number
 */

/*
       * brute force
       
       * take a temp array of size n+1
       * increment the given array value's index in the temp
       * now check for any value in temp array is 0 and 2 starting from index 1
       * update missing value if found 0 and repeating if found 2
        
       
       * efficient way using xor (bit manipulation)
       
       * take xor of all values of given array and then take xor with 1 to n to make their values cancel each other and remaining is only repeated number and missing number's xor value
       * we observe that in xor, we should get bit 1 iff both bits are different 
       * so if we find right most set bit (rmsb) of xor and we'll divide the array values in which we'll get those values whose rmsb position is set or not 
       * create two variables x and y and by taking xor with those values whose rmsb's position set and not set respectively, we get two values
       * again we'll repeate this with values 1 to n also to cancel out the other values
       * now we have two values, we have to find out which is repeating and which is missing
       * So we'll simply loop and check which is equal to any given arrray value, and we'll get which one is repeating and hence other is definately missing value
       * return both values...
       
 */

public class MissingAndRepeatingNumbers {
    public static int[] missingAndRepeating(int[] arr, int n) {
        // tc => O(n) & sc => O(n)
        // int missing = 0, repeating = 0;
        // int[] temp = new int[n + 1];
        // for (int i = 0; i < n; i++) {
        // temp[arr[i]]++;
        // }
        // for (int i = 1; i <= n; i++) {
        // if (temp[i] == 0) {
        // missing = i;
        // }
        // if (temp[i] > 1) {
        // repeating = i;
        // }
        // }
        // return new int[] { missing, repeating };

        // bit manipulation
        // tc => O(n) & sc => O(1)
        int x_y = 0;
        for (int val : arr) {
            x_y ^= val;
        }
        for (int i = 0; i <= n; i++) {
            x_y ^= i;
        }

        int rmsb = (x_y & -x_y);
        int x = 0, y = 0;

        for (int val : arr) {
            if ((val & rmsb) == 0) {
                x ^= val;
            } else {
                y ^= val;
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((rmsb & i) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }

        for (int val : arr) {
            if (x == val) {
                return new int[] { y, x };
            } else if (y == val) {
                return new int[] { x, y };
            }
        }
        return new int[] { x, y };
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 6, 4, 3, 5, 5, 1 };
        int[] ans = missingAndRepeating(arr, arr.length);
        System.out.println(Arrays.toString(ans));
    }
}
