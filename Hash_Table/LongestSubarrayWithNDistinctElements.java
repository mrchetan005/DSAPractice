package Hash_Table;

import java.util.*;

/*
        * LEETCODE: 904. Fruits Into Basket
        * https://leetcode.com/problems/fruit-into-baskets/


        * Problems related to this :
        * Find longest subarray with n distinct elements
        * Find longest subarray length with n distinct elements
 */

public class LongestSubarrayWithNDistinctElements {
    public static int[] longestSubarray(int[] arr, int k) {
        int left = 0, maxLength = 0, n = arr.length, start = 0, end = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int right = 0; right < n; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);
            while (freqMap.size() > k) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if (freqMap.get(arr[left]) == 0) {
                    freqMap.remove(arr[left]);
                }
                left++;
            }
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
                end = right;
            }
        }
        return new int[] { start, end, maxLength };
    }

    public static int[] longestSubarray1(int[] arr, int k) {
        int left = 0, maxLength = 0, n = arr.length, size = 0, start = 0, end = 0;
        int[] freqArr = new int[100007];
        for (int right = 0; right < n; right++) {
            if (freqArr[arr[right]] == 0)
                size++;
            freqArr[arr[right]]++;
            while (size > k) {
                freqArr[arr[left]]--;
                if (freqArr[arr[left]] == 0) {
                    size--;
                }
                left++;
            }
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
                end = right;
            }
        }
        return new int[] { start, end, maxLength };
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        System.out.println(Arrays.toString(longestSubarray(arr, 2)));
        System.out.println(Arrays.toString(longestSubarray1(arr, 2)));
    }
}
