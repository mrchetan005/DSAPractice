package Arrays;

/*
        * LEETCODE: 152. Maximum Product Subarray
        * https://leetcode.com/problems/maximum-product-subarray/
 */

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0], maxTillNow = nums[0], minTillNow = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // if current value is less than 0
            // swap values of maxTillNow and minTillNow,
            // because product of negatives becomes positive
            if (nums[i] < 0) {
                int temp = maxTillNow;
                maxTillNow = minTillNow;
                minTillNow = temp;
            }

            // keep updating maximum and minimum product till now
            maxTillNow = Math.max(nums[i], maxTillNow * nums[i]);
            minTillNow = Math.min(nums[i], minTillNow * nums[i]);

            // keep updating the maxProduct along with maxTillNow
            maxProduct = Math.max(maxProduct, maxTillNow);
        }
        return maxProduct;
    }

    // driver code
    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(maxProduct(nums));
    }
}
