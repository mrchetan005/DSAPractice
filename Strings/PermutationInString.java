package Strings;

import java.util.*;

/* 
    LEETCODE: 567. Permutation in String

    Problem Statement:

    Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

    In other words, return true if one of s1's permutations is the substring of s2.

    Example 1:

    Input: s1 = "ab", s2 = "eidbaooo"
    Output: true
    Explanation: s2 contains one permutation of s1 ("ba").
    Example 2:

    Input: s1 = "ab", s2 = "eidboaoo"
    Output: false
    

    Constraints:

    1 <= s1.length, s2.length <= 104
    s1 and s2 consist of lowercase English letters.

*/

/*
 * Same as Find All Anagrams In String problem
 * Sliding Window will be used to check permutations using frequency arrays of length 123 of both strings 
 */

public class PermutationInString {
    private boolean areEqual(int[] a, int[] b) {
        for (int i = 0; i < 123; i++) {
            if (a[i] != b[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        int[] str1 = new int[123];
        for (char c : s1.toCharArray()) {
            str1[c]++;
        }
        int[] str2 = new int[123];
        int i = 0, j = 0;
        while (j < s2.length()) {
            str2[s2.charAt(j)]++;
            // sliding window of s1 string length
            if (j - i + 1 == s1.length()) {
                if (areEqual(str1, str2)) {
                    return true;
                }
            }
            if (j - i + 1 < s1.length()) {
                j++;
            } else {
                str2[s2.charAt(i)]--;
                i++;
                j++;
            }
        }
        return false;
    }

    // driver code:

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        PermutationInString obj = new PermutationInString();
        System.out.println(obj.checkInclusion(s1, s2));
        sc.close();
    }
}
