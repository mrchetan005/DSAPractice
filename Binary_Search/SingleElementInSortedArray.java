package Binary_Search;

/*
        * LEETCODE: 540. Single Element in a Sorted Array
        * https://leetcode.com/problems/single-element-in-a-sorted-array
 */

/*
       * In brute force, take xor of all elements, xor will contain unique value and all duplicates get cancelled 
       * time complexity will be O(n) because traversal of all elements
       * 
       * As array is sorted, go for binary search
       * length of array will always be odd then assume two parts in one part all the duplicates lies and in other part other duplicates except one
       * 
       * 0 1 2 3 4 5 6 <- index
       * 1 1 2 2 3 4 4 <- array elements
       * 
       * now see, mid element is at index 3, at its LHS its duplicate is present which is at index 2
       * as we can see that single element is not present on LHS the pair starting at even index number and ending at odd index number
       * 
       * 0 1 2 3 4 5 6 <- index
       * 3 1 1 2 2 4 4 <- array elements
       * 
       * now see in this example, mid element is again at index 3 but now that element's duplicate is now at RHS
       * as single element is present on LHS we see that pair starting at odd index number and ending at even index number
       * 
       * so we can conclude that we have to check where the pair's duplicate element lies 
       * if mid index is odd and it's duplicate is at left side or mid index is even and it's duplicate is at right side then we have to check on right side of mid 
       * else we have check on left side of mid
       * 
       */

public class SingleElementInSortedArray {
    public static int singleNonDuplicateBruteForce(int[] nums) {
        // tc => O(n) & sc => O(1)
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

    public static int singleNonDuplicate(int[] nums) {
        // tc => O(log(n)) & sc => O(1)
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0, high = nums.length - 1, mid = 0;
        while (low < high) {
            mid = low + ((high - low) >> 1);
            // trick here
            // if any number is even, xor with 1 gives number + 1
            // if any number is odd, xor with 1 gives number - 1
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 8, 8, 9 };
        int[] arr2 = { 2, 3, 3, 7, 7, 11, 11 };
        System.out.println(singleNonDuplicate(arr));
        System.out.println(singleNonDuplicateBruteForce(arr));
        System.out.println(singleNonDuplicate(arr2));
        System.out.println(singleNonDuplicateBruteForce(arr2));
    }
}
