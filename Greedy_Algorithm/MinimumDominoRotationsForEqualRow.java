package Greedy_Algorithm;

/*
        * LEETCODE: 1007. Minimum Domino Rotations For Equal Row
        * https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
 */

public class MinimumDominoRotationsForEqualRow {
    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int cntTop[] = new int[7], cntBottom[] = new int[7], cntSame[] = new int[7];
        int n = tops.length;
        for (int i = 0; i < n; i++) {
            cntTop[tops[i]]++;
            cntBottom[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                cntSame[tops[i]]++;
            }
        }
        for (int i = 1; i < 7; i++) {
            if (cntTop[i] + cntBottom[i] - cntSame[i] == n) {
                return (cntTop[i] < cntBottom[i] ? cntTop[i] : cntBottom[i]) - cntSame[i];
            }
        }
        return -1;
    }

    // driver code
    public static void main(String[] args) {
        int[] tops = { 2, 1, 2, 4, 2, 2 };
        int[] bottoms = { 5, 2, 6, 2, 3, 2 };
        System.out.println(minDominoRotations(tops, bottoms));
    }
}
