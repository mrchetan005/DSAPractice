package Arrays;

import java.util.*;

/*
        * LEETCODE: 78. Subsets
        * https://leetcode.com/problems/subsets/
 */

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length, lim = 1 << n;
        for (int i = 0; i < lim; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (((1 << j) & i) != 0) {
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }

    // driver code
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21 };
        List<List<Integer>> list = subsets(nums);
        System.out.println(list);
    }
}
