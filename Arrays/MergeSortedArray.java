package Arrays;

import java.util.*;

/*
        * LEETCODE: 88. Merge Sorted Array
        * Problem Statement: You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

        Merge nums1 and nums2 into a single array sorted in non-decreasing order.

        The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

        Example 1:
        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        Output: [1,2,2,3,5,6]
        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
        Example 2:
        Input: nums1 = [1], m = 1, nums2 = [], n = 0
        Output: [1]
        Explanation: The arrays we are merging are [1] and [].
        The result of the merge is [1].
        Example 3:
        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
        Output: [1]
        Explanation: The arrays we are merging are [] and [1].
        The result of the merge is [1].
        Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
        
        Constraints:
            nums1.length == m + n
            nums2.length == n
            0 <= m, n <= 200
            1 <= m + n <= 200
            -10^9 <= nums1[i], nums2[j] <= 10^9
        

        Follow up: Can you come up with an algorithm that runs in O(m + n) time?
 */

/*
       * take three pointers: i,j and k to traverse the array
       * start traversing from right side 
       * i.e. i from (m-1)th index, j from (n-1)th index and k from (m+n-1)th index
       * check for which array has big value 
       * if first array has greater value then assign it to the end of first array
       * else assign second array's value to end of first array
       * keep decrementing respective pointers and checking that don't go out of bound

 */

public class MergeSortedArray {
    // LEETCODE que. solution
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // tc => O(n+m) sc => O(1)
        int i = m - 1, j = n - 1, k = m + n - 1;
        // start traversing from end and check which one is bigger
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    /*
     * Merge two sorted arrays in which first array should have smaller elements
     * than second array
     * Example input: ar1 => [1,4,7,8,10] & ar2 => [2,3,9]
     * output: ar1 => [1,2,3,4,7] & ar2 => [8,9,10]
     */
    public static void mergeBruteForce(int[] a, int[] b) {
        // tc => O(n+m) & sc => O(n+m)
        int m = a.length, n = b.length;
        int temp[] = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (a[i] < b[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = b[j++];
            }
        }
        while (i < m) {
            temp[k++] = a[i++];
        }
        while (j < n) {
            temp[k++] = b[j++];
        }
        i = 0;
        j = 0;
        k = 0;
        while (i < m) {
            a[i++] = temp[k++];
        }
        // k--;
        while (j < n) {
            b[j++] = temp[k++];
        }
    }

    public static void mergeBruteForceNoExtraSpace(int[] a, int[] b) {
        // tc => O(n*m) & sc => O(1)
        int m = a.length, n = b.length, i = 0, j = 0;
        while (i < m && j < n) {
            // if we found large element in first array we'll swap it to second array
            if (a[i] > b[j]) {
                int t = a[i];
                a[i] = b[j];
                b[j] = t;

                // after swapping we've to mainatin the secode array sorted
                // so we'll sort that array to correct order
                for (int k = j; k < n - 1; k++) {
                    if (b[k] > b[k + 1]) {
                        int temp = b[k];
                        b[k] = b[k + 1];
                        b[k + 1] = temp;
                    } else {
                        break;
                    }
                }
            } else {
                i++;
            }
        }
    }

    // In this Gap Algorithm, we'll find the half of both array's lengths (m+n)
    // and traverse both the arrays as they are in a single line until the gap
    // becomes 0 we'll keep dividing the gap by 2
    // and we'll swap the elements if the right pointer will be smaller than left

    public static void mergeBetterNoExtraSpace(int[] a, int[] b) {
        // GAP ALGORITHM / Shell Short Algorithm
        // tc => O((n+m)log(n+m)) & sc => O(1)
        int m = a.length, n = b.length, gap = (int) Math.ceil((n + m) / 2.0);
        int l = 0, r = 0;
        while (gap > 0) {
            l = 0;
            r = gap;
            while (r < (m + n)) {
                if (r < m && a[l] > a[r]) {
                    int t = a[l];
                    a[l] = a[r];
                    a[r] = t;
                } else if (r >= m && l < m && a[l] > b[r - m]) {
                    int t = a[l];
                    a[l] = b[r - m];
                    b[r - m] = t;
                } else if (r >= m && l >= m && b[l - m] > b[r - m]) {
                    int t = b[l - m];
                    b[l - m] = b[r - m];
                    b[r - m] = t;
                }
                l++;
                r++;
            }
            gap = (gap == 1) ? 0 : (int) Math.ceil(gap / 2.0);
        }
    }

    // driver code
    public static void main(String[] args) {
        // int m = 3, n = 3;
        // int[] arr = { 1, 4, 6, 0, 0, 0 };
        // int[] arr1 = { 2, 3, 5 };
        // merge(arr, m, arr1, n); // 1 2 3 4 5 6
        // System.out.println(Arrays.toString(arr));
        int[] a = { 1, 4, 7, 8, 10 };
        int[] b = { 2, 3, 9 };
        // mergeBruteForce(a, b);
        // mergeBruteForceNoExtraSpace(a, b);
        mergeBetterNoExtraSpace(a, b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }
}
