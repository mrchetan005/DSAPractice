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
    private boolean areEqual(int[] a, int[] b) {
        for (int i = 0; i < 123; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> al = new ArrayList<>();
        int[] freqP = new int[123];
        for (char c : p.toCharArray()) {
            freqP[c]++;
        }
        int[] freqS = new int[123];
        int l = 0, r = 0;
        while (r < s.length()) {
            freqS[s.charAt(r)]++;
            if (r - l + 1 == p.length()) {
                if (areEqual(freqP, freqS)) {
                    al.add(l);
                }
            }
            if (r - l + 1 < p.length()) {
                r++;
            } else {
                freqS[s.charAt(l)]--;
                l++;
                r++;
            }
        }
        return al;
    }

    // driver code
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        FindAllAnagramsInString obj = new FindAllAnagramsInString();
        List<Integer> al = obj.findAnagrams(s, p);
        System.out.println(al);
        sc.close();
    }
}
