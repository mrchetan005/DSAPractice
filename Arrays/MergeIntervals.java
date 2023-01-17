package Arrays;

import java.util.*;

/*
        * LEETCODE: 56. Merge Intervals
        * Problem Statement: Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

        Example 1:
        Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
        Output: [[1,6],[8,10],[15,18]]
        Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
        Example 2:
        Input: intervals = [[1,4],[4,5]]
        Output: [[1,5]]
        Explanation: Intervals [1,4] and [4,5] are considered overlapping.
        
        Constraints:
            1 <= intervals.length <= 10^4
            intervals[i].length == 2
            0 <= starti <= endi <= 10^4
 */

/*
        * sort the array and take two pointers start and end and assign first interval
        * traverse the array 
        * check if start value of current interval is less or equal
        * then keep updating max between the previous end value and current end value
        * else add the interval to ans list
        * and update the start and end pointers of interval
        * because we're adding the interval inside else condition
        * add the last interval which is not added inside loop
        * return the list by converting to array by .toArray() method


 */

public class MergeIntervals {
    // tc => O(n log(n)) + O(n) ~ O(n log(n)) & sc => O(n^2)
    public static int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();

        if (intervals.length == 0 || intervals == null) {
            return ans.toArray(new int[0][]);
        }

        // sort the intervals array using comparator
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // take two pointers start and end
        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int[] i : intervals) {
            if (i[0] <= end) {
                end = Math.max(end, i[1]);
            } else {
                ans.add(new int[] { start, end });
                start = i[0];
                end = i[1];
            }
        }
        ans.add(new int[] { start, end });
        return ans.toArray(new int[0][]);
    }

    // driver code
    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 1, 4 }, { 2, 6 }, { 15, 18 }, { 8, 10 } };

        int[][] mergedIntervals = merge(intervals);

        for (int i = 0; i < mergedIntervals.length; i++) {
            for (int j = 0; j < mergedIntervals[0].length; j++) {
                System.out.print(mergedIntervals[i][j] + " ");
            }
            System.out.print("  ");
        }

    }
}
