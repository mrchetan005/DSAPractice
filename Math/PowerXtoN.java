package Math;

/*
        * LEETCODE: Pow(x, n)
        * Problem Statement: Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
        Example 1:
            Input: x = 2.00000, n = 10
            Output: 1024.00000
        Example 2:
            Input: x = 2.10000, n = 3
            Output: 9.26100
        Example 3:
            Input: x = 2.00000, n = -2
            Output: 0.25000
            Explanation: 2-2 = 1/22 = 1/4 = 0.25
        Constraints:
            -100.0 < x < 100.0
            -2^31 <= n <= 2^31-1
            n is an integer.
            -10^4 <= x^n <= 10^4
 */

/*
       * we can do this in two ways iterative as well as recursive
       * iterative way
       * we create ans variable
       * we'll check first if the power is negative or positive
       * if it's negative we'll convert it to positive and inverse the number (x)
       * brute force will be loop till n and take the multiplication of the number n tumes, this will have time complexity O(n) 
       * we can improve by some observation
       * for example, 2^10 = (2*2)^5 = 4^5 = 4*(4*4)^2 = 4*(16)^2 = 4*256 = 1024
       * we can see that when power is even we can multiply by number once and divide the power by 2 and when power id odd we can multiply the number with separating the even part and do the even 
       * 
       * recursive way
       * first we'll reach base condition by recusive calling the function with power divided by two, we'll return 1 for n = 0
       * after that we'll check if n is even then simply return the multiplication because it doen't matter whether the number is negative or positive, the multiplication will always be positive for even power
       * else the power is odd, then we'll check for the power is negative or positive
       * if power is negative we'll 
       
*/

/*
        * Modular Exponentiation
        
        * Problem Statement: You are given a three integers 'N', and 'M'. Your task is to find % A A B is defined as A raised to power B and A % C is the remainder when A is divided by C. 

        * this is similar to the previous question we're just returning the value taking the modulus of the multiplication 
 */

public class PowerXtoN {
    public static double myPow(double x, int n) {
        // iterative
        double ans = 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
            }
            x *= x;
            n >>= 1; // 101 n>>1 => 10 => 1 =>
        }
        return ans;

        // recursive
        // if (n == 0)
        // return 1;
        // double p = myPow(x, (n >> 1));
        // if ((n & 1) == 0)
        // return p * p;
        // return (n < 0) ? 1 / x * p * p : x * p * p;
    }

    public static int modularExponentiation(int x, int n, int m) {
        // iterative
        long ans = 1, X = x;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans = (ans * X) % m;
            }
            X = (X * X) % m;
            n >>= 1;
        }
        return (int) ans;

        // recursive
        // long pow = myPow((long) x, n, m);
        // return (int) (pow % m);
    }

    // method overloading of myPow function
    public static long myPow(long x, int n, int m) {
        if (n == 0) {
            return 1;
        }
        long p = myPow(x, (n >> 1), m);
        return ((n & 1) == 0) ? (p * p) % m : (((x * p) % m) * (p % m)) % m;
    }

    // driver code
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(myPow(x, n));
        int X = 2, m = 1000000007;
        System.out.println(modularExponentiation(X, n, m));
    }
}
