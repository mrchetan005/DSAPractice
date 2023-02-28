package Binary_Search;

/*
        * LEETCODE: 875. Koko Eating Bananas
        * https://leetcode.com/problems/koko-eating-bananas/
 */

public class KokoEatingBananas {

    // check for the k bananas per pile can finish
    // all the bananas within required hours
    public static boolean canFinish(int[] piles, int k, int h) {
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHours += piles[i] / k + (piles[i] % k != 0 ? 1 : 0);
            // if total hrs to finish are greater than required
            // then condition will be false
            if (totalHours > h) {
                return false;
            }
        }
        return true;
    }

    // find maximum possible number of bananas
    public static int upperBound(int piles, int h, long total) {
        total -= (piles - 1);
        h -= (piles - 1);
        return (int) Math.ceil(total * 1.0 / h);
    }

    // find minimum possible number of bananas
    public static int lowerBound(long total, int h) {
        return (int) (total / h);
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for (int i : piles) {
            total += i;
        }
        // binary search on answer
        int l = Math.max(1, lowerBound(total, h));
        int r = upperBound(n, h, total);
        while (l < r) {
            int mid = (l + r) / 2;
            if (canFinish(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    // driver code
    public static void main(String[] args) {
        int[] piles = { 30, 11, 23, 4, 20 };
        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }
}
