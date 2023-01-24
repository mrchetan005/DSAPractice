package Arrays;

/*
        * LEETCODE: 42. Trapping Rain Water
        * https://leetcode.com/problems/trapping-rain-water
 */

public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        // using prefim max and suffix max
        // tc => O(n) & sc => O(n)
        int n = height.length, i = 0, totalStorage = 0, storage = 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // finding all max height to the left
        leftMax[0] = height[0];
        for (i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // finding all max height to the right
        rightMax[n - 1] = height[n - 1];
        for (i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // finding minimum height of leftMax and rightMax
        // and subtracting the current height from it
        for (i = 0; i < n; i++) {
            storage = Math.min(leftMax[i], rightMax[i]) - height[i];
            totalStorage += (storage > 0) ? storage : 0;
        }
        return totalStorage;
    }

    public static int trapOptimal(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        // using two pointers
        // tc => O(n) & sc => O(1)
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0,
                totalStorage = 0;
        while (left < right) {
            // if height of left less than the right
            // then we'll update the leftMax with left height
            // and update the total storage by taking difference between
            // maximum from left and left height
            if (height[left] <= height[right]) {
                if (leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    totalStorage += leftMax - height[left];
                }
                left++;
            }
            // similarly if height right is less than left
            // then we'll update rightMax with right height
            // and update the total storage by taking difference between
            // maximum from right and right height
            else {
                if (rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    totalStorage += rightMax - height[right];
                }
                right--;
            }
        }
        return totalStorage;
    }

    // driver code
    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(trap(height));
    }
}
