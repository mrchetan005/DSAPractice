package Math;

/*
        * LEETCODE : 1492. The Kth Factor of n
        * https://leetcode.com/problems/the-kth-factor-of-n/
 */

public class TheKthFactorOfN {
    public static int kthFactor(int n, int k) {
        int i = 1, lim = (int) Math.sqrt(n);

        // first half factors of n
        for (; i <= lim; i++) {
            if (n % i == 0 && --k == 0) {
                return i;
            }
        }

        // remaining half factors of n
        for (i -= 1; i >= 1; i--) {
            if (i * i == n)
                continue;
            if (n % i == 0 && --k == 0) {
                return n / i;
            }
        }
        return -1;
    }

    // driver code
    public static void main(String[] args) {
        System.out.println(kthFactor(12, 3));
        System.out.println(kthFactor(7, 2));
        System.out.println(kthFactor(4, 4));
    }
}
