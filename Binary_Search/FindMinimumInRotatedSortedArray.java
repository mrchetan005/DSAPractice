package Binary_Search;

/*
        * LEETCODE: 153. Find Minimum in Rotated Sorted Array 
        * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/


        * LEETCODE: 154. Find Minimum in Rotated Sorted Array II
        * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        // tc => O(log(n)) & sc => O(1)

        int n = nums.length;
        int l = 0, r = n - 1, mid = 0;

        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return nums[l];
    }

    public static int findMinII(int[] nums) {
        // tc => O(log(n)) & sc => O(1)

        int n = nums.length;
        int l = 0, r = n - 1, mid = 0;

        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                r--;
            }
        }

        return nums[l];
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 7, 8, 1, 3, 4, 5, 6 };
        System.out.println(findMin(arr));

        int[] duplicateArr = { 7, 7, 7, 7, 7, 7, 8, 9, 1, 3, 7, 7 };
        System.out.println(findMinII(duplicateArr));
    }
}
