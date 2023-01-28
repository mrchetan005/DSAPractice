package Binary_Search;

/*
        * LEETCODE: 540. Single Element in a Sorted Array
        * https://leetcode.com/problems/single-element-in-a-sorted-array
 */

/*
       * In brute force, take xor of all elements, xor will contain unique value and all duplicates get cancelled 
       * time complexity will be O(n) because traversal of all elements
       * As array is sorted, go for binary search
       * length of array will always be odd then assume two parts in one part all the duplicates lies and in other part other duplicates except one
       * if first part are all containing duplicates first instance of duplicate element is at even index and 2nd instance is at odd index 
       * So if found the first and secode instance at its position then our single element will be at another part, then shrink the area with moving start to one step ahead of mid else first and second instances are not at their position then the single is present in this part only, so shrink area by shift high to mid
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
