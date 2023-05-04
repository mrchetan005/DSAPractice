package Arrays;

/*
        * Easy
        * LEETCODE: 26. Remove Duplicates From Sorted Array
        * https://leetcode.com/problems/remove-duplicates-from-sorted-array/

        * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

        * Medium
        * LEETCODE: 80. Remove Duplicates From Sorted Array II
        * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/


        * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 */

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    public static int removeDuplicatesII(int[] nums) {
        int k = 1, skip = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                skip++;
            } else {
                skip = 0;
            }
            if (skip < 2) {
                nums[k++] = nums[i];
            }

        }
        return k;
    }

    // driver code
    public static void main(String[] args) {
        int[] arr = { 1, 1, 1, 1, 2, 2, 3, 3 };
        int ansIndex = removeDuplicates(arr);

        for (int i = 0; i < ansIndex; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        int[] arrII = { 1, 1, 1, 1, 2, 2, 3, 3 };
        int ansIndexII = removeDuplicatesII(arrII);

        for (int i = 0; i < ansIndexII; i++) {
            System.out.print(arrII[i] + " ");
        }

    }
}
