package Arrays;

import java.util.*;

/*
        * Longest Sub-Array With Sum K
        * Problem Statement: Given an array containing N integers and an integer K. Your task is to find the length of the longest Sub-Array with sum of the elements equal to the given value K.
 */

/*
        * Largest Subarray With 0 Sum
        * Problem Statement: Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
        Example 1:
            Input:
            N = 8
            A[] = {15,-2,2,-8,1,7,10,23}
            Output: 5
            Explanation: The largest subarray with sum 0 will be -2 2 -8 1 7.
        Your Task:
            You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.
        * Expected Time Complexity: O(N).
        * Expected Auxiliary Space: O(N).

        Constraints:
            1 <= N <= 10^5
            -1000 <= A[i] <= 1000, for each valid i
 */

public class LargestSubArrayWithKSum {
    public static int LongSubarrWithSum0(int arr[], int n) {
        // tc => O(nlog(n)) & sc = O(n)
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) {
                max = i + 1;
            }
            if (map.get(sum) == null) {
                map.put(sum, i);
            } else {
                max = Math.max(max, i - map.get(sum));
            }
        }
        return max;
    }

    static int LongSubarrWithSumK(int[] arr, int k) {
        // HashMap to store (sum, index) tuples
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            // accumulate sum
            sum += arr[i];
            // when subarray starts from index '0'
            if (sum == k) {
                maxLen = i + 1;
            }
            // make an entry for 'sum' if it is not present in 'map'
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            // check if 'sum-k' is present in 'map' or not
            if (map.containsKey(sum - k)) {
                // update maxLength
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }
        return maxLen;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(LongSubarrWithSum0(arr, arr.length));
        int[] arr2 = { -5, 8, -14, 2, 4, 12 };
        System.out.println(LongSubarrWithSumK(arr2, -5));
    }
}
