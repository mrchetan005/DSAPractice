package Arrays;

import java.util.*;

/*
        * LEETCODE: Rotate Array
        * Problem Statement: Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

        Example 1:

        Input: nums = [1,2,3,4,5,6,7], k = 3
        Output: [5,6,7,1,2,3,4]
        Explanation:
            rotate 1 steps to the right: [7,1,2,3,4,5,6]
            rotate 2 steps to the right: [6,7,1,2,3,4,5]
            rotate 3 steps to the right: [5,6,7,1,2,3,4]
        Example 2:
        Input: nums = [-1,-100,3,99], k = 2
        Output: [3,99,-1,-100]
        Explanation: 
            rotate 1 steps to the right: [99,-1,-100,3]
            rotate 2 steps to the right: [3,99,-1,-100]
        

        Constraints:
            1 <= nums.length <= 105
            -231 <= nums[i] <= 231 - 1
            0 <= k <= 105
 */

/*
       * First Way: 
            * tc => O(n^2) & sc => O(1)
            * Rotate array by one in n times
            * rotate by taking one temp element and assign next element to curr element and finally last element to temp
            * repeat this n times
        * Second Way:
            * tc => O(n) & sc => O(n)
            * take temp array and place the values from where we want to rotate
            * reassign temp values back to array
        * Third Way:
            * tc => O(n) & sc => O(1)
            * take k %= n, because k might be larger than array length
            * reverse the array from beginning to end
            * reverse the array from begining to k-1 
            * reverse the array from k to end
       
 */

public class RotateArray {

    // ------------------ Rotate Right By K ------------------------------

    public static void rotateBruteForceRight(int[] nums, int k) {
        int n = nums.length;
        // tc => O(n^2) sc => O(1)
        for (int i = 0; i < k; i++) {
            // rotate by one
            int temp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    public static void rotateBetterRight(int[] nums, int k) {
        int n = nums.length;
        // tc => O(n) sc => O(n)
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    public static void rotateOptimalRight(int[] nums, int k) {
        int n = nums.length;
        // tc => O(n) sc => O(1)
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    // -------------------- Rotate Left By K -----------------

    public static void rotateBruteForceLeft(int[] nums, int k) {
        int n = nums.length;
        // tc => O(n^2) sc => O(1)
        for (int i = 0; i < k; i++) {
            int temp = nums[0];
            for (int j = 1; j < n; j++) {
                nums[j - 1] = nums[j];
            }
            nums[n - 1] = temp;
        }
    }

    public static void rotateBetterLeft(int[] nums, int k) {
        int n = nums.length;
        // tc => O(n) sc => O(n)
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[(i + k) % n];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }

    public static void rotateOptimalLeft(int[] nums, int k) {
        int n = nums.length;
        // tc => O(n) sc => O(1)
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
    }

    // ---------------------- Reverse the Array -----------------------

    public static void reverse(int[] arr, int l, int r) {
        while (l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    // driver code
    public static void main(String[] args) {
        int k = 3;
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        rotateBruteForceRight(arr, k); // 5 6 7 1 2 3 4
        System.out.println("Brute Force Right: " + Arrays.toString(arr));

        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        rotateBruteForceLeft(arr, k);
        System.out.println("Brute Force Left: " + Arrays.toString(arr));

        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        rotateBetterRight(arr, k); // 5 6 7 1 2 3 4
        System.out.println("Better Right: " + Arrays.toString(arr));

        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        rotateBetterLeft(arr, k);
        System.out.println("Better Left: " + Arrays.toString(arr));

        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        rotateOptimalRight(arr, k);
        System.out.println("Optimal Right: " + Arrays.toString(arr));

        arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        rotateOptimalLeft(arr, k);
        System.out.println("Optimal Left: " + Arrays.toString(arr));

    }

}
