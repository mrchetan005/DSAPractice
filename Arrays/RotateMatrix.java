package Arrays;

/*
        * LEETCODE: 48. Rotate Image
        * Problem Statement: You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

        Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [[7,4,1],[8,5,2],[9,6,3]]
        Example 2:
        Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
        Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        
        Constraints:
            n == matrix.length == matrix[i].length
            1 <= n <= 20
            -1000 <= matrix[i][j] <= 1000
 */

/*
       * Two steps process for n*n matrix
       * take Transpose of matrix, basically swap rows to cols and vise versa
       * Reverse the columns to rotate clockwise
       * Or reverse the rows to rotate anti-clockwise
 */

public class RotateMatrix {
    public static void rotateClockwise(int[][] matrix) {
        // tc => O(n^2) sc => O(1)
        int n = matrix.length;
        // transpose of matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse columss for clockwise
        for (int row = 0; row < n; row++) {
            int leftCol = 0, rightCol = n - 1;
            while (leftCol < rightCol) {
                int temp = matrix[row][leftCol];
                matrix[row][leftCol++] = matrix[row][rightCol];
                matrix[row][rightCol--] = temp;
            }
        }
    }

    public static void rotateAntiClockwise(int[][] matrix) {
        // tc => O(n^2) sc => O(1)
        int n = matrix.length;
        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // reverse rows for anti-clockwise
        for (int col = 0; col < n; col++) {
            int topRow = 0, bottomRow = n - 1;
            while (topRow < bottomRow) {
                int temp = matrix[topRow][col];
                matrix[topRow++][col] = matrix[bottomRow][col];
                matrix[bottomRow--][col] = temp;
            }
        }
    }

    // driver code
    public static void main(String[] args) {
        int n = 3;
        int[][] mat = new int[n][n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ++temp;
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        rotateClockwise(mat);
        System.out.println("----------------");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        rotateAntiClockwise(mat);
        System.out.println("----------------");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

    }
}
