package Arrays;

import java.util.*;

/*
    LEETCODE: 73. Set Matrix Zeroes

    Problem Statement:
    Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

    You must do it in place.

    Example 1:

    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[1,0,1],[0,0,0],[1,0,1]]
    Example 2:

    Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    
    Constraints:

    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -231 <= matrix[i][j] <= 231 - 1
    
    Follow up:

    A straightforward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
 */

class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        // tc => O(n * m) && sc => O(1)
        int n = matrix.length, m = matrix[0].length, firstCol = 1;
        // using dummy positions - first row and first column
        // converting first value to 0 for both row and column
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0)
                firstCol = 0;
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // start checking from backside and convert to zero with help of dummy positions
        // - first row and first column
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            // if first column is 0, we'll set it as 0
            // because we're not checking that column because it's being used to store dummy
            // positions, so we made a constant variable first col to store if it has value
            // 0, we'll set it to 0
            if (firstCol == 0)
                matrix[i][0] = 0;
        }
    }

    public static void setZeroes1(int[][] matrix) {
        // tc => O(n * m) && sc => O(n + m)
        // creating two boolean arrays to keep track of zeroes in rows and columns
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                matrix[i][j] = sc.nextInt();
        }

        setZeroes(matrix);
        // setZeroes1(matrix);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
        sc.close();
    }
}