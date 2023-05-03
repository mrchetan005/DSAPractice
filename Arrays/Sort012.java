package Arrays;

import java.util.*;

/*
    * LEETCODE: 75.Sort Colors
    * Problem Statement: Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.

    Example 1:

    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
    Example 2:

    Input: nums = [2,0,1]
    Output: [0,1,2]
    

    Constraints:

    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2.
 */

/*
 * counting sort 
       take size 3 array and traverse the given array 
       increment cnt array's elements
       start filling back the array with decrementing cnt array values
   
 * Dutch National Flag Algorithm
       take three pointers left, mid and right
       start traversing array 
       if arr[mid] is equal to 0 swap with arr[left] and increment both left and mid
       if arr[mid] is equal to 1 then increment mid
       and if arr[mid] is equal to 2 swap with arr[right] and decrement right
 */

public class Sort012 {

    public static void sort012CountingSort(int[] nums) {
        // using counting sort tc => O(n) sc => O(1)
        if (nums.length == 0)
            return;
        int n = nums.length;
        int[] cnt = new int[3];
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        int i = 0, j = 0;
        while (j < 3) {
            while (cnt[j]-- > 0) {
                nums[i++] = j;
            }
            j++;
        }
    }

    public static void sort012(int[] arr) {
        if (arr.length == 1)
            return;
        int n = arr.length;
        int l = 0, m = 0, r = n - 1;
        while (m <= r) {
            switch (arr[m]) {
                case 0: {
                    swap(arr, l++, m++);
                    break;
                }
                case 1: {
                    m++;
                    break;
                }
                case 2: {
                    swap(arr, r--, m);
                    break;
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sort01(int[] arr) {
        // tc => O(n) & sc => O(1)
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] == 0) {
                i++;
            } else if (arr[j] == 1) {
                j--;
            } else {
                arr[i++] = 0;
                arr[j--] = 1;
            }
        }
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 2, 0, 1, 0, 2 };
        sort012(arr);
        int[] nums = { 0, 1, 0, 2, 2, 0, 1, 0, 2 };
        sort012CountingSort(nums);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(nums));

        int[] arr01 = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0 };
        sort01(arr01);
        System.out.println(Arrays.toString(arr01));
    }
}
