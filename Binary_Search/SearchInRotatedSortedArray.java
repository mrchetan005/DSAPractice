package Binary_Search;

/*
        * LEETCODE: 33. Search In Rotated Sorted Array
        * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class SearchInRotatedSortedArray {
    public static int searchBetterWay(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        while (start <= end) {
            mid = start + ((end - start) >> 1);
            // if target found return mid
            if (nums[mid] == target) {
                return mid;
            }
            // if left part of mid is sorted,
            // mid element will be greater than start element
            if (nums[start] < nums[mid]) {
                // check if target is greater than or equal to starting index
                // and target is less than mid element
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            // else right part of mid might be sorted
            else {
                // check if target smaller than or equal to ending index
                // and target is greater than mid element
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        // if target not found return -1
        return -1;
    }

    private static int binarySearch(int[] arr, int l, int r, int target) {
        // traditional binary search
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    private static int searchSmallestElement(int[] arr) {
        int l = 0, r = arr.length - 1, mid = 0;
        while (l < r) {
            mid = l + (r - l) / 2;
            // compare mid element with right element
            // go towards smallest element side
            if (arr[mid] > arr[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        // if left and right will be at same postion
        // both l and r reach at smallest element
        // so we can return both l or r
        return r;
    }

    public static int searchWay2(int[] nums, int target) {
        int pivot = searchSmallestElement(nums);
        int searchInLeft = binarySearch(nums, 0, pivot - 1, target);
        if (searchInLeft == -1) {
            int searchInRight = binarySearch(nums, pivot, nums.length - 1, target);
            return searchInRight;
        }
        return searchInLeft;
    }

    // driver code
    public static void main(String[] args) {
        // int[] arr = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int[] arr = { 4, 5, 0, 1, 2, 3 };
        int target = 6;
        System.out.println(searchBetterWay(arr, target));
        System.out.println(searchWay2(arr, target));
    }
}
