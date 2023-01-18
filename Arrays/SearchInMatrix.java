package Arrays;

/*
    * GFG: Search In A Matrix

    * Problem Statement: Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not.
    Example 1:
    Input:
    N = 3, M = 3
    mat[][] = 3 30 38 
    44 52 54 
    57 60 69
    X = 62
    Output: 0
    Explanation: 62 is not present in the matrix, so output is 0
    Example 2:
    Input: N = 1, M = 6
    mat[][] = 18 21 27 38 55 67
    X = 55
    Output: 1
    Explanation: 55 is present in the matrix at 5th cell.
    
    Your Task: You don't need to read input or print anything. You just have to complete the function matSearch() which takes a 2D matrix mat[][], its dimensions N and M and integer X as inputs and returns 1 if the element X is present in the matrix and 0 otherwise.
    
    Expected Time Complexity: O(N+M).
    Expected Auxiliary Space: O(1).
    Constraints:
    1 <= N, M <= 1005
    1 <= mat[][] <= 10000000
    1<= X <= 10000000
*/

/*
    * if the matrix is sorted in row wise and column wise differently then
    * start traversing from top right of matrix, i.e. from last col of first row
    * if element is equal to target return true
    * if element is less than target move to next row else move to the previous column
    * this will take O(n+m) time complexity and O(1) space complexity
*/

/*
    * LEETCODE: Search In A 2D Matrix
    * Problem Statement: You are given an m x n integer matrix matrix with the following two properties:
    Each row is sorted in non-decreasing order.
    The first integer of each row is greater than the last integer of the previous row.
    Given an integer target, return true if target is in matrix or false otherwise.
    You must write a solution in O(log(m * n)) time complexity.

    Example 1:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
        Output: true
    Example 2:
        Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
        Output: false
    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 100
        -10^4 <= matrix[i][j], target <= 10^4
*/

/*
    * if matrix is sorted like first integer of row is greater than last integer of previous row we'll use binary search here
    * take left and right as 0 and (row*col-1) and find mid 
    * now find the row as well as col value of mid 
    * by taking mid/col we'll get row and taking mid%col we'll get col
    * now check if the target is at mat[row][col] return true
    * if the target is less than mat[row][col] then move right to mid - 1
    * else move left to mid + 1
    * after end of the loop if target is not present we'll return false
 */

public class SearchInMatrix {
    public static boolean matSearchSortedByRowAndCol(int[][] mat, int n, int m, int x) {
        // tc => O(n+m) sc => O(1)
        int row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true;
            }
            if (mat[row][col] < x) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public static boolean matSearchSorted(int[][] mat, int n, int m, int x) {
        // tc => O(n*m) sc => O(1)
        int left = 0, right = m - 1, mid = 0;
        while (left <= right) {
            mid = (left + right) >> 1;
            int row = mid / m, col = mid % m;
            if (mat[row][col] == x) {
                return true;
            }
            if (mat[row][col] < x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    // driver code
    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] mat = {
                { 3, 30, 38 },
                { 44, 52, 54 },
                { 57, 60, 69 }
        };
        int x = 62;
        System.out.println(matSearchSortedByRowAndCol(mat, n, m, x));
        int[][] mat1 = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int n1 = 3, m1 = 4, x1 = 3;
        System.out.println(matSearchSorted(mat1, n1, m1, x1));
    }
}
