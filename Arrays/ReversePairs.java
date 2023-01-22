package Arrays;

/*
        * LEETCODE: Reverse Pairs
        * Problem Statement: Given an integer array nums, return the number of reverse pairs in the array. 
        * A reverse pair is a pair (i, j) where:
        * 0 <= i < j < nums.length and
        * nums[i] > 2 * nums[j].
        Example 1:
            Input: nums = [1,3,2,3,1]
            Output: 2
        Explanation: The reverse pairs are:
            (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
            (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
        Example 2:
            Input: nums = [2,4,3,5,1]
            Output: 3
        Explanation: The reverse pairs are:
            (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
            (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
            (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
        Constraints:
            1 <= nums.length <= 5 * 10^4
            -2^31 <= nums[i] <= 2^31 - 1
 */

/*
       * brute force is take two loops and check the condition arr[i] > 2 * arr[j] then coount it ... This will have time complexity O(n^2) which can give time limit exceeded error for big input array
       * 
       * we can improve this by merge sort algorithm with O(nlog(n)) time complexity
       * this is similar question to the inversion count where we check how much elements are less to the right side of the element
       * here also we have to check arr[i] > 2 * arr[j]
       * we know the condition that if any element right side of mid is less than the element left of the mid then all elements till mid also less than right side's element because both the sides are sorted, so formula is (cnt += mid - i + 1)
       * so we'll keep this condition different and the other part is same as merge sort...
 */

public class ReversePairs {
    public static int reversePairs(int[] nums) {
        // tc => O(nlog(n)) & sc => O(n)
        return mergeSort(nums, new int[nums.length], 0, nums.length - 1);
    }

    public static int mergeSort(int[] arr, int temp[], int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int cnt = mergeSort(arr, temp, start, mid);
        cnt += mergeSort(arr, temp, mid + 1, end);
        cnt += merge(arr, temp, start, mid, end);
        return cnt;
    }

    public static int merge(int[] arr, int[] temp, int start, int mid, int end) {
        int i = start, j = mid + 1, k = start, cnt = 0;
        while (i <= mid && j <= end) {
            if (arr[i] <= (2L * arr[j])) {
                i++;
            } else {
                cnt += mid - i + 1;
                j++;
            }
        }
        i = start;
        j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (i = start; i <= end; i++) {
            arr[i] = temp[i];
        }
        return cnt;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 2, 4, 3, 5, 1 };
        System.out.println(reversePairs(arr));
    }
}
