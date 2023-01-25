package Arrays;

/*
    * 209. Minimum Size Subarray Sum
    * https://leetcode.com/problems/minimum-size-subarray-sum/
 */

/*
       * we can use sliding window approach here
       * we'll add sum until it is less than taget with right pointer
       * then after that we'll subtract from sum untill its grater than equal to target with left pointer and update the minimum length of subarray with right-left+1 and previous minimum
 */

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        // tc => O(n) & sc => O(1)
        int l = 0, r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (r < nums.length) {
            while (sum < target && r < nums.length) {
                sum += nums[r++];
            }
            while (sum >= target) {
                sum -= nums[l++];
            }
            min = Math.min(min, r - l + 1);
        }
        return min > nums.length ? 0 : min;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(minSubArrayLen(target, arr));
    }
}
