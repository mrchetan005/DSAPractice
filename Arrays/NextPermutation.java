package Arrays;

import java.util.*;

/*
        LEETCODE: 31. Next Permutation
        Problem Statement: A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

        For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
        The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

        For example, the next permutation of arr = [1,2,3] is [1,3,2].
        Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
        While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
        Given an array of integers nums, find the next permutation of nums.

        The replacement must be in place and use only constant extra memory.

        Example 1:

        Input: nums = [1,2,3]
        Output: [1,3,2]
        Example 2:

        Input: nums = [3,2,1]
        Output: [1,2,3]
        Example 3:

        Input: nums = [1,1,5]
        Output: [1,5,1]
 */

/*
        * take i and traverse from back and check arr[i]<arr[i+1] or not and do i--
        * To maintain lexicographical order we'll find next big element right side of ith element
        * so take j and traverse from back and check arr[i]<arr[j] or not and do j--
        * swap arr[i] and arr[j]
        * reverse the array from (i+1)th element to end element of array, we'll get ans
 */

public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        // tc => O(n) sc = O(1)
        if (nums.length <= 1) {
            return;
        }
        int n = nums.length;
        // traverse from back to get break point
        int i = n - 2;
        for (; i >= 0 && nums[i] >= nums[i + 1]; i--)
            ;

        // check if we get any break point or not
        if (i >= 0) {
            // traverse again from backside to get element just greater than idx1
            // to maintain lexicographical order
            int j = n - 1;
            for (; nums[j] <= nums[i]; j--)
                ;
            // if idx2 is changed swap the both elements at idx1 and idx2
            swap(nums, i, j);
        }

        // now reverse the array
        i++;
        n--;
        while (i < n) {
            swap(nums, i++, n--);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        // if array elements are non negative we can use xor to swap
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int[] arr1 = { 3, 2, 1 };
        int[] arr2 = { 1, 1, 5 };
        nextPermutation(arr); // [1,3,2]
        nextPermutation(arr1); // [1,2,3]
        nextPermutation(arr2); // [1,5,1]
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
