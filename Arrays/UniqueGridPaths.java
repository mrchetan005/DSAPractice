package Arrays;

/*
        * LEETCODE: 62. Unique Paths
        * Problem Statement: There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
        Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
        The test cases are generated so that the answer will be less than or equal to 2 * 109.
        Example 1:
            Input: m = 3, n = 7
            Output: 28
        Example 2:
            Input: m = 3, n = 2
            Output: 3
            Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
            1. Right -> Down -> Down
            2. Down -> Down -> Right
            3. Down -> Right -> Down
        Constraints:
            1 <= m, n <= 100
 */

/*
    * In brute force solution we want to increment the either row or column as per the condition given
    * we'll call recursively with row increment plus the recursive call with column increment 
    * if we reach row-1 and col-1 we'll return one because we've reached at the end 
    * if we reach at row or at col then it will be go beyond our end position so we'll return zero
    

    * We can improve this code with dynamic programming, we know that many paths were repeating during the recursive call, we can store that value and stop the recursivve call in that position
    * we'll just take m*n table and set all elements to -1
    * if we'll get element equal to -1, we'll continue the recursive call else we'll return that element only
    

    * Well there's one more optimal solution for this question...
    * If we'll observe the paths, we'll find some combinations are there...
    * for matrix 2*3, we'll always have to move three steps to reach at end
    * we have to take moves to the right and downwards, so at max we can take right moves are col-1 and down moves are row-1
    * so total number of steps can be (row-1 + col-1) i.e. (row+col-2)
    * now we have col-1 choices to move right or row-1 choices to move down
    * So we know the formula of combinations nCr 
    * we can take either (row+col-2)C(row-1) or we can take (row+col-2)C(col-1)
 */

public class UniqueGridPaths {
    public static int pathsRecursiveDP(int m, int n, int i, int j, int[][] dp) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        else
            return dp[i][j] = pathsRecursiveDP(m, n, i + 1, j, dp) + pathsRecursiveDP(m, n, i, j + 1, dp);
    }

    public static int pathsRecursive(int m, int n, int i, int j) {
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (i >= m || j >= n) {
            return 0;
        }
        return pathsRecursive(m, n, i + 1, j) + pathsRecursive(m, n, i, j + 1);
    }

    public static int uniquePaths(int m, int n) {
        // brute force recursive
        // tc => O(2^n) sc => O(2^n)
        // return pathsRecursive(m, n, 0, 0);

        // better dynamic programming
        // tc => O(n*m) & sc => O(n*m)
        // int[][] dp = new int[m][n];
        // for (int i = 0; i < m; i++) {
        // for (int j = 0; j < n; j++) {
        // dp[i][j] = -1;
        // }
        // }
        // return pathsRecursiveDP(m, n, 0, 0, dp);

        // optimal solution
        // using combinatorics
        // tc => O(m) sc => O(1)
        int N = m + n - 2;
        int r = m - 1;
        long res = 1;
        // using formula nCr = 10C3 = 10*9*8/1*2*3
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }

    // driver code
    public static void main(String[] args) {
        int m = 3, n = 7;
        System.out.println(uniquePaths(m, n));
    }
}
