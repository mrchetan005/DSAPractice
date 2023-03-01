package Strings;

import java.util.*;

/*
    LEETCODE: 438. Find All Anagrams in a String

    Problem Statement : 
    Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Example 1:

    Input: s = "cbaebabacd", p = "abc"
    Output: [0,6]
    Explanation:
    The substring with start index = 0 is "cba", which is an anagram of "abc".
    The substring with start index = 6 is "bac", which is an anagram of "abc".
    Example 2:

    Input: s = "abab", p = "ab"
    Output: [0,1,2]
    Explanation:
    The substring with start index = 0 is "ab", which is an anagram of "ab".
    The substring with start index = 1 is "ba", which is an anagram of "ab".
    The substring with start index = 2 is "ab", which is an anagram of "ab".
    
    Constraints:

    1 <= s.length, p.length <= 3 * 104
    s and p consist of lowercase English letters.
 */

/*
    * pseudo code
    * create arraylist to store ans
    * create string s freq array of length 123 as all letters are lowercase only
    * increment index of char in freq array
    * create string p freq array of length 123 as well
    * take two pointers l & r for sliding window approach
    * start iterating r upto p's length 
    * add char at r to the freq array for string s
    * if (r-l+1) is equal to p's length now check that all elements in freq array of p and s are equal or not if yes then add l (left pointer) in arraylist
    * if (r-l+1) will be greater than p's length then increment r pointer 
    * if (r-l+1) will be greater than p's length we'll remove the char at l and increment both l and r
 */

public class FindAllAnagramsInString {
    private static boolean isAnagram(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] pFreq = new int[26];
        int[] sFreq = new int[26];
        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }
        char[] str = s.toCharArray();
        int l = 0, r = 0, n = str.length, m = p.length();
        while (r < n) {
            sFreq[str[r] - 'a']++;
            if ((r - l + 1) == m) {
                if (isAnagram(pFreq, sFreq)) {
                    res.add(l);
                }
                sFreq[str[l] - 'a']--;
                l++;
            }
            r++;
        }
        return res;
    }

    // driver code
    public static void main(String[] args) {
        List<Integer> list = findAnagrams("cbaebabacd", "abc");
        System.out.println(list);
        List<Integer> list1 = findAnagrams("abab", "ab");
        System.out.println(list1);
    }
}
