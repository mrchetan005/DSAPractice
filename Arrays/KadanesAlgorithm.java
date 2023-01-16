package Arrays;

import java.util.*;

/*
    * LEETCODE: 53. Maximum Subarray
    * Problem Statement: Given an integer array nums,find the subarray with the largest sum, and return its sum.

    Example 1:

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    Example 2:

    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.
    Example 3:

    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 
 */

/*
   * take max and currSum
   * traverse elements add elements to currSum and keep updating max with currSum
   * if currSum will be negative set it to 0
   * we'll get maximum sum inside max, return it...
 */

public class KadanesAlgorithm {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
            if (currSum < 0)
                currSum = 0;
        }
        return maxSum;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] arr1 = { -13, -42, -15, -9, -15, -31 };
        System.out.println(maxSubArray(arr)); // 6
        System.out.println(maxSubArray(arr1)); // -9
    }
}
