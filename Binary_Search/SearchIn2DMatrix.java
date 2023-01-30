package Binary_Search;

/*
        * LEETCODE: 74. Search a 2D Matrix
        * https://leetcode.com/problems/search-a-2d-matrix
 */

/*
       * simple binary search can be applied here
       * just take 0th element as low and m*n-1 th element as high
       * and we can convert m*n to matrix indices arr[m][n] using modulo
       * if we divide by n we'll get n and if we take mod with n we'll get n
 */

/*
       * LEETCODE: Search a 2D Matrix II
       * https://leetcode.com/problems/search-a-2d-matrix-ii
 */

/*
       * In this problem we can search in every row with binary search
       * So this will take O(rowlog(col)) time complexity, but as per the problem we know matrix is sorted row wise as well as column wise then we can reduce time complexity to O(row+col)
       * start from right top corner (matrix[0][col-1]) and check that 
 */

public class SearchIn2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = n * m - 1, mid = 0;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            int midX = mid / n, midY = mid % n;
            int val = matrix[midX][midY];
            if (val == target) {
                return true;
            } else if (target < val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, row = 0, col = m - 1;
        while (row < n && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            }
            if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    // driver code
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 4, 7 },
                { 10, 11, 15 },
                { 17, 21, 25 }
        };
        int[][] matrix2 = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        System.out.println(searchMatrix(matrix, 15));
        System.out.println(searchMatrix2(matrix2, 5));
    }
}
