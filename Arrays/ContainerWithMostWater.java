package Arrays;

/*
    * LEETCODE: Container With Most Water
    * https://leetcode.com/problems/container-with-most-water/
 */

/*
   * take two pointers at start and end of array
   * find minimum between left and right pointer
   * the total amount of water can be stored in between left & right column is (right-left) * min
   * so keep track of max water storage with this water storage
   * shrink he area by moving the small height column inside
   *  
*/

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWaterStorage = Integer.MIN_VALUE;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            int waterStorage = (right - left) * min;

            maxWaterStorage = Math.max(maxWaterStorage, waterStorage);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWaterStorage;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(arr));
    }
}
