package Binary_Search;

import java.util.*;

/*
        * Matrix Median
        * Problem Statement: Given a matrix of integers A of size N x M in which each row is sorted. Find and return the overall median of matrix A.
        NOTE: No extra memory is allowed.
        NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
        Problem Constraints
            1 <= N, M <= 10^5
            1 <= N*M <= 10^6
            1 <= A[i] <= 10^9
            N*M is odd
        Example Input
        Input 1: 
            A = [   [1, 3, 5],
                    [2, 6, 9],
                    [3, 6, 9]   ] 
        Output 1: 5 
        Explanation 1: 
            A = [1, 2, 3, 3, 5, 6, 6, 9, 9]
            Median is 5. So, we return 5. 
        Input 2: 
            A = [[5, 17, 100]]
        Output 2: 17

 */

/*
        * given odd length sorted matrix list, we need to find that element which has equal elements on its left and equal elements on its right if we put them in a single line
        * create an arraylist and add all elements to that list and sort the list and return the middle element
        * but this will take time complexity O(n*mlog(n*m)) to sort the array and space complexity O(n*m) to store the list in a single line
        * for optimal solution use binary search within range 1 to 1e9 (according to constraints) 
        * It is sure that median element has same number of elements in its left and right
        * start binary search and find mid
        * then count how many numbers are smaller or equal to mid using again separate binary search for every row 
        * and then check that count is less than or equal to (i.e. in left side of the mid) number of elements we want for median (i.e (n*m)/2 elements) 
        * if count is less search on right side elese search on left side
        * as search area will shrink and we'll have our ans inside low then return low
 */

public class MatrixMedian {

    private static int countSmallerThanOrEqualToMid(ArrayList<Integer> arr, int m) {
        int low = 0, high = arr.size() - 1, mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (arr.get(mid) <= m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        // tc => nlog(m) & sc => O(1)
        int low = 1, high = (int) 1e9, n = matrix.size(), m = matrix.get(0).size();
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int cnt = 0;
            for (ArrayList<Integer> arr : matrix) {
                cnt += countSmallerThanOrEqualToMid(arr, mid);
            }
            if (cnt <= ((n * m) >> 1)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    // driver code
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        al.add(list);
        System.out.println(getMedian(al));
    }
}
