package Binary_Search;

/*
        * LEETCODE: 162. Find Peak Element
        * https://leetcode.com/problems/find-peak-element

 */

public class PeakElement {
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1, mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            // if we found any greater element in either side of mid
            // there must be present peak element
            // or chances are very high
            // so we'll move towards greater element
            if (nums[mid] < nums[mid + 1]) {
                l = mid + 1;
            } else
                r = mid;
        }
        return l;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 5, 6, 4 };
        System.out.println(findPeakElement(arr));
    }
}
