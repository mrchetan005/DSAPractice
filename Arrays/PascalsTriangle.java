package Arrays;

import java.util.*;

public class PascalsTriangle {

    public static int PascalTriangleValue(int row, int col) {
        // tc => O(col) sc => O(1)
        /*
         * 4C1 = 4/1
         * 4C2 = 4*3/1*2
         * 4C3 = 4*3*2/1*2*3
         * 4C4 = 4*3*2*1/1*2*3*4
         * So we can find any value of nCr like above pattern
         * nCr = n*(n-1)*(n-2)*...*(n-r+1) / 1*2*3*...*r
         */

        int res = 1;
        // as we are assuming 0 based indices for row and col we'll reduce it by 1
        row--;
        col--;
        for (int i = 0; i < col; i++) {
            res *= row - i;
            res /= i + 1;
        }
        return res;
    }

    public static int[] PascalTriangleRow(int n) {
        // tc => O(n^2) sc => O(n)
        int[] row = new int[n];
        for (int i = 0; i < n; i++) {
            int col = 1;
            for (int j = 0; j < i; j++) {
                col *= n - 1 - j;
                col /= j + 1;
            }
            row[i] = col;
        }
        return row;
    }

    /*
     * LEETCODE: 118. Pascal's Triangle
     * 
     * Problem Statement: Given an integer numRows, return the first numRows of
     * Pascal's triangle.
     * 
     * Example 1:
     * Input: numRows = 5
     * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * Example 2:
     * Input: numRows = 1
     * Output: [[1]]
     * 
     * Constraints:
     * 1 <= numRows <= 30
     */

    public static List<List<Integer>> PascalsTriangleList(int n) {
        // tc => O(n^2) sc => O(n^2)
        List<List<Integer>> pascalList = new ArrayList<>();
        // pre = null to avoid initialization error
        List<Integer> row, pre = null;
        for (int i = 0; i < n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    // previous row's (j-1)th col + jth col
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            pascalList.add(row);
        }
        return pascalList;
    }

    // driver code
    public static void main(String[] args) {
        int n = 5;
        System.out.println(PascalTriangleValue(n, 3));
        System.out.println(Arrays.toString(PascalTriangleRow(n)));
        List<List<Integer>> al = PascalsTriangleList(n);
        System.out.println(al);
    }
}
