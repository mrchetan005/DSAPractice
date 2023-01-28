package Binary_Search;

/*
        * Problem Statement: You are given two positive integers N and M. You have to find the Nth root of M i.e. M^(1/N)
        Suggest Edit
        Note:
        N'th root of an integer M is a real number, which when raised to the power N gives M as a result.
        N'th root of the m should be correct up to 6 decimal places.
 */

/*
       * simply taking pow function Math.pow(m,1.0/n) will give the answer, but we are not supposed to that
       * decide a range which is monotonically increasing so that we can apply binary search
       * start from 1 and max value of any root can be go upto m only
       * to find the nth root upto 6 decimal places, so we'll take epsilon value as 1e-8 just for safer side
       * So for that we'll find difference between our range is greater than epsilon value or not
       * now find mid and check nth power of mid is less than m or greater than m, according to that shrink the range to the mid and at the end of loop return the low
       * We can use inbuilt function or own function to find the nth power of mid which will take the time complexity as Log(n) * Log(m * 10^d) ...(log(n) for finding nth power and log(m * 10^d) for binary search  and that d is to find upto d decimal places)
 */

public class NthRootOfM {
    public static double myPow(double x, int n) {
        // tc => O(log(n)) & sc => O(1)
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = 1.0;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1;
        }
        return ans;
    }

    public static double findNthRootOfM(int n, int m) {
        // tc => O(log(n)*log(m*10^d)) & sc => O(1)
        double low = 1;
        double high = m;
        double eps = 1e-8;
        while ((high - low) > eps) {
            double mid = (low + high) / 2.0;
            // use inbuilt function or use our own function for finding nth power
            // if (Math.pow(mid, n) < m) {
            if (myPow(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // driver code
    public static void main(String[] args) {
        System.out.printf("%.6f\n", Math.pow(15.0, 1.0 / 4));
        System.out.printf("%.6f\n", findNthRootOfM(4, 15));
        System.out.printf("%.6f\n", findNthRootOfM(3, 27));
    }
}
