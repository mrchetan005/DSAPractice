package Arrays;

import java.util.*;

import java.util.ArrayList;

/*
        * LEETCODE: 1. Two Sum
        * Problem Statement: Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
        * You may assume that each input would have exactly one solution, and you may not use the same element twice.
        * You can return the answer in any order.
        Example 1:
            Input: nums = [2,7,11,15], target = 9
            Output: [0,1]
            Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:
            Input: nums = [3,2,4], target = 6
            Output: [1,2]
        Example 3:
            Input: nums = [3,3], target = 6
            Output: [0,1]
        Constraints:
            2 <= nums.length <= 104
            -109 <= nums[i] <= 109
            -109 <= target <= 109
            Only one valid answer exists.
        * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

/*
       * LEETCODE: 18. 4Sum
       * Problem Statement: Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
        0 <= a, b, c, d < n
        a, b, c, and d are distinct.
        nums[a] + nums[b] + nums[c] + nums[d] == target
        You may return the answer in any order.
        Example 1:
            Input: nums = [1,0,-1,0,-2,2], target = 0
            Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        Example 2:
            Input: nums = [2,2,2,2,2], target = 8
            Output: [[2,2,2,2]]
        Constraints:
            1 <= nums.length <= 200
            -10^9 <= nums[i] <= 10^9
            -10^9 <= target <= 10^9
 */

public class TwoSumFourSum {
    public static int[] twoSum(int[] nums, int target) {
        // tc => O(n) & sc => O(n)
        // int[] ans = new int[2];
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<nums.length; i++){
        // if(map.containsKey(target - nums[i])){
        // ans[1] = i;
        // ans[0] = map.get(target - nums[i]);
        // return ans;
        // } else {
        // map.put(nums[i], i);
        // }
        // }
        // return ans;

        // tc => O(n^2) & sc => O(1)
        int i, j, k;
        for (i = 1; i < nums.length; i++) {
            for (j = i; j < nums.length; j++) {
                k = j - i;
                if ((nums[j] + nums[k]) == target) {
                    return new int[] { k, j };
                }
            }
        }
        return null;
    }

    public static List<List<Integer>> fourSum(int[] num, int target) {
        // tc => O(n^3) & sc => O(1)
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) {
            return res;
        }
        int n = num.length;
        Arrays.sort(num);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long target_2 = target - num[i] * 1L - num[j];
                int front = j + 1;
                int back = n - 1;
                while (front < back) {
                    int two_sum = num[front] + num[back];
                    if (two_sum < target_2) {
                        front++;
                    } else if (two_sum > target_2) {
                        back--;
                    } else {
                        List<Integer> quad = new ArrayList<>();
                        quad.add(num[i]);
                        quad.add(num[j]);
                        quad.add(num[front]);
                        quad.add(num[back]);
                        res.add(quad);
                        // Processing the duplicates of number 3
                        while (front < back && num[front] == quad.get(2)) {
                            front++;
                        }
                        // Processing the duplicates of number 4
                        while (front < back && num[back] == quad.get(3)) {
                            back--;
                        }
                    }
                }
                // Processing the duplicates of number 2
                while (j + 1 < n && num[j + 1] == num[j]) {
                    j++;
                }
            }
            // Processing the duplicates of number 1
            while (i + 1 < n && num[i + 1] == num[i]) {
                i++;
            }
        }
        return res;
    }

    // driver code
    public static void main(String[] args) {
        int[] a = { 2, 7, 11, 15 };
        int[] twoSum = twoSum(a, 9);
        System.out.println(Arrays.toString(twoSum));
        int[] b = { 1, 0, -1, 0, -2, 2 };
        List<List<Integer>> fourSum = fourSum(b, 0);
        System.out.println(fourSum);
    }
}
