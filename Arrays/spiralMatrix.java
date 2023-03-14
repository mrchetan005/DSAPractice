package Arrays;

import java.util.*;

/*
        * LEETCODE : 54. Spiral Matrix
        * https://leetcode.com/problems/spiral-matrix
 */

public class spiralMatrix {
    public static List<Integer> spiralOrder(int[][] mat) {
        // tc => O(n^2) & sc => O(n) . . .(for answer) else sc => O(1)
        List<Integer> ans = new ArrayList<>();

        int n = mat.length, m = mat[0].length, minc = 0, minr = 0, maxc = m - 1, maxr = n - 1;

        while (minc <= maxc && minr <= maxr) {

            // min row traversal
            for (int i = minc; i <= maxc; i++) {
                ans.add(mat[minr][i]);
            }

            // work of min row is over so get rid of it
            minr++;

            // max column traversal
            for (int i = minr; i <= maxr; i++) {
                ans.add(mat[i][maxc]);
            }

            // work of max column is over so get rid of it
            maxc--;

            // max row traversal
            for (int i = maxc; i >= minc && minr <= maxr; i--) {
                ans.add(mat[maxr][i]);
            }

            // work of max row is over so get rid of it
            maxr--;

            // min column traversal
            for (int i = maxr; i >= minr && minc <= maxc; i--) {
                ans.add(mat[i][minc]);
            }

            // work of min column is over so get rid of it
            minc++;
        }
        return ans;
    }

    // driver code
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(spiralOrder(matrix));
    }
}
