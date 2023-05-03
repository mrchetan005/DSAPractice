package Arrays;

import java.util.*;

/*
        * Find K Largest Elements
        * Problem Statement : Write a program to print K largest elements in an array. Elements in an array can be in any order. Write a solution which is both time and space optimized.

        Examples:

        Input:  [1, 23, 12, 9, 30, 2, 50], K = 3
        Output: 50, 30, 23

        Input:  [11, 5, 12, 9, 44, 17, 2], K = 2
        Output: 44, 17

        const arr = [1,3,41,-2,2,7,5,0,7];
        * 
 */

public class KLargestElements {
    // time complexity => O(n log(k))
    // space complexity => O(k)

    private static int[] findKLargestElements(int[] arr, int k) {
        if (k >= arr.length) {
            return arr;
        }
        int[] res = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 1, 3, 41, -2, 2, 7, 5, 0, 7 };
        int k = 2;
        int[] kLargestElements = findKLargestElements(arr, k);
        System.out.println(Arrays.toString(kLargestElements));
    }
}
