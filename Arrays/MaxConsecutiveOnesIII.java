package Arrays;

/*
       * LEETCODE: 1004 Max Consecutive Ones III
       * https://leetcode.com/problems/max-consecutive-ones-iii
*/

/*
       * we can do this with sliding window algorithm
       * take two pointers left and right
       * if (arr[right] == 0) then decrement k (k is flip's count) 
       * if k becomes negative keep moving left until arr[left] equals 0
       * if we found arr[left] equals 0 increment k
       * return (right - left) because this window contains maximum number of ones produced by flipping at most k 0s...
*/

public class MaxConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }
            if (k < 0 && nums[left++] == 0) {
                k++;
            }
            right++;
        }
        return right - left;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        System.out.println(longestOnes(arr, k));
    }
}
