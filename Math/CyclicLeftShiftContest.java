package Math;

import java.util.*;

/*
        * Newton School Contest Question
        * Cyclic Left Shift (medium)
        * Problem Statement
            Given a number N in decimal form, you have to cyclically rotate left the binary representation of number N in 31 bit, you get the maximum number that can be formed.
            Note:- All the leftover bits in binary representation of N are filled with zeroes i.e binary representation of 4 will be :- 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0
        * Input
            The input contains T, denoting the number of testcases. Each testcase contains a number N.
        * Constraints:
            1 <= T <= 100
            1 <= N <= (2^32)-1
        * Output
            For each testcase in new line print the maximum number formed.
        * Example
            Input:
                2
                1
                0
            Output:
                2147483648
                0
            Explanation:
                Test case 1:- The binary representation of 1 is 0 0 0 . . . . . 1 when we make a cyclic shift to the left the number will become 1 0 0 0 0.......... 0 0 0 0. which is the maximum number that can be formed.
                Test case 2:- The binary representation of 0 is 0, even if we left shift its binary numbers we still get 0 for that.
                Generate 
 */

public class CyclicLeftShiftContest {

    // time complexity => O(t * 32) ~ O(n) and space complexity => O(32)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            // create an array of length 32 containing '0' as default value
            char[] binArr = new char[32];
            for (int i = 0; i < 32; i++) {
                binArr[i] = '0';
            }

            // convert given number to binary number string
            String binaryStr = decToBin(n);
            int length = binaryStr.length();

            // insert binary number string an array of length 32
            for (int i = 0; i < length; i++) {
                binArr[i] = binaryStr.charAt(i);
            }

            // now iterate 32 times and find all possible
            // numbers after rotating by one
            long maxNumber = binToDec(binArr);
            for (int i = 0; i < length; i++) {
                // rotate by one
                rotateLeftByOne(binArr);
                // find max number
                maxNumber = Math.max(maxNumber, binToDec(binArr));
            }

            System.out.println(maxNumber);
        }
        sc.close();
    }

    private static void rotateLeftByOne(char[] arr) {
        char temp = arr[0];
        for (int j = 0; j < arr.length - 1; j++) {
            arr[j] = arr[j + 1];
        }
        arr[arr.length - 1] = temp;
    }

    private static String decToBin(int n) {
        StringBuilder binaryString = new StringBuilder();
        while (n > 0) {
            binaryString.append(n % 2);
            n /= 2;
        }
        return binaryString.reverse().toString();
    }

    private static long binToDec(char[] arr) {
        long decimalValue = 0;
        for (int i = arr.length - 1, power = 0; i >= 0; i--, power++) {
            decimalValue += (arr[i] - '0') * myPow(2, power);
        }
        return decimalValue;
    }

    private static long myPow(int num, int power) {
        if (power == 0) {
            return 1;
        }
        long res = myPow(num, (power >> 1));
        return ((power & 1)) == 0 ? (res * res) : (num * res * res);
    }
}
