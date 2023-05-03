package Hash_Table;

import java.util.*;

/*
        * 128. Longest Consecutive Sequence
        * Problem Statement: Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
        * You must write an algorithm that runs in O(n) time.
        Example 1:
            Input: nums = [100,4,200,1,3,2]
            Output: 4
            Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
        Example 2:
            Input: nums = [0,3,7,2,5,8,4,6,0,1]
            Output: 9
        Constraints:
            0 <= nums.length <= 10^5
            -10^9 <= nums[i] <= 10^9
 */

/*
        * brute force
        * we can sort the array and check for previous number is number-1 and we'll skip the number which is equal to the previous number and store the max cnt else set cnt to 1
        
        * for O(n) time complexity we'll use HashSet
        * first we'll add all values to set
        * then we'll iterate over HashSet and check if number-1 is not present in set then we'll again take while loop untill the number+1 is not present in set and we'll increment cnt each time and then store / update the max cnt and set cnt to 1
        * So inside loop there's another while loop which is taking time complexity O(n+n) and not O(n^2) because we're going to that loop only when number-1 is not present in HashSet
        * space complexity will be O(n) because we're creating new HashSet
 */

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        // tc => O(nlog(n)) & sc => O(1)
        // Arrays.sort(nums);
        // int cnt = 1, max = 1;
        // for (int i = 1; i < nums.length; i++) {
        // // corner case => skip the number if it is repeating
        // if (nums[i] == nums[i - 1]) {
        // continue;
        // }
        // if (nums[i - 1] == nums[i] - 1) {
        // cnt++;
        // max = Math.max(max, cnt);
        // } else {
        // cnt = 1;
        // }
        // }
        // return max;

        // tc => O(n) & sc => O(n)
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1, cnt = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                cnt = 1;
                while (set.contains(++num)) {
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 100, 4, 101, 3, 2, 102, 1, 4, 5 };
        System.out.println(longestConsecutive(arr));
    }
}
