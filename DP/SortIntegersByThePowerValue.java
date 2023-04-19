package DP;

import java.util.*;

/*
        * LEETCODE: 1387. Sort Integers by The Power Value
        * https://leetcode.com/problems/sort-integers-by-the-power-value/
 */

public class SortIntegersByThePowerValue {
    private static int[] dp = new int[1000000];

    private static int findPower(int num) {
        if (num == 1) {
            return 0;
        }
        if (dp[num] != 0) {
            return dp[num];
        }
        dp[num] = 1 + ((num & 1) == 0 ? findPower(num / 2) : findPower(num * 3 + 1));
        return dp[num];
    }

    public static int getKth(int lo, int hi, int k) {
        int[][] powers = new int[hi - lo + 1][2];
        for (int i = 0; i < powers.length; i++) {
            powers[i][0] = lo;
            powers[i][1] = findPower(lo++);
        }
        Arrays.sort(powers, (a, b) -> a[1] - b[1]);
        return powers[k - 1][0];
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(getKth(37, 110, 46));
    }
}
